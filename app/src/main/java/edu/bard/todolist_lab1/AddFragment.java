package edu.bard.todolist_lab1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by CharlieC on September/21/16.
 */

public class AddFragment extends Fragment{
    private EditText mEditText; // enter todo item
    private String mToDoItem;  // Save String of todo item
    private Button mAddButton; // add the item to the list

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_add, container, false);
        mAddButton = (Button)v.findViewById(R.id.addButton);
        mAddButton.setEnabled(true);
        mEditText = (EditText) v.findViewById(R.id.mTitle);

        mEditText.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(
                    CharSequence s, int start, int count, int after) {
                // This space intentionally left blank
            }

            @Override
            public void onTextChanged(
                    CharSequence s, int start, int before, int count) {
                mToDoItem = (s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                // This one too
            }
        });
        mAddButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (mToDoItem == null){
                    Toast.makeText(getActivity(), R.string.empty_edittext, Toast.LENGTH_SHORT)
                            .show();
                } else {
                    ((ToDoList)getActivity()).update(mToDoItem); // XX what is this for?
                    mEditText.setText("");
                }
            }
        });

    return v;

    }

}
