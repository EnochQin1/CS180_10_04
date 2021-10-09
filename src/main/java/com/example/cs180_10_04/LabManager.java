package com.example.cs180_10_04;
/**
 * A class that is able to manage the different Labs.
 *
 * Purdue University -- CS18000 -- Fall 2021 -- Project 02
 *
 * @author Enoch_Qin Purdue CS
 * @version October 8, 2021
 */
public class LabManager
{
    private Lab labOne;
    private Lab labTwo;
    private Lab labThree;

    public LabManager(Lab labOne1, Lab labTwo1, Lab labThree1)
    {
        this.labOne = labOne1;
        this.labTwo = labTwo1;
        this.labThree = labThree1;
    }

    public Lab getLabOne() { return this.labOne; }
    public Lab getLabTwo() { return this.labTwo; }
    public Lab getLabThree() { return this.labThree; }
    public void setLabOne(Lab labOne1) { this.labOne = labOne1; }
    public void setLabTwo(Lab labTwo1) { this.labTwo = labTwo1; }
    public void setLabThree(Lab labThree1) { this.labThree = labThree1; }
    public int calculateTotalCapacity()
    {
        int totalCapacity = 0;
        totalCapacity += labOne.getCapacity() * 2;
        totalCapacity += labTwo.getCapacity() * 2;
        totalCapacity += labThree.getCapacity() * 2;
        return totalCapacity;
    }
    public double calculateTotalUtilization()
    {
        double totalU = (((double)labOne.getMorning().getEnrollment() / (double)labOne.getCapacity() +
                (double)labOne.getAfternoon().getEnrollment() / (double)labOne.getCapacity() +
                (double)labTwo.getAfternoon().getEnrollment() / (double)labTwo.getCapacity() +
                (double)labTwo.getMorning().getEnrollment() / (double)labTwo.getCapacity() +
                (double)labThree.getMorning().getEnrollment() / (double)labThree.getCapacity() +
                (double)labThree.getAfternoon().getEnrollment() / (double)labThree.getCapacity()) / 6.0);
        return totalU;
    }
    public int calculateAvailableSeats()
    {
        int availableSeats = 0;
        availableSeats += labOne.getCapacity() - labOne.getMorning().getEnrollment();
        availableSeats += labOne.getCapacity() - labOne.getAfternoon().getEnrollment();
        availableSeats += labTwo.getCapacity() - labTwo.getMorning().getEnrollment();
        availableSeats += labTwo.getCapacity() - labTwo.getAfternoon().getEnrollment();
        availableSeats += labThree.getCapacity() - labThree.getAfternoon().getEnrollment();
        availableSeats += labThree.getCapacity() - labThree.getMorning().getEnrollment();
        return availableSeats;
    }

