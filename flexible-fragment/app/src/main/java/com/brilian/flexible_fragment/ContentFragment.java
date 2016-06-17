package com.brilian.flexible_fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Brilian on 5/30/2016.
 */
public class ContentFragment extends Fragment {
    private TextView myText;
    private String[] content;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        content = Articles.articleBody;
        return inflater.inflate(R.layout.content_fragment, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        myText = (TextView) getActivity().findViewById(R.id.contentFragment);
        if (myText != null)
            Log.d("onActivityCreated", "myText ada");
    }



    public void updateText(int position){
        if(content != null) myText = (TextView) getActivity().findViewById(R.id.contentFragment);
        Log.d("receivedPosition", String.valueOf(position));
        myText.setText(content[position]);
    }
}
