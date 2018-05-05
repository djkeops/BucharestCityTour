package com.example.android.bucharestcitytour;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class ParksFragment extends Fragment {

    public ParksFragment(){
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.location_list, container, false);

        //Create an ArrayList of Parks Location objects
        final ArrayList<Location> locations = new ArrayList<Location>();
        locations.add(new Location(getString(R.string.parks_herastrau_park), R.drawable.ic_parks_herastrau_park, R.drawable.ic_parks_herastrau_park, getString(R.string.description_parks_herastrau_park), getString(R.string.address_parks_herastrau_park), 44.47021, 26.082753));
        locations.add(new Location(getString(R.string.parks_cismigiu_gardens), R.drawable.ic_parks_cismigiu_gardens, R.drawable.ic_parks_cismigiu_gardens, getString(R.string.description_parks_cismigiu_gardens), getString(R.string.address_parks_cismigiu_gardens), 44.43698, 26.090987));
        locations.add(new Location(getString(R.string.parks_tineretului_park), R.drawable.ic_parks_tineretului_park, R.drawable.ic_parks_tineretului_park, getString(R.string.description_parks_tineretului_park), getString(R.string.address_parks_tineretului_park), 44.400503, 26.108441));

        // Create an {@link ArrayAdapter}, whose data source is a list of Strings. The
        // adapter knows how to create layouts for each item in the list, using the
        // simple_list_item_1.xml layout resource defined in the Android framework.
        // This list item layout contains a single {@link TextView}, which the adapter will set to
        // display a single word.
        LocationAdapter adapter = new LocationAdapter(getActivity(), locations);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml file.
        final ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        // {@link ListView} will display list items for each word in the list of words.
        // Do this by calling the setAdapter method on the {@link ListView} object and pass in
        // 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.
        listView.setAdapter(adapter);

        return rootView;
    }
}