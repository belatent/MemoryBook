package com.group4.comp3350.memorybook.persistence;

import com.group4.comp3350.memorybook.domainobjects.Mood;

import java.util.List;

/**
 * Created by Chad on 2016-02-02.
 */
public interface MoodRepository {

    public List<Mood> getAll();

}
