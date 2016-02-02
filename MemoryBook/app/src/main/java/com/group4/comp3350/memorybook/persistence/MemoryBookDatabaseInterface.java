package com.group4.comp3350.memorybook.persistence;

import com.group4.comp3350.memorybook.domainobjects.Memory;
import com.group4.comp3350.memorybook.domainobjects.Story;

import java.util.ArrayList;

/**
 * Created by Bennet on 2/2/2016.
 */
public interface MemoryBookDatabaseInterface {

    public ArrayList<Memory> getAllMemories();
    public long addMemory(Memory newMemory);
    public int deleteMemory(long memoryId);


    public ArrayList<Story> getAllStories();
    public long addStory(Story newStory);
    public int updateStory(long storyId, Story updatedStory);
    public int deleteStory(long storyId);

}
