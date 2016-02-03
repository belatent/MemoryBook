package com.group4.comp3350.memorybook.persistence;

/**
 * Created by Bennet on 2/2/2016.
 */
public class PersistenceException extends Exception {
    private String errorMsg;

    PersistenceException(String errorMsg){
        this.errorMsg = errorMsg;
    }

    public String getErrorMessage(){
        return errorMsg;
    }
}
