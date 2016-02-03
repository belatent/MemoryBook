package com.group4.comp3350.memorybook.persistence;

import com.group4.comp3350.memorybook.domainobjects.Memory;
import com.group4.comp3350.memorybook.domainobjects.Story;

import java.util.ArrayList;

/**
 * Created by Bennet on 2/2/2016.
 */
public interface MemoryRepository {

    public ArrayList<Memory> getAllMemories();
    public long addMemory(Memory newMemory);
    public int deleteMemory(Memory memoryToDelete);

}
