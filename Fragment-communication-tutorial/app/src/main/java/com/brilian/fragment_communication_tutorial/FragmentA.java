package com.brilian.fragment_communication_tutorial;

import android.app.Activity;
import android.app.Fragment;
import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by Brilian on 5/29/2016.
 */
public class FragmentA extends ListFragment implements AdapterView.OnItemClickListener{
    private HeadlineListener headlineListener;
    private ListView headlineListview;
    private Activity act;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        act = activity;
        //make sure that the mainView activity has been implemented
        //the interface, otherwise throw an exception
        try{
            headlineListener        = (HeadlineListener) act;
        }catch (Exception e){
            throw new ClassCastException(activity.toString() + " must be implemented on HeadlineListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragment_a,container,false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        int layout              = android.R.layout.simple_list_item_activated_1;
        String[] headline       = Articles.headline;

        //set list adapter using the string array headline and layout
        ArrayAdapter adapter    = new ArrayAdapter(act, layout, headline);

        Log.d("onActivityCreated", "Jalan");
        headlineListview        = (ListView) act.findViewById(R.id.listHeadline);
        headlineListview.setAdapter(adapter);
        headlineListview.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        headlineListener.OnHeadlineSelected(position);
        headlineListview.setItemChecked(position,true);
        headlineListview.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
    }
}