package com.group4.comp3350.memorybook.persistence;

import com.group4.comp3350.memorybook.domainobjects.Story;

import java.util.ArrayList;

/**
 * Created by Bennet on 2/2/2016.
 */
public interface StoryRepository {
    /**
     * getAllStories
     * @return - returns an ArrayList of all Stories
     * @throws - PersistenceException if error occurs
     */
    public ArrayList<Story> getAllStories() throws PersistenceException;
    /**
     * addStory
     * @param story the Story to be stored
     * @return - returns story with id field set
     * @throws - PersistenceException if error occurs
     */
    public Story storeStory(Story story) throws PersistenceException;
    /**
     * deleteStory
     * @param storyToDelete the story to be deleted
     * @throws - PersistenceException if error occurs
     */
    public void deleteStory(Story storyToDelete) throws PersistenceException;
}
