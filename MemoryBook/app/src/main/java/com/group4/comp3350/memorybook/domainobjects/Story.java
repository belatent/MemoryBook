package com.group4.comp3350.memorybook.domainobjects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Chad on 2/2/2016.
 */
public class Story {
    private long id = -1;
    private String title;
    private String description; // summary of story/events
    private HashMap<Long, Memory> memories;

    public Story(String title, String description) {
        this.title = title;
        this.description = description;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