    public String listReservedLabs()
    {
        return String.format("Lab One\n%s\n\nLab Two\n%s\n\nLab Three\n%s", this.labOne.listReservations(),
                this.labTwo.listReservations(), this.labThree.listReservations());
    }
    public String listAvailableLabs()
    {
        return String.format("Lab One\n%s\n\nLab Two\n%s\n\nLab Three\n%s", this.labOne.listAvailabilities(),
                this.labTwo.listAvailabilities(), this.labThree.listAvailabilities());
    }
    public String addReservation(String location1, String time1, String name1, int enrollment1)
    {
        if (location1.equals(this.labOne.getLocation()))
        {
            if (time1.equals("afternoon") || time1.equals("morning"))
            {
                if (time1.equals("morning") && this.labOne.listReservations().contains("Morning:Reserved\n"))
                {
                    return "Error. Invalid time.";
                }
                if (time1.equals("afternoon") && this.labOne.listReservations().contains("Afternoon:Reserved\n"))
                {
                    return "Error. Invalid time.";
                }
                if (enrollment1 > labOne.getCapacity())
                {
                    return "Error. Capacity exceeded";
                }
                if (time1.equals("morning"))
                {
                    Session reserve = new Session(name1, enrollment1);
                    this.labOne.setMorning(reserve);
                } else if (time1.equals("afternoon"))
                {
                    Session reserve = new Session(name1, enrollment1);
                    this.labOne.setAfternoon(reserve);
                }
            }
            else {
                return "Error. Invalid time.";
            }
        } else if (location1.equals(this.labTwo.getLocation()))
        {
            if (time1.equals("afternoon") || time1.equals("morning"))
            {
                if (time1.equals("morning") && this.labTwo.listReservations().contains("Morning:Reserved\n"))
                {
                    return "Error. Invalid time.";
                }
                if (time1.equals("afternoon") && this.labTwo.listReservations().contains("Afternoon:Reserved\n"))
                {
                    return "Error. Invalid time.";
                }
                if (enrollment1 > labTwo.getCapacity())
                {
                    return "Error. Capacity exceeded";
                }
                if (time1.equals("morning"))
                {
                    Session reserve = new Session(name1, enrollment1);
                    this.labTwo.setMorning(reserve);
                } else if (time1.equals("afternoon"))
                {
                    Session reserve = new Session(name1, enrollment1);
                    this.labTwo.setAfternoon(reserve);
                }
            }
            else {
                return "Error. Invalid time.";
            }
        } else if (location1.equals(this.labThree.getLocation()))
        {
            if (time1.equals("afternoon") || time1.equals("morning"))
            {
                if (time1.equals("morning") && this.labThree.listReservations().contains("Morning:Reserved\n"))
                {
                    return "Error. Invalid time.";
                }
                if (time1.equals("afternoon") && this.labThree.listReservations().contains("Afternoon:Reserved\n"))
                {
                    return "Error. Invalid time.";
                }
                if (enrollment1 > labThree.getCapacity())
                {
                    return "Error. Capacity exceeded";
                }
                if (time1.equals("morning"))
                {
                    Session reserve = new Session(name1, enrollment1);
                    this.labThree.setMorning(reserve);
                } else if (time1.equals("afternoon"))
                {
                    Session reserve = new Session(name1, enrollment1);
                    this.labThree.setAfternoon(reserve);
                }
            }
            else {
                return "Error. Invalid time.";
            }
        } else
        {
            return "Error. Invalid location";
        }
        return "Reservation added!";
    }

    public String removeReservation(String location1, String time1)
    {
        if (location1.equals(this.labOne.getLocation()))
        {
            if (time1.equals("afternoon") || time1.equals("morning"))
            {
                if (time1.equals("morning") && !(this.labOne.listReservations().contains("Morning:Reserved\n")))
                {
                    return "Error. Invalid time.";
                }
                if (time1.equals("afternoon") && !(this.labOne.listReservations().contains("Afternoon:Reserved\n")))
                {
                    return "Error. Invalid time.";
                }
                if (time1.equals("morning"))
                {
                    Session remove = new Session();
                    this.labOne.setMorning(remove);
                } else if (time1.equals("afternoon"))
                {
                    Session remove = new Session();
                    this.labOne.setAfternoon(remove);
                }
            } else {
                return "Error. Invalid time";
            }
        } else if (location1.equals(this.labTwo.getLocation()))
        {
            if (time1.equals("afternoon") || time1.equals("morning"))
            {
                if (time1.equals("morning") && !(this.labTwo.listReservations().contains("Morning:Reserved\n")))
                {
                    return "Error. Invalid time.";
                }
                if (time1.equals("afternoon") && !(this.labTwo.listReservations().contains("Afternoon:Reserved\n")))
                {
                    return "Error. Invalid time.";
                }
                if (time1.equals("morning"))
                {
                    Session remove = new Session();
                    this.labTwo.setMorning(remove);
                } else if (time1.equals("afternoon"))
                {
                    Session remove = new Session();
                    this.labTwo.setAfternoon(remove);
                }
            } else {
                return "Error. Invalid time";
            }
        } else if (location1.equals(this.labThree.getLocation()))
        {
            if (time1.equals("afternoon") || time1.equals("morning"))
            {
                if (time1.equals("morning") && !(this.labThree.listReservations().contains("Morning:Reserved\n")))
                {
                    return "Error. Invalid time.";
                }
                if (time1.equals("afternoon") && !(this.labThree.listReservations().contains("Afternoon:Reserved\n")))
                {
                    return "Error. Invalid time.";
                }
                if (time1.equals("morning"))
                {
                    Session remove = new Session();
                    this.labThree.setMorning(remove);
                } else if (time1.equals("afternoon"))
                {
                    Session remove = new Session();
                    this.labThree.setAfternoon(remove);
                }
            } else {
                return "Error. Invalid time";
            }
        } else
        {
            return "Error. Invalid location";
        }
        return "Reservation removed!";
    }

