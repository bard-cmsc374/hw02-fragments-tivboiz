package edu.bard.todolist_lab1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by CharlieC on September/21/16.
 */

public class AddFragment extends Fragment{
    private ToDoItem mToDoItem; // todo item object
    private EditText mTitle; // enter todo item
    private Button mAddButton; // add the item to the list

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mToDoItem = new ToDoItem();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_add, container, false);
        mAddButton = (Button)v.findViewById(R.id.addButton);
        mTitle = (EditText) v.findViewById(R.id.mTitle);

        mTitle.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(
                    CharSequence s, int start, int count, int after) {
                // This space intentionally left blank
            }

            @Override
            public void onTextChanged(
                    CharSequence s, int start, int before, int count) {
                mToDoItem.setTitle(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                // This one too
            }
        });

    return v;

    }

}
