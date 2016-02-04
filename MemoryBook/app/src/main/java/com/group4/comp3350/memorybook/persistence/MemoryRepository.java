package com.group4.comp3350.memorybook.persistence;

import com.group4.comp3350.memorybook.domainobjects.Memory;

import java.util.ArrayList;

/**
 * Created by Bennet on 2/2/2016.
 */
public interface MemoryRepository {

    /**
     * getAllMemories
     * @returns an ArrayList of Memories
     * @throws - PersistenceException if error occurs and NullPointerException if argument is null
     */
    public ArrayList<Memory> getAllMemories() throws PersistenceException;

    /**
     * storeMemory
     * @param memory the Memory to be stored in database
     * @return - returns memory with id field set
     * @throws - PersistenceException if error occurs and NullPointerException if argument is null
     */
    public Memory storeMemory(Memory memory) throws PersistenceException;

    /**
     * deleteMemory
     * @param memoryToDelete the to be deleted
     * @throws - PersistenceException if error occurs and NullPointerException if argument is null
     */
    public void deleteMemory(Memory memoryToDelete) throws PersistenceException;

}
