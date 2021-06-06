package base;

/*
 *  UCF COP3330 Summer 2021 Assignment 7 Solution
 *  Copyright 2021 Brianne Juntunen
 *
 * Exercise 7 - Area of a Rectangular Room
 * When working in a global environment, you’ll have
 * to present information in both metric and Imperial
 * units. And you’ll need to know when to do the
 * conversion to ensure the most accurate results.

 * Create a program that calculates the area of a room.
 * Prompt the user for the length and width of the room
 * in feet. Then display the area in both square feet
 * and square meters.
 *
 * The formula for this conversion is m2 = f2 × 0.09290304

Constraints
Keep the calculations separate from the output.
Use a constant to hold the conversion factor.

* Challenges
 * Revise the program to ensure that inputs are entered as numeric values.
 * Don’t allow the user to proceed if the value entered is not numeric.
 *
 * Create a new version of the program that allows you to choose feet
 * or meters for your inputs.
 *
 * Implement this program as a GUI program that automatically updates the
 * values when any value changes.
 */

import java.util.Scanner;

public class App {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args){
        App myApp = new App();

        // conversion is m2 = f2 × 0.09290304
        final double conv = 0.09290304;

        double length = myApp.getInput("length");
        double width = myApp.getInput("width");

        myApp.printConfirmation(length, width);

        double areaF = myApp.findAreaFeet(length, width);
        double areaM = myApp.findAreaMeters(areaF, conv);

        myApp.printConversions(areaF, areaM);
    }

    public void printConfirmation(double l, double w){
        System.out.printf("You entered the dimensions of %.0f feet by %.0f feet.\n", l, w);
    }

    public void printConversions(double areaF, double areaM){
        System.out.print("The area is\n");
        System.out.printf("%.0f square feet\n", areaF);
        System.out.printf("%.3f square meters", areaM);
    }

    public double findAreaFeet(double l, double w){
        return l * w;
    }

    public double findAreaMeters(double f2, double conv){
        return f2 * conv;
    }

    public double getInput(String type){
        System.out.print("What is the "+type+" of the room in feet? ");
        return in.nextDouble();
    }
}
