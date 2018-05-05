package com.example.android.bucharestcitytour;

import android.os.Parcel;
import android.os.Parcelable;

public class Location implements Parcelable {
    //Used when un-parceling the parcel
    public static final Creator<Location> CREATOR = new Creator<Location>() {
        @Override
        public Location createFromParcel(Parcel in) {
            return new Location(in);
        }

        @Override
        public Location[] newArray(int size) {
            return new Location[size];
        }
    };

    //Declare variables
    private String name;
    private int logoImageResourceId;
    private int imageResourceId;
    private String description;
    private String address;
    private double latitude;
    private double longitude;

    //Main constructor
    public Location(String name, int logoImageResourceId, int imageResourceId, String description, String address, double latitude, double longitude) {
        this.name = name;
        this.logoImageResourceId = logoImageResourceId;
        this.imageResourceId = imageResourceId;
        this.description = description;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    //Constructor used for parcel
    public Location(Parcel in) {
        name = in.readString();
        logoImageResourceId = in.readInt();
        imageResourceId = in.readInt();
        description = in.readString();
        address = in.readString();
        latitude = in.readDouble();
        longitude = in.readDouble();
    }

    //Getters methods
    public String getName() {
        return name;
    }

    public int getLogoImageResourceId() {
        return logoImageResourceId;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public String getDescription() {
        return description;
    }

    public String getAddress() {
        return address;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    //Return hashcode of object
    @Override
    public int describeContents() {
        return hashCode();
    }

    //write object values to parcel for storage
    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeInt(logoImageResourceId);
        parcel.writeInt(imageResourceId);
        parcel.writeString(description);
        parcel.writeString(address);
        parcel.writeDouble(latitude);
        parcel.writeDouble(longitude);
    }
}
