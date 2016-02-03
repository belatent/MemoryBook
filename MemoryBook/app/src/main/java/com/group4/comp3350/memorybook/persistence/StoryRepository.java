package com.group4.comp3350.memorybook.persistence;

import com.group4.comp3350.memorybook.domainobjects.Story;

import java.util.ArrayList;

/**
 * Created by Bennet on 2/2/2016.
 */
public interface StoryRepository {

    public ArrayList<Story> getAllStories();
    public long addStory(Story newStory);
    public int updateStory(Story updatedStory);
    public int deleteStory(Story storyToDelete);
}
