package edu.bard.todolist_lab1;
/*
  Most basic Todo List in one activity, no fragments.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

import java.util.ArrayList;


public class ToDoList extends FragmentActivity {

    public ArrayList<String> mToDoItems;
    private static final String LIT_ARRAY = "lit";

    @Override
    public void onCreate(Bundle stuff) {
        super.onCreate(stuff);
        setContentView(R.layout.main);

        AddFragment addfrg = new AddFragment();
        ListFragment lstfrg = new ListFragment();

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction trans = fm.beginTransaction();

        trans.add(R.id.add_container, addfrg, "ADDTAG");
        trans.add(R.id.list_container, lstfrg, "LISTTAG");

        Intent intent = getIntent();
        String message = intent.getStringExtra("item");

        if (stuff != null){
            mToDoItems = stuff.getStringArrayList(LIT_ARRAY);
            Log.i(LIT_ARRAY, "Updated");
        } else {
            mToDoItems = new ArrayList<String>();
            Log.i(LIT_ARRAY, "Created");
        }

        if (message != null){
            mToDoItems.add(message);
        }

        Bundle bundle = new Bundle();
        bundle.putStringArrayList("list", mToDoItems);
        lstfrg.setArguments(bundle);

        trans.commit();
    }

    @Override
    public void onSaveInstanceState(Bundle stuff){
        super.onSaveInstanceState(stuff);
        stuff.putStringArrayList(LIT_ARRAY, mToDoItems);
        Log.i(LIT_ARRAY, "Saving");
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


