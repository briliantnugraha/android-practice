package com.brilian.flexible_fragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity implements HeadlineFragment.Communicator{
    HeadlineFragment headFrag;
    ContentFragment contFrag;
    FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager     = getFragmentManager();
        headFrag    = (HeadlineFragment) manager.findFragmentById(R.id.headlineFragment);
        headFrag.setCommunicator(this);
    }

    @Override
    public void respond(int position) {
        contFrag = (ContentFragment) manager.findFragmentById(R.id.contentFragment);

        if(contFrag != null && contFrag.isVisible()){
            //it means, we are inside the two pane layout
            contFrag.updateText(position);
        }else{
            Intent intent = new Intent(MainActivity.this,SecondActivity.class);
            intent.putExtra("pos",position);
            Log.d("pos", String.valueOf(position));
            startActivity(intent);
        }
    }
}
