/* Programmer:  Sara Sunny
Language:       Java
Purpose:        Application to calculate health needs based on user input
URL:
Assignment:     Homework 6
Date:           11/11/20
Course:         Info-210
*/
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iusb.cs;

/**
 *
 * @author slbru
 */

import java.util.Scanner;
public class HW6 {
    public static void main (String [] args) {
    Scanner input = new Scanner (System.in); //scanner for user input
    
    int age = 0; 
    double weight =0; double height=0;
    int choice;
    
    System.out.println("----Welcome to the health calculator application----");
    //inputting age into variable and checking for invalid inputs
    System.out.println("Please input your age: ");
    while (input.hasNext()) {
        if (input.hasNextInt()) {
            age = input.nextInt();
            if (age <=0 ) {
                System.out.println("Error. Please input your age: ");
            }
            else {
                break;
            }
        }
        else {
            System.out.println("Error. Please input your age as a number: ");
            input.next();
        }
    } //inputting weight into variable and checking for invalid inputs
    System.out.println();
    System.out.println("Please input your weight in pounds: ");
    while (input.hasNext()) {
        if (input.hasNextDouble()) {
            weight = input.nextDouble();
            if (weight <= 0) {
                System.out.println("Error. Please input your weight in pounds: ");
            }
            else {
                break;
            }
        }
        else {
            System.out.println("Error. Please input your weight in pounds as a number: ");
            input.next();
        }
    } //inputting height into variable and checking for invalid inputs
    System.out.println();
    System.out.println("Please input your height in inches: ");
    while (input.hasNext()) {
        if (input.hasNextDouble()) {
            height = input.nextDouble();
            if (height <= 0) {
                System.out.println("Error. Please input your height in inches: ");
            }
            else {
                break;
            }    
        }
        else {
            System.out.println("Error. Please input your height in inches as a number: ");
            input.next();
        }    
    }
    System.out.println();
    do { //sentinel loop to allow user to choose which function (-1 to quit) 
        System.out.println("Application options. Select number by calculation you wish to complete ");
        System.out.println("1 \t Calculate target heart rate");
        System.out.println("2 \t Calculate BMI");
        System.out.println("3 \t Calculate calories needed to maintain current weight");
        System.out.println("-1 \t Exit application");
        choice = input.nextInt();
        
        switch (choice) {
            case 1: //calling function for target heart rate 
                calculateHeartRate(age);
                break;
            case 2: //calling function for BMI calculator
                calculateAdultBMI(weight, height);
                break;
            case 3: //calling function
                calorieCalculator(age, weight, height);
                break;
            case -1: //-1 to quit loop and end application
                System.out.println("GoodBye");
                break;
        }
        System.out.println("---------------------------------------------------------------------------");
    } while (choice != -1); //loop control variable
    }   
    //function for target heart rate
public static void calculateHeartRate(int a) {
    float maxRate; float modRate;
    
    maxRate = 220 - a;
    modRate = maxRate / 2;

    System.out.printf("%s%.2f%s%.2f%n", "Target range for moderate to maximum heart rate is from ", modRate, " to ", maxRate);
}
//function for BMI which calls a helper function to complete calculations
public static void calculateAdultBMI(double w, double h) {
    
    double b = calculateAdultBMIhelper(w, h); //variable b stores value calculated by helper function
    System.out.printf("%s%.2f%n", "Your BMI is ", b);
}
//helper function to complete BMI calculations
public static double calculateAdultBMIhelper(double wei, double hei) {  
    double BMI = (wei / (hei*hei))*703;
    return BMI; //returns the value of BMI and stores it into the variable assigned in function calling helper function
}
//extra credit
//function to calculate calorie needs based on weight and height
public static void calorieCalculator(int a, double w, double h) {
   Scanner input = new Scanner (System.in);
    String gender; 
    String activity;
    double BMR = 0;
    double calorie = 0;
    
    System.out.println();
    System.out.println("Are you female or male?");
    
    OUTER: //gender input and validity check
    while (input.hasNext()) { //loops if invalid
    gender = input.nextLine();
    switch (gender) {
        case "female": //if gender = female do this calculation
            BMR = 655 + (4.35 * w) + (4.7 * h) - (4.7* a);
            break OUTER;
        case "male":
            BMR = 66+ (6.23 * w) + (12.7 * h) - (6.8 * a);
            break OUTER;
        default:
            System.out.println("Error. Please input gender: ");
            break;
    }
    }
    
    System.out.println();
    //display output to show categories for activity levels
    System.out.println("Please select the appropriate activity level that fits your lifestyle");
    System.out.printf("%s\t\t%s%n", "sedentary", "(little or no exercise)");
    System.out.printf("%s\t\t%s%n", "lightly active", "(light exercise/sports 1-3 days/week)");
    System.out.printf("%s\t%s%n", "moderately active", "(moderate exercise/sports 3-5 days/week)");
    System.out.printf("%s\t\t%s%n", "very active", "(hard exercise/sports 6-7 days/week)");
    System.out.printf("%s\t\t%s%n", "extra active", "(very hard exercise/sports & physical job or 2x training)");
    System.out.println(); 
    
        OUTER: //activity level input and validity check
        while (input.hasNext()) { //loops if invalid
            activity = input.nextLine();
            switch (activity) {
                case "sedentary": //if activity = sedentary do this calculation 
                    calorie = BMR * 1.2;
                    break OUTER;
                case "lightly active":
                    calorie = BMR * 1.375;
                    break OUTER;
                case "moderately active":
                    calorie = BMR * 1.55;
                    break OUTER;
                case "very active":
                    calorie = BMR * 1.725;
                    break OUTER;
                case "extra active":
                    calorie = BMR * 1.9;
                    break OUTER;
                default:
                    System.out.println("Error. Please select activity level:");
                    break;
            }
        }
    System.out.println();
    System.out.printf("%s%.2f%n", "The amount of calories needed to maintain current weight is ", calorie);
    }
}
