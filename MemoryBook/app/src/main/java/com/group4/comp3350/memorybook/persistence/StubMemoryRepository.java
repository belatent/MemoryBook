package com.group4.comp3350.memorybook.persistence;

import android.util.Log;

import com.group4.comp3350.memorybook.domainobjects.Memory;
import com.group4.comp3350.memorybook.domainobjects.Story;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Created by Bennet on 2/2/2016.
 */
public class StubMemoryRepository implements MemoryRepository {

    private static final String TAG = "StubMemoryRepository";
    private Hashtable<Long, Memory> memoryTable;

    private long memoryIdCount;


    public StubMemoryRepository() {
        this.memoryTable = new Hashtable<Long, Memory>();
        this.memoryIdCount = 0;
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
     * @param memoryToDelete the to be deleted
     * @return - returns the number of memories deleted
     */
    @Override
    public int deleteMemory(Memory memoryToDelete) {
        int rc = 0;
        try {
            if(memoryTable.contains(memoryToDelete.getId())){
                memoryTable.remove(memoryToDelete.getId());
                rc = 1;
            } else {
                Log.v(TAG, "Memory not found");
            }
        } catch (NullPointerException e){
            Log.v(TAG, "Failed to Delete Memory");
        }
        return rc;
    }


}
