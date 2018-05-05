package com.example.android.bucharestcitytour;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class LocationAdapter extends ArrayAdapter<Location> {

    /**
     * The custom constructor
     * @param context The current context. Used to inflate the layout file.
     * @param locations A List of Location objects to display in a list
     */
    public LocationAdapter(@NonNull Activity context, ArrayList<Location> locations) {
        super(context, 0, locations);
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position The position in the list of data that should be displayed in the list item view.
     * @param convertView The recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the list_view layout
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        // Get the object located in the list at this position
        Location currentLocation = getItem(position);

        //Find the ImageView in the list_item.xml layout with the ID logo_image
        ImageView logoImageView = (ImageView) listItemView.findViewById(R.id.logo_image);
        // Get the logo image resource from the current Location object and set this image to the logo_image ImageView
        if (currentLocation != null) {
            logoImageView.setImageResource(currentLocation.getImageResourceId());
        }

        // Find the TextView in the list_item.xml layout with the ID location_name
        TextView locationNameTextView = (TextView) listItemView.findViewById(R.id.location_name);
        // Get the location name from the current Location object and set this text on the location_name TextView
        if (currentLocation != null) {
            locationNameTextView.setText(currentLocation.getName());
        }

        // Find the TextView in the list_item.xml layout with the ID location_description
        TextView locationDescriptionTextView = (TextView) listItemView.findViewById(R.id.location_description);
        // Get the location description from the current Location object and set this text on the location_description TextView
        if (currentLocation != null) {
            // Get first 120 characters from the description
            String shortDescription = String.format("%.120s",currentLocation.getDescription()) + "...";
            locationDescriptionTextView.setText(shortDescription);
        }

        // Find the TextView in the list_item.xml layout with the ID location_address
        TextView locationAddressTextView = (TextView) listItemView.findViewById(R.id.location_address);
        // Get the location address from the current Location object and set this text on the location_address TextView
        if (currentLocation != null) {
            locationAddressTextView.setText(currentLocation.getAddress());
        }

        // Return the whole list item layout (containing 1 ImageView and 3 TextViews) so that it can be shown in the ListView
        return listItemView;
    }
}

