package edu.bard.todolist_lab1;

import java.util.UUID;

/**
 * Created by CharlieC on September/21/16.
 */

public class ToDoItem {
    private UUID mId;
    private String mTitle;

    public ToDoItem() {mId = UUID.randomUUID();}

    public UUID getId() {return mId;}

    public String getTitle() {return mTitle;}

    public void setTitle(String title) {mTitle = title;}

}
