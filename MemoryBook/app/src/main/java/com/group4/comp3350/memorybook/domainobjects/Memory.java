package com.group4.comp3350.memorybook.domainobjects;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Bennet on 2/2/2016.
 */
public class Memory {

    private long id;
    private String title;
    private String description; // summary of memory/event
    private Set<Mood> moods;

    public Memory(String title, String description) {
        this.title = title;
        this.description = description;
        this.moods = new HashSet<Mood>();
    }

    // lets us build a memory via setters
    public Memory() {
        this(null, null);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void addMood(Mood mood) {
        moods.add(mood);
    }

    public void removeMood(Mood mood) {
        moods.remove(mood);
    }

    public Set<Mood> getMoods() {
        return moods;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        // TODO: max length?

        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        // TODO: max length?

        this.description = description;
    }
}
