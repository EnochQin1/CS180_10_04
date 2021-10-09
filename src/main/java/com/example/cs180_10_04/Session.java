package com.example.cs180_10_04;
/**
 * A class that represents an individual session in a lab.
 *
 * Purdue University -- CS18000 -- Fall 2021 -- Project 02
 *
 * @author Enoch_Qin Purdue CS
 * @version October 8, 2021
 */
public class Session
{
    private String name;
    private int enrollment;

    public Session(String name1, int enrollment1)
    {
        this.name = name1;
        this.enrollment = enrollment1;
    }

    public Session()
    {
        this.name = "";
        enrollment = 0;
    }

    public String getName() { return this.name; }
    public int getEnrollment() { return this.enrollment; }
    public void setName(String name1) { this.name = name1; }
    public void setEnrollment(int enrollment1) { this.enrollment = enrollment1; }
    public String toString()
    {
        return String.format("Session{Name - %s, Enrollment - %d}", this.name, this.enrollment);
    }
}