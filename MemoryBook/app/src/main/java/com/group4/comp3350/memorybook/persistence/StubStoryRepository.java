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
        if(story != null){
            if(story.getId() != -1){
                // we are updating an existing story
                storyTable.put(storyIdCount, story);
            } else {
                // we are saving a new story
                story.setId(storyIdCount);
                storyTable.put(storyIdCount, story);
                storyIdCount++;
            }
        } else {
            throw new NullPointerException();
        }
        return story;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteStory(Story storyToDelete) throws PersistenceException{
        if(storyToDelete != null){
            if(storyTable.contains(storyToDelete.getId())){
                storyTable.remove(storyToDelete.getId());
            } else {
                Log.v(TAG, "Story not found");
                throw new PersistenceException("Failed to Store Story, Story not found");
            }
        } else {
            throw new NullPointerException();
        }
    }
}
