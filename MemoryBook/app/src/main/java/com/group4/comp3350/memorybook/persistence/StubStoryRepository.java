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
     * getAllStories
     * @return - returns an ArrayList of all Stories
     */
    @Override
    public ArrayList<Story> getAllStories(){
        return new ArrayList<Story>(storyTable.values());
    }

    /**
     * addStory
     * @param newStory the new Story to be added
     * @return - returns storyId of the new Story, -1 if error occurred
     */
    @Override
    public long addStory(Story newStory) {
        long rc = -1;
        try {
            storyTable.put(storyIdCount, newStory);
            storyIdCount++;
            rc = storyIdCount;
        } catch (NullPointerException e){
            Log.v(TAG, "Failed to Add Story");
        }
        return rc;
    }

    /**
     * updateStory
     * @param updatedStory the updated version of the Story
     * @return - returns number of stories updated
     */
    @Override
    public int updateStory(Story updatedStory)  {
        int rc = 0;
        try {
            if(storyTable.contains(updatedStory.getId())){
                storyTable.put(updatedStory.getId(), updatedStory);
                rc = 1;
            } else {
                Log.v(TAG, "Story not found");
            }
        } catch (NullPointerException e){
            Log.v(TAG, "Failed to Update Story");
        }
        return rc;
    }

    /**
     * deleteStory
     * @param storyToDelete the story to be deleted
     * @return - returns number of stories deleted
     */
    @Override
    public int deleteStory(Story storyToDelete){
        int rc = 0;
        try {
            if(storyTable.contains(storyToDelete.getId())){
                storyTable.remove(storyToDelete.getId());
                rc = 1;
            } else {
                Log.v(TAG, "Story not found");
            }
        } catch (NullPointerException e){
            Log.v(TAG, "Failed to Delete Story");
        }
        return rc;
    }
}
