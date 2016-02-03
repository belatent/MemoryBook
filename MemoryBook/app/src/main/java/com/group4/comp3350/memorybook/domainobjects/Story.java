package com.group4.comp3350.memorybook.domainobjects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Chad on 2/2/2016.
 */
public class Story {
    private int id = -1;
    private String title;
    private HashMap<Integer, Memory> memories;

    public Story(String title) {
        this.title = title;
        this.memories = new HashMap<Integer, Memory>();
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
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
