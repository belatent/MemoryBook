package com.group4.comp3350.memorybook.domainobjects;

/**
 * Created by Bennet on 2/2/2016.
 */
public class Memory {

    private int id;
    private String title;

    public Memory(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
