package com.example.cs180_10_04;
/**
 * A class that represents a Lab.
 *
 * Purdue University -- CS18000 -- Fall 2021 -- Project 02
 *
 * @author Enoch_Qin Purdue CS
 * @version October 8, 2021
 */
public class Lab
{
    private Session morning;
    private Session afternoon;
    private int capacity;
    private String location;

    public Lab(Session morning1, Session afternoon1, int capacity1, String location1)
    {
        this.morning = morning1;
        this.afternoon = afternoon1;
        this.capacity = capacity1;
        this.location = location1;
    }

    public Lab(int capacity1, String location1)
    {
        this.capacity = capacity1;
        this.location = location1;
        this.morning = new Session();
        this.afternoon = new Session();
    }

    public Session getMorning() { return this.morning; }
    public Session getAfternoon() { return this.afternoon; }
    public int getCapacity() { return this.capacity; }
    public String getLocation() { return this.location; }
    public void setMorning(Session morning1) { this.morning = morning1; }
    public void setAfternoon(Session afternoon1) { this.afternoon = afternoon1; }
    public void setCapacity(int capacity1) { this.capacity = capacity1; }
    public void setLocation(String location1) { this.location = location1; }
    public String listAvailabilities()
    {
        String availableString = "";
        if (this.morning.getEnrollment() == 0)
        {
            availableString += "Morning:Available\n";
        }
        if (this.afternoon.getEnrollment() == 0)
        {
            availableString += "Afternoon:Available\n";
        }
        if (availableString.equals(""))
        {
            return "No Availabilities";
        }
        return availableString;
    }
    public String listReservations()
    {
        String reservationString = "";
        if (this.morning.getEnrollment() > 0)
        {
            reservationString += "Morning:Reserved\n";
        }
        if (this.afternoon.getEnrollment() > 0)
        {
            reservationString += "Afternoon:Reserved\n";
        }
        if (reservationString.equals(""))
        {
            return "No Reservations";
        }
        return reservationString;
    }
    public String toString()
    {
        String morningOutput;
        String afternoonOutput;
        if (this.morning.getEnrollment() == 0)
        {
            morningOutput = "Available";
        } else
        {
            morningOutput = this.morning.toString();
        }
        if (this.afternoon.getEnrollment() == 0)
        {
            afternoonOutput = "Available";
        } else
        {
            afternoonOutput = this.afternoon.toString();
        }
        return String.format("Lab{Capacity - %d, Location - %s, Morning: %s, Afternoon: %s}",
                this.capacity, this.location, morningOutput, afternoonOutput);
    }
}
