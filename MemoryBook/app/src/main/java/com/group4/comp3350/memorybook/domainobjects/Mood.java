package com.group4.comp3350.memorybook.domainobjects;

/**
 * Created by Chad on 2016-02-02.
 */
public class Mood {

    private final long id;
    private final String name;
    private final String iconPath;

    public Mood(long id, String name, String iconPath) {
        this.id = id;
        this.name = name;
        this.iconPath = iconPath;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getIconPath() {
        return iconPath;
    }
}
