package com.example.choonket.fyp.mDataObject;

/**
 * Created by Mr.Tsang Wai Yong on 25/11/2017.
 */

public class Tracking {
    public String getLocationDescription() {
        return locationDescription;
    }

    public void setLocationDescription(String locationDescription) {
        this.locationDescription = locationDescription;
    }

    int locationID;
    String locationName;
    String locationAddress;
    String locationContact;
    String locationCategory;
    String locationDescription;
    Double latitude,longtitude,trackingDistance;
    Double averageRating;

    public Double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(Double averageRating) {
        this.averageRating = averageRating;
    }

    public String getLocationCategory() {
        return locationCategory;
    }
    public void setLocationCategory(String locationCategory) {
        this.locationCategory = locationCategory;
    }
    public String getLocationAddress() {
        return locationAddress;
    }

    public void setLocationAddress(String locationAddress) {
        this.locationAddress = locationAddress;
    }

    public String getLocationContact() {
        return locationContact;
    }

    public void setLocationContact(String locationContact) {
        this.locationContact = locationContact;
    }

    public Double getTrackingDistance() {
        return trackingDistance;
    }

    public void setTrackingDistance(Double trackingDistance) {
        this.trackingDistance = trackingDistance;
    }

    public int getLocationID() {
        return locationID;
    }

    public void setLocationID(int locationID) {
        this.locationID = locationID;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(Double longtitude) {
        this.longtitude = longtitude;
    }
}
