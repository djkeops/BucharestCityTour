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

public class MuseumsFragment extends Fragment {

    public MuseumsFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.location_list, container, false);

        //Create an ArrayList of Museums Location objects
        final ArrayList<Location> locations = new ArrayList<Location>();
        locations.add(new Location(getString(R.string.museums_museum_of_the_romanian_peasant), R.drawable.ic_museums_museum_of_the_romanian_peasant, R.drawable.museums_museum_of_the_romanian_peasant, getString(R.string.description_museums_museum_of_the_romanian_peasant), getString(R.string.address_museums_museum_of_the_romanian_peasant), 44.454446, 26.083606));
        locations.add(new Location(getString(R.string.museums_grigore_antipa_national_museum_of_natural_history), R.drawable.ic_museums_grigore_antipa_national_museum_of_natural_history, R.drawable.museums_grigore_antipa_national_museum_of_natural_history, getString(R.string.description_museums_grigore_antipa_national_museum_of_natural_history), getString(R.string.address_museums_grigore_antipa_national_museum_of_natural_history), 44.453125, 26.084643));
        locations.add(new Location(getString(R.string.museums_national_museum_of_romanian_history), R.drawable.ic_museums_national_museum_of_romanian_history, R.drawable.museums_national_museum_of_romanian_history, getString(R.string.description_museums_national_museum_of_romanian_history), getString(R.string.address_museums_national_museum_of_romanian_history), 44.431466, 26.097454));

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
