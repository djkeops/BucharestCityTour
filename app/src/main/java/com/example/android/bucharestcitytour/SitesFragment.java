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

public class SitesFragment extends Fragment {

    public SitesFragment(){
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.location_list, container, false);

        //Create an ArrayList of Sites Location objects
        final ArrayList<Location> locations = new ArrayList<Location>();
        locations.add(new Location(getString(R.string.sites_palace_of_the_parliament), R.drawable.ic_sites_palace_of_the_parliament, R.drawable.ic_sites_palace_of_the_parliament, getString(R.string.description_sites_palace_of_the_parliament), getString(R.string.address_sites_palace_of_the_parliament), 44.427522, 26.087376));
        locations.add(new Location(getString(R.string.sites_manuc_s_inn), R.drawable.ic_sites_manuc_s_inn, R.drawable.ic_sites_manuc_s_inn, getString(R.string.description_sites_manuc_s_inn), getString(R.string.address_sites_manuc_s_inn), 44.429602, 26.101903));
        locations.add(new Location(getString(R.string.sites_arch_of_triumph), R.drawable.ic_sites_arch_of_triumph, R.drawable.ic_sites_arch_of_triumph, getString(R.string.description_sites_arch_of_triumph), getString(R.string.address_sites_arch_of_triumph), 44.467185, 26.078113));
        locations.add(new Location(getString(R.string.sites_cotroceni_palace), R.drawable.ic_sites_cotroceni_palace, R.drawable.ic_sites_cotroceni_palace, getString(R.string.description_sites_cotroceni_palace), getString(R.string.address_sites_cotroceni_palace), 44.435251, 26.063357));

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
