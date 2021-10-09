package com.example.cs180_10_04;
import java.util.Scanner;
/**
 * A program that allows the user to reserve, remove, and modify different lab periods.
 *
 * Purdue University -- CS18000 -- Fall 2021 -- Project 02
 *
 * @author Enoch_Qin Purdue CS
 * @version October 8, 2021
 */
public class TimeKeeper {

    private static String welcomePrompt = "Welcome to the TimeKeeper application!";
    private static String invalidInput = "Invalid input. Please try again.";
    private static String enterLabCapacity = "Enter the capacity for Lab ";
    private static String enterLabLocation = "Enter the location for Lab ";
    private static String labLocationPrompt = "Enter the location of the lab:";
    private static String reservationTimePrompt = "Enter the time of the reservation:";
    private static String reservationNamePrompt = "Enter the name of the reservation:";
    private static String reservationEnrollmentPrompt = "Enter the expected enrollment:";
    private static String reservationNameUpdate = "Enter the updated name of the reservation:";
    private static String reservationEnrollmentUpdate = "Enter the updated enrollment:";
    private static String totalCapacity = "Total Capacity: ";
    private static String totalUtilization = "Total Utilization: ";
    private static String availableSeats = "Available seats: ";


    private static String initializeMenu = "1. Initialize Application\n" +
            "2. Exit";
    private static String ongoingMenu = "1. View Current Lab Schedule\n" +
            "2. List Labs by Availability\n" +
            "3. List Labs by Reservation\n" +
            "4. Add a Reservation\n" +
            "5. Remove a Reservation\n" +
            "6. Modify a Reservation\n" +
            "7. Calculate Statistics\n" +
            "8. Exit";
    private static String statisticsMenu = "1. Total Capacity\n" +
            "2. Total Utilization\n" +
            "3. Available seats\n" +
            "4. Return to main menu";
    private static String exitMessage = "Thank you for using TimeKeeper!";

    public static void main(String[] args)
    {
        System.out.println(welcomePrompt);
        System.out.println(initializeMenu);
        Scanner s = new Scanner(System.in);
        int initial = s.nextInt();
        boolean iniValid = true;
        s.nextLine();
        if (initial > 2 || initial < 1)
        {
            iniValid = false;

        }
        while (iniValid == false)
        {
            System.out.println(invalidInput);
            System.out.println(initializeMenu);
            initial = s.nextInt();
            s.nextLine();
            if (initial == 1 || initial == 2)
            {
                iniValid = true;
            }
        }
        if (initial == 1)
        {
            int cap1;
            int cap2;
            int cap3;
            String loc1;
            String loc2;
            String loc3;
            System.out.println(enterLabCapacity + 1);
            cap1 = s.nextInt();
            s.nextLine();
            System.out.println(enterLabLocation + 1);
            loc1 = s.nextLine();
            System.out.println(enterLabCapacity + 2);
            cap2 = s.nextInt();
            s.nextLine();
            System.out.println(enterLabLocation + 2);
            loc2 = s.nextLine();
            System.out.println(enterLabCapacity + 3);
            cap3 = s.nextInt();
            s.nextLine();
            System.out.println(enterLabLocation + 3);
            loc3 = s.nextLine();
            Lab lab1 = new Lab(cap1, loc1);
            Lab lab2 = new Lab(cap2, loc2);
            Lab lab3 = new Lab(cap3, loc3);
            LabManager labM = new LabManager(lab1, lab2, lab3);
            int ongoing;
            boolean cont = true;
            while(cont == true)
            {
                System.out.println(ongoingMenu);
                ongoing = s.nextInt();
                s.nextLine();
                switch (ongoing)
                {
                    case 1:
                        System.out.println(lab1.toString());
                        System.out.println(lab2.toString());
                        System.out.println(lab3.toString());
                        break;
                    case 2:
                        System.out.println(
                                labM.listAvailableLabs());
                        break;
                    case 3:
                        System.out.println(
                                labM.listReservedLabs());
                        break;
                    case 4:
                        String newLoc;
                        String newTime;
                        String newName;
                        int newEnroll;
                        System.out.println(labLocationPrompt);
                        newLoc = s.nextLine();
                        System.out.println(reservationTimePrompt);
                        newTime = s.nextLine();
                        System.out.println(reservationNamePrompt);
                        newName = s.nextLine();
                        System.out.println(reservationEnrollmentPrompt);
                        newEnroll = s.nextInt();
                        s.nextLine();
                        System.out.println(labM.addReservation(newLoc,newTime, newName, newEnroll));
                        break;
                    case 5:
                        String remLoc;
                        String remTime;
                        System.out.println(labLocationPrompt);
                        remLoc = s.nextLine();
                        System.out.println(reservationTimePrompt);
                        remTime = s.nextLine();
                        System.out.println(labM.removeReservation(remLoc, remTime));
                        break;
                    case 6:
                        String modLoc;
                        String modTime;
                        String modName;
                        int modEnroll;
                        System.out.println(labLocationPrompt);
                        modLoc = s.nextLine();
                        System.out.println(reservationTimePrompt);
                        modTime = s.nextLine();
                        System.out.println(reservationNameUpdate);
                        modName = s.nextLine();
                        System.out.println(reservationEnrollmentUpdate);
                        modEnroll = s.nextInt();
                        s.nextLine();
                        System.out.println(labM.modifyReservation(modLoc,modTime, modName, modEnroll));
                        break;
                    case 7:
                        boolean statsC = true;
                        while (statsC == true)
                        {
                            System.out.println(statisticsMenu);
                            int stats = s.nextInt();
                            s.nextLine();
                            switch (stats)
                            {
                                case 1:
                                    System.out.println(totalCapacity + labM.calculateTotalCapacity());
                                    break;
                                case 2:
                                    System.out.println(totalUtilization + labM.calculateTotalUtilization());
                                    break;
                                case 3:
                                    System.out.println(availableSeats + labM.calculateAvailableSeats());
                                    break;
                                default:
                                    statsC = false;
                                    break;
                            }
                        }
                        break;
                    case 8:
                        cont = false;
                        break;
                    default:
                        System.out.println(invalidInput);
                }
            }
            System.out.println(exitMessage);
        }
        else if (initial == 2)
        {
            System.out.println(exitMessage);
        }
    }
}