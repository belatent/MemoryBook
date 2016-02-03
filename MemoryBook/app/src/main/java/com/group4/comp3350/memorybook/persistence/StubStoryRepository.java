package com.group4.comp3350.memorybook.persistence;

import android.util.Log;

import com.group4.comp3350.memorybook.domainobjects.Story;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Created by Bennet on 2/2/2016.
 */
public class StubStoryRepository implements StoryRepository{

    private static final String TAG = "StubStoryRepository";
    private long storyIdCount;
    private Hashtable<Long, Story> storyTable;

    public StubStoryRepository() {
        this.storyTable = new Hashtable<Long, Story>();
        this.storyIdCount = 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ArrayList<Story> getAllStories() throws PersistenceException{
        return new ArrayList<Story>(storyTable.values());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Story storeStory(Story story) throws PersistenceException{
        try {
            story.setId(storyIdCount);
            storyTable.put(storyIdCount, story);
            storyIdCount++;
        } catch (NullPointerException e){
            Log.v(TAG, "Failed to Store Story");
            throw new PersistenceException("Failed to Store Story, NullPointer");
        }
        return story;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteStory(Story storyToDelete) throws PersistenceException{
        try {
            if(storyTable.contains(storyToDelete.getId())){
                storyTable.remove(storyToDelete.getId());
            } else {
                Log.v(TAG, "Story not found");
                throw new PersistenceException("Failed to Store Story, Story not found");
            }
        } catch (NullPointerException e){
            Log.v(TAG, "Failed to Delete Story");
            throw new PersistenceException("Failed to Delete Story, NullPointer");
        }
    }
}
