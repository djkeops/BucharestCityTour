package com.example.android.bucharestcitytour;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class EntertainmentFragment extends Fragment {

    public EntertainmentFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.location_list, container, false);

        //Create an ArrayList of Entertainment Location objects
        final ArrayList<Location> locations = new ArrayList<Location>();
        locations.add(new Location(getString(R.string.entertainment_romanian_athenaeum), R.drawable.ic_entertainment_romanian_athenaeum, R.drawable.entertainment_romanian_athenaeum, getString(R.string.description_entertainment_romanian_athenaeum), getString(R.string.address_entertainment_romanian_athenaeum), 44.441326, 26.09728));
        locations.add(new Location(getString(R.string.entertainment_national_theater_ion_luca_caragiale), R.drawable.ic_entertainment_national_theater_ion_luca_caragiale, R.drawable.entertainment_national_theater_ion_luca_caragiale, getString(R.string.description_entertainment_national_theater_ion_luca_caragiale), getString(R.string.address_entertainment_national_theater_ion_luca_caragiale), 44.436794, 26.103956));
        locations.add(new Location(getString(R.string.entertainment_old_city), R.drawable.ic_entertainment_old_city, R.drawable.entertainment_old_city, getString(R.string.description_entertainment_old_city), getString(R.string.address_entertainment_old_city), 44.431829, 26.101163));

        // Create an LocationAdapter whose data source is locations ArrayList.
        LocationAdapter adapter = new LocationAdapter(getActivity(), locations);

        // Find the ListView object in the view hierarchy of the layout.
        final ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the ListView to use the LocationAdapter
        listView.setAdapter(adapter);

        // Set a click listener to open DetailsActivity
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                // Get the Location object at the given position the user clicked on
                Location location = locations.get(position);

                Intent openDetailsActivity = new Intent(getActivity(), DetailsActivity.class);
                openDetailsActivity.putExtra("Location", location);
                startActivity(openDetailsActivity);
            }
        });

        return rootView;
    }
}
