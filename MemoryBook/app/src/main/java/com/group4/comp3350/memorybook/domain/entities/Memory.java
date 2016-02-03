package com.group4.comp3350.memorybook.domain.entities;

/**
 * Created by Bennet on 2/2/2016.
 */
public class Memory {

    private long id;
    private String title;

    public Memory(String title) {
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
