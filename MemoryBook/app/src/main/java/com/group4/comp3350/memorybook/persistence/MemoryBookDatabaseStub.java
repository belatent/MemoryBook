package com.group4.comp3350.memorybook.persistence;

import android.util.Log;

import com.group4.comp3350.memorybook.domainobjects.Memory;
import com.group4.comp3350.memorybook.domainobjects.Story;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

/**
 * Created by Bennet on 2/2/2016.
 */
public class MemoryBookDatabaseStub implements MemoryBookDatabaseInterface{

    private static final String TAG = "MemoryBookDatabaseStub";
    private Hashtable<Long, Memory> memoryTable;
    private Hashtable<Long, Story> storyTable;
    private long memoryIdCount;
    private long storyIdCount;

    public MemoryBookDatabaseStub() {
        this.memoryTable = new Hashtable<Long, Memory>();
        this.storyTable = new Hashtable<Long, Story>();

        this.memoryIdCount = 0;
        this.storyIdCount = 0;
    }


    /**
     * getAllMemories
     * @returns an ArrayList of Memories
     */
    @Override
    public ArrayList<Memory> getAllMemories()  {
        return new ArrayList<Memory>(memoryTable.values());
    }

    /**
     * addMemory
     * @param newMemory the new Memory to be added
     * @return - returns the memoryId of the new Memory, -1 if error occurred
     */
    @Override
    public long addMemory(Memory newMemory) {
        long rc = -1;
        try {
            memoryTable.put(memoryIdCount, newMemory);
            memoryIdCount++;
            rc = memoryIdCount;
        } catch (NullPointerException e){
            Log.v(TAG, "Failed to Add Memory");
        }
        return rc;
    }

    /**
     * deleteMemory
     * @param memoryId the memoryId of the Memory to be deleted
     * @return - returns the number of memories deleted
     */
    @Override
    public int deleteMemory(long memoryId) {
        int rc = 0;
        if(memoryTable.contains(memoryId)){
            try {
                memoryTable.remove(memoryId);
                rc = 1;
            } catch (NullPointerException e){
                Log.v(TAG, String.format("Failed to Remove Story with storyId=%d", memoryId));
            }
        }
        return rc;
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
     * @param storyId the storyId of the story to be updated
     * @param updatedStory the updated version of the Story
     * @return - returns number of stories updated
     */
    @Override
    public int updateStory(long storyId, Story updatedStory)  {
        int rc = 0;
        if(storyTable.contains(storyId)){
            try {
                storyTable.put(storyId, updatedStory);
                rc = 1;
            } catch (NullPointerException e){
                Log.v(TAG, String.format("Failed to Update Story with storyId=%d", storyId));
            }
        }
        return rc;
    }

    /**
     * deleteStory
     * @param storyId the storyId of the story to be deleted
     * @return - returns number of stories deleted
     */
    @Override
    public int deleteStory(long storyId){
        int rc = 0;
        if(storyTable.contains(storyId)){
            try {
                storyTable.remove(storyId);
                rc = 1;
            } catch (NullPointerException e){
                Log.v(TAG, String.format("Failed to Remove Story with storyId=%d", storyId));
            }
        }
        return rc;
    }

}
