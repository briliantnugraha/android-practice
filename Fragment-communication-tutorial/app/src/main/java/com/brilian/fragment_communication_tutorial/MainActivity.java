package com.brilian.fragment_communication_tutorial;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity implements HeadlineListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("onCreate", "masuk ke onCreate method");

        if(findViewById(R.id.mainView) != null){
            //however if being restored from previous state, don't do anything
            if(savedInstanceState != null)return;

            FragmentA fragmentA     = new FragmentA();
            fragmentA.setArguments(getIntent().getExtras());

            getFragmentManager().beginTransaction()
                                .add(R.id.mainView, fragmentA)
                                .commit();
        }
    }

    @Override
    public void OnHeadlineSelected(int position) {
        Log.d("Position", String.valueOf(position));

        FragmentManager manager     = getFragmentManager();
        FragmentB fragmentB         = (FragmentB) manager.findFragmentById(R.id.fragment_b);

        if(fragmentB != null){
            //two layout pane

            Log.d("layout", "This is show because of two pane layout");
            fragmentB.updateArticle(position);
        }else{
            //one layout pane
            //pass the position to the fragment
            fragmentB               = new FragmentB();
            Bundle args             = new Bundle();
            args.putInt(FragmentB.pos,position);
            fragmentB.setArguments(args);

            //the argument has been passed, let's swap the fragment
            manager.beginTransaction()
                    .replace(R.id.mainView,fragmentB)
                    .addToBackStack(null)
                    .commit();
        }


    }
}
