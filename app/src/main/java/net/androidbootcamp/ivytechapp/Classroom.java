package net.androidbootcamp.ivytechapp;

/**
 * Created by jamesdrewery on 10/26/16.
 */

public class Classroom {
    private String roomNumber;
    private String latitude;
    private String longitude;

    public Classroom()
    {

    }

    public Classroom(String roomNumber, String latitude, String longitude)
    {
        this.roomNumber = roomNumber;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public void setRoomNumber(String roomNumber) {

        this.roomNumber = roomNumber;
    }

    public void setLatitude(String latitude)
    {
        this.latitude = latitude;
    }

    public void setLongitude(String longitude) {

        this.longitude = longitude;
    }

    public String getRoomNumber() {

        return roomNumber;
    }

    public String getLatitude() {

        return latitude;
    }

    public String getLongitude() {

        return longitude;
    }

}
