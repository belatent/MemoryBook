package com.group4.comp3350.memorybook.domain.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Chad on 2/2/2016.
 */
public class Story {
    private long id = -1;
    private String title;
    private HashMap<Long, Memory> memories;

    public Story(String title) {
        this.title = title;
        this.memories = new HashMap<Long, Memory>();
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void add(Memory memory) {
        this.memories.put(memory.getId(), memory);
    }

    public void remove(Memory memory) {
        this.memories.remove(memory.getId());
    }

    public List<Memory> getMemories() {
        return new ArrayList<Memory>(memories.values());
    }
}
