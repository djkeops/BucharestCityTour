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

public class SitesFragment extends Fragment {

    public SitesFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.location_list, container, false);

        //Create an ArrayList of Sites Location objects
        final ArrayList<Location> locations = new ArrayList<Location>();
        locations.add(new Location(getString(R.string.sites_palace_of_the_parliament), R.drawable.ic_sites_palace_of_the_parliament, R.drawable.sites_palace_of_the_parliament, getString(R.string.description_sites_palace_of_the_parliament), getString(R.string.address_sites_palace_of_the_parliament), 44.427522, 26.087376));
        locations.add(new Location(getString(R.string.sites_manuc_s_inn), R.drawable.ic_sites_manuc_s_inn, R.drawable.sites_manuc_s_inn, getString(R.string.description_sites_manuc_s_inn), getString(R.string.address_sites_manuc_s_inn), 44.429602, 26.101903));
        locations.add(new Location(getString(R.string.sites_arch_of_triumph), R.drawable.ic_sites_arch_of_triumph, R.drawable.sites_arch_of_triumph, getString(R.string.description_sites_arch_of_triumph), getString(R.string.address_sites_arch_of_triumph), 44.467185, 26.078113));
        locations.add(new Location(getString(R.string.sites_cotroceni_palace), R.drawable.ic_sites_cotroceni_palace, R.drawable.sites_cotroceni_palace, getString(R.string.description_sites_cotroceni_palace), getString(R.string.address_sites_cotroceni_palace), 44.435251, 26.063357));

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
