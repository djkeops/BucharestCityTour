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

public class EntertainmentFragment extends Fragment {

    public EntertainmentFragment(){
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.location_list, container, false);

        //Create an ArrayList of Entertainment Location objects
        final ArrayList<Location> locations = new ArrayList<Location>();
        locations.add(new Location(getString(R.string.entertainment_romanian_athenaeum), R.drawable.ic_entertainment_romanian_athenaeum, R.drawable.ic_entertainment_romanian_athenaeum, getString(R.string.description_entertainment_romanian_athenaeum), getString(R.string.address_entertainment_romanian_athenaeum), 44.441326, 26.09728));
        locations.add(new Location(getString(R.string.entertainment_national_theater_ion_luca_caragiale), R.drawable.ic_entertainment_national_theater_ion_luca_caragiale, R.drawable.ic_entertainment_national_theater_ion_luca_caragiale, getString(R.string.description_entertainment_national_theater_ion_luca_caragiale), getString(R.string.address_entertainment_national_theater_ion_luca_caragiale), 44.436794, 26.103956));
        locations.add(new Location(getString(R.string.entertainment_old_city), R.drawable.ic_entertainment_old_city, R.drawable.ic_entertainment_old_city, getString(R.string.description_entertainment_old_city), getString(R.string.address_entertainment_old_city), 44.431829, 26.101163));

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
