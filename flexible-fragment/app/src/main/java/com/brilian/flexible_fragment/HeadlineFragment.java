package com.brilian.flexible_fragment;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Brilian on 5/30/2016.
 */
public class HeadlineFragment extends ListFragment implements AdapterView.OnItemClickListener{
    private ListView headlineList;
    private Communicator mycom;
    private String[] headline;
    private ArrayAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        headline = Articles.headline;
        adapter = new ArrayAdapter(getActivity(),
                android.R.layout.simple_list_item_activated_1,
                headline);

        return inflater.inflate(R.layout.headline_fragment, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        headlineList = (ListView) getActivity().findViewById(R.id.headlineFragment);
        headlineList.setAdapter(adapter);
        headlineList.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        headlineList.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        mycom.respond(position);
    }

    //this for communication between fragment, use interface
    public interface Communicator{
        public void respond(int position);
    }

    public void setCommunicator(Communicator com){
        this.mycom  = com;
    }
}
