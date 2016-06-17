package com.brilian.fragment_lifecycle;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by Brilian on 5/27/2016.
 */
public class PM_Fragment extends Fragment {
    /*String status = "";
    int order = 0;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        status = "Fragment Attached, onAttach";
        displayStatus();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        status = "Fragment created, onCreate";
        displayStatus();
    }*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView   = inflater.inflate(R.layout.pm_fragment,container,false);
        /*status          = "Fragment Create View, onCreateView";
        displayStatus();*/
        return rootView;
    }
    /*

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        status          = "Fragment View created, onViewCreated";
        displayStatus();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        status          = "Fragment Activity created, onActivityCreated";
        displayStatus();
    }

    @Override
    public void onStart() {
        super.onStart();
        status          = "Fragment Started, onStart";
        displayStatus();
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        status          = "Fragment State Restored, onViewStateRestored";
        displayStatus();
    }

    @Override
    public void onResume() {
        super.onResume();
        status          = "Fragment Resumed, onResume";
        displayStatus();
    }

    @Override
    public void onPause() {
        super.onPause();
        status = "Fragment Paused";
        displayStatus();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        status = "Fragment Saving state, onSaveInstanceState";
        displayStatus();
    }

    @Override
    public void onStop() {
        super.onStop();
        status = "Fragment stopped, onStop";
        displayStatus();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        status = "Fragment View Destroyed, onDestroyView";
        displayStatus();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        status = "Fragment Destroyed, onDestroy";
        displayStatus();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        status = "Fragment Detached, onDetach";
        displayStatus();
    }

    private void displayStatus(){
        order++;
        status  = String.valueOf(order) + ": " + status;
        View v  = getView();
        if(v != null){
            status += " [+View]";
        }
        Toast.makeText(v.getContext(), status, Toast.LENGTH_SHORT).show();
    }*/
}
