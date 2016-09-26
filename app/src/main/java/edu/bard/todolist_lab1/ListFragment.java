package edu.bard.todolist_lab1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by CharlieC on September/22/16.
 */

public class ListFragment extends Fragment {

    private static final String SAVE_TAG = "saving";
    private ArrayList<String> mToDoItems; // list of items
    private ArrayAdapter<String> aa; // adapter from list to viewlist
    private ListView mListView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mToDoItems = new ArrayList<String>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate your view
        View v = inflater.inflate(R.layout.fragment_list, container, false);

        // Get references to UI widgets
        mListView = (ListView) v.findViewById(R.id.myListView);


        aa = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, mToDoItems);

        // Bind the listview to the array adapter
        mListView.setAdapter(aa);

        return v;

    }
    public void updateArrayList(String str){
        mToDoItems.add(str);
        aa.notifyDataSetChanged();
    }
    @Override
    public void onSaveInstanceState(Bundle stuff){
        super.onSaveInstanceState(stuff);
        stuff.putStringArrayList(SAVE_TAG, mToDoItems);
        Log.i("todolab", mToDoItems.toString());
        Log.i("todolab","Saving");
    }

    public static ListFragment newInstance(ArrayList<String> lst){
        Bundle args = new Bundle();
        args.putStringArrayList(SAVE_TAG, lst);

        ListFragment lstfrg = new ListFragment();
        lstfrg.setArguments(args);
        return lstfrg;
    }

}
