package edu.bard.todolist_lab1;
/*
  Most basic Todo List in one activity, no fragments.
 */

import android.support.v4.app.Fragment;
import android.util.Log;


public class ToDoList extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new AddFragment();
    }

    public static String TAG = "todolab";

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


