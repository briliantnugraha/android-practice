package com.brilian.flexible_fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;

/**
 * Created by Brilian on 5/30/2016.
 */
public class SecondActivity extends Activity {
    private int pos;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        pos = getIntent().getExtras().getInt("pos");
        Log.d("secondActivity",String.valueOf(pos));
        ContentFragment contFrag = (ContentFragment) getFragmentManager().findFragmentById(R.id.contentFragment);

        if (contFrag!=null) {
            Log.d("secondActivity", "masuk if!");
            contFrag.updateText(pos);
        }

        Log.d("secondActivity","tidak masuk if!");
    }
}
