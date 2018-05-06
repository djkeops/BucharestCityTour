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

public class ParksFragment extends Fragment {

    public ParksFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.location_list, container, false);

        //Create an ArrayList of Parks Location objects
        final ArrayList<Location> locations = new ArrayList<Location>();
        locations.add(new Location(getString(R.string.parks_herastrau_park), R.drawable.ic_parks_herastrau_park, R.drawable.parks_herastrau_park, getString(R.string.description_parks_herastrau_park), getString(R.string.address_parks_herastrau_park), 44.47021, 26.082753));
        locations.add(new Location(getString(R.string.parks_cismigiu_gardens), R.drawable.ic_parks_cismigiu_gardens, R.drawable.parks_cismigiu_gardens, getString(R.string.description_parks_cismigiu_gardens), getString(R.string.address_parks_cismigiu_gardens), 44.43698, 26.090987));
        locations.add(new Location(getString(R.string.parks_tineretului_park), R.drawable.ic_parks_tineretului_park, R.drawable.parks_tineretului_park, getString(R.string.description_parks_tineretului_park), getString(R.string.address_parks_tineretului_park), 44.400503, 26.108441));

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