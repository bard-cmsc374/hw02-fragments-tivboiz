package edu.bard.todolist_lab1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

/**
 * Created by CharlieC on September/21/16.
 */

public abstract class SingleFragmentActivity extends FragmentActivity {

    protected abstract Fragment createFragment();
    @Override
    public void onCreate(Bundle stuff) {
        super.onCreate(stuff);
        setContentView(R.layout.main);
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);
        if (fragment == null) {
            fragment = new AddFragment();
            fm.beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit(); }
    }

}
