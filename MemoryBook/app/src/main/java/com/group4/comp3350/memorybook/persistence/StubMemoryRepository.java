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
     * {@inheritDoc}
     */
    @Override
    public ArrayList<Memory> getAllMemories() throws PersistenceException{
        return new ArrayList<Memory>(memoryTable.values());
    }
    /**
     * {@inheritDoc}
     */

    @Override
    public Memory storeMemory(Memory memory) throws PersistenceException{
        try {
            memory.setId(memoryIdCount);
            memoryTable.put(memoryIdCount, memory);
            memoryIdCount++;
        } catch (NullPointerException e){
            Log.v(TAG, "Failed to Add Memory");
            throw new PersistenceException("Failed to Delete Memory, Memory not found");
        }
        return memory;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteMemory(Memory memoryToDelete) throws PersistenceException{
        try {
            if(memoryTable.contains(memoryToDelete.getId())){
                memoryTable.remove(memoryToDelete.getId());
            } else {
                Log.v(TAG, "Memory not found");
                throw new PersistenceException("Failed to Delete Memory, Memory not found");
            }
        } catch (NullPointerException e){
            Log.v(TAG, "Failed to Delete Memory");
            throw new PersistenceException("Failed to Delete Memory, NullPointer");
        }
    }


}