    public String modifyReservation(String location1, String time1, String name1, int enrollment1)
    {
        if (location1.equals(this.labOne.getLocation()))
        {
            if (time1.equals("afternoon") || time1.equals("morning"))
            {
                if (time1.equals("morning") && !(this.labOne.listReservations().contains("Morning:Reserved\n")))
                {
                    return "Error. Invalid time.";
                }
                if (time1.equals("afternoon") && !(this.labOne.listReservations().contains("Afternoon:Reserved\n")))
                {
                    return "Error. Invalid time.";
                }
                if (enrollment1 > labOne.getCapacity())
                {
                    return "Error. Capacity exceeded";
                }
                if (time1.equals("morning"))
                {
                    Session modify = new Session(name1, enrollment1);
                    this.labOne.setMorning(modify);
                } else if (time1.equals("afternoon"))
                {
                    Session modify = new Session(name1, enrollment1);
                    this.labOne.setAfternoon(modify);
                }
            } else {
                return "Error. Invalid time.";
            }
        } else if (location1.equals(this.labTwo.getLocation()))
        {
            if (time1.equals("afternoon") || time1.equals("morning"))
            {
                if (time1.equals("morning") && !(this.labTwo.listReservations().contains("Morning:Reserved\n")))
                {
                    return "Error. Invalid time.";
                }
                if (time1.equals("afternoon") && !(this.labTwo.listReservations().contains("Afternoon:Reserved\n")))
                {
                    return "Error. Invalid time.";
                }
                if (enrollment1 > labTwo.getCapacity())
                {
                    return "Error. Capacity exceeded";
                }
                if (time1.equals("morning"))
                {
                    Session modify = new Session(name1, enrollment1);
                    this.labTwo.setMorning(modify);
                } else if (time1.equals("afternoon"))
                {
                    Session modify = new Session(name1, enrollment1);
                    this.labTwo.setAfternoon(modify);
                }
            } else {
                return "Error. Invalid time.";
            }
        } else if (location1.equals(this.labThree.getLocation()))
        {
            if (time1.equals("afternoon") || time1.equals("morning"))
            {
                if (time1.equals("morning") && !(this.labThree.listReservations().contains("Morning:Reserved\n")))
                {
                    return "Error. Invalid time.";
                }
                if (time1.equals("afternoon") && !(this.labThree.listReservations().contains("Afternoon:Reserved\n")))
                {
                    return "Error. Invalid time.";
                }
                if (enrollment1 > labThree.getCapacity())
                {
                    return "Error. Capacity exceeded";
                }
                if (time1.equals("morning"))
                {
                    Session modify = new Session(name1, enrollment1);
                    this.labThree.setMorning(modify);
                } else if (time1.equals("afternoon"))
                {
                    Session modify = new Session(name1, enrollment1);
                    this.labThree.setAfternoon(modify);
                }
            } else {
                return "Error. Invalid time.";
            }
        } else
        {
            return "Error. Invalid location";
        }
        return "Reservation updated!";
    }

    public String toString()
    {
        return String.format("LabManager{%s, %s, %s}",
                labOne.toString(), labTwo.toString(), labThree.toString());
    }
}
