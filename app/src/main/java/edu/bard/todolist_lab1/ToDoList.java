package edu.bard.todolist_lab1;
/*
  Most basic Todo List in one activity, no fragments.


CMSC 374
HW #2 Fragments: Feedback

Names: Charlie and Elias

      Rubric
----------------------------------------------------------
40	1. App functions correctly from end user perspective.
20	2. Fragments are correctly created.
10	3. Fragments share information on the adapter arraylist.
5	4. Code is clearly commented.
20	5. Code is readable and well constructed.

Score: 95


----------------

Comments

My comments in your code are marked with XX in a comment.


1. App functions correctly from end user perspective. YES

2. Fragments are correctly created. YES and managed

3. Fragments share information on the adapter arraylist.

You allow the activity to call the list's update, which is fine for
this exercise.

4. Code is clearly commented.
There are a few spots where more should be said.

5. Code is readable and well constructed.
Yes...good throughout.





 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;


public class ToDoList extends FragmentActivity {

    //public ArrayList<String> mToDoItems;
    private ListFragment lst;

    @Override
    public void onCreate(Bundle stuff) {
        super.onCreate(stuff);
        setContentView(R.layout.main);

        //Are fragments created yet?
        FragmentManager fm = getSupportFragmentManager();
        Fragment addfrg = fm.findFragmentById(R.id.add_container);
        Fragment lstfrg = fm.findFragmentById(R.id.list_container);

        if(addfrg == null || lstfrg == null){
            FragmentTransaction trans = fm.beginTransaction();
            if(addfrg == null){
                trans.add(R.id.add_container, new AddFragment());
            }
            if (lstfrg == null){
                lst = new ListFragment();//createListFragment();
                trans.add(R.id.list_container, lst);
            }
            trans.commit();
        }
    }

    public void update(String str){
        lst.updateArrayList(str);
    }

    public static String TAG = "todolist";

    protected void onStart() {
        super.onStart();
        Log.i(TAG, "Entered onStart");
    }

    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "Entered onRestart");
    }

    protected void onResume() {
        super.onResume();
        Log.i(TAG, "Entered onResume");
    }

    protected void onPause() {
        super.onPause();
        Log.i(TAG, "Entered onPause");
    }

    protected void onStop() {
        super.onStop();
        Log.i(TAG, "Entered onStop");
    }

    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "Entered onDestroy");
    }


}


