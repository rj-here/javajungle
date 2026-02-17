package projects2026;
import java.util.Scanner;
/*
 * © 2026 Rishi
 * Last updated: 7th February, 2026
 * This program is essentially figuring out the next occurence of a specific date. The most recent Christmas (25th Dec, 2025) was on a Thursday.
 * The next time Christmas is on a Thursday is in 2031. So, it's this weird pattern fascination that led to this program coming into existence.
 * I will not be using some well-established algorithm, but will instead code based on my personal pattern observations. Which type of year is it?
 * Is it a leap year? The year before a leap year? The one after? Or a non-leap even number year?
 * That will be how I (try to) determine the next occurence of a specific date.
 * There will be 2 date categories. Dates before (and not including) 1st March, and dates on/after 1st March.
 */
public class nextDateOccurence {
    
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in); //Scanner object to take user input
        System.out.println("Enter the date, one by one");
        System.out.println("First, the weekday that you want to identify the next occurence of");
        String weekday = input.next(); //Taking the weekday as input
        System.out.println("Now, the day");
        int day = input.nextInt(); //Taking the day as input
        System.out.println("Now, the month (in number form)");
        int month = input.nextInt(); //Taking the month as input
        System.out.println("Now, the relevant year (the year it most recently ocurred or will next occur)!");
        int currentYear = input.nextInt(); //Taking the year as input
        input.close(); //Closing the scanner object to prevent memory leaks
        int yearType = intYearType(currentYear); //Determining the year type using the intYearType method
        boolean leapYear = isLeapYear(currentYear); //Determining if it's a leap year using the isLeapYear method
        boolean validDate = validDate(day, month, currentYear, leapYear); //Determining if the date is valid using the validDate method
        int beforeMarch = beforeMarch(month, validDate); //Determining if the date is before (and not including) 1st March using the beforeMarch method
        System.out.println("Calculating!"); //Just a little message to make it feel more interactive and less robotic.
        finalDate(day, month, currentYear, weekday, yearType, beforeMarch, validDate); //Determining the final date using the finalDate method
        System.out.println("Program complete!"); //Just a little message to make it feel more interactive and less robotic.
    }

    public static int intYearType(int year) {
        /*
        This method will determine the year type (in a 4 year set/cycle)
        1 will be a leap year, 2 will be the year before a leap year, 3 will be the year after a leap year, and 4 will be a non-leap even number year.
        Defining a Leap Year: https://en.wikipedia.org/wiki/Leap_year
        */
       if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
        System.out.println("This is a leap year!"); //It's a leap year!
           return 1; //Leap Year
       } else if (year % 4 == 3) {
        System.out.println("This is the year before a leap year!"); //It's the year before a leap year!
           return 2; //Year before a Leap Year
       } else if (year % 4 == 1) {
        System.out.println("This is the year after a leap year!"); //It's the year after a leap year!
           return 3; //Year after a Leap Year
       } else if (year % 4 == 2) {
        System.out.println("This is a non-leap even number year!"); //It's a non-leap even number year!
           return 4; //Non-Leap Even Number Year
       }
       else {
        return -1; //Error
       }
    }

    public static boolean isLeapYear(int year) {
        /*
        This method will determine if a year is a leap year or not, and return a boolean value accordingly.
        */
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            System.out.println("It is a leap year!");
            return true; //Leap Year
        } else {
            System.out.println("It is not a leap year!");
            return false; //Not a Leap Year
        }
    }

    public static int beforeMarch(int month, boolean validDate) {
        /*
        This method will provide a number dependent on the date being before (and not including) 1st March.
        */
        if ((month < 3) && validDate){
            System.out.println("The date is before (and not including) 1st March!"); //Date is before (and not including) 1st March
            return 1; //Date is before (and not including) 1st March
        } else if (validDate){
            System.out.println("The date is on/after 1st March!"); //Date is on/after 1st March
            return 0; //Date is on/after 1st March
        }
        else {
            return -1; //Date is invalid
        }

    }

    public static boolean validDate (int day, int month, int year, boolean leapYear) {
        /*
        This method will check if the date is a valid
        */
       if ((month == 1) || (month == 3) || (month == 5) || (month == 7) || (month == 8) || (month == 10) || (month == 12)) {
           if (day > 0 && day <= 31) {
            System.out.println("The date is valid!"); //Valid Date
            return true; //Valid Date
           }
            else {
            System.out.println("The date is invalid!"); //Invalid Date
            return false; //Invalid Date
            }
       }
       else if ((month == 4) || (month == 6) || (month == 9) || (month == 11)) {
        if (day > 0 && day <= 30) {
            System.out.println("The date is valid!"); //Valid Date
            return true; //Valid Date
           }
            else {
                System.out.println("The date is invalid!"); //Invalid Date
                return false; //Invalid Date
            }
       }
       else if (month == 2) {
        if ((day > 0 && day <= 28)||(leapYear && day == 29)) {
            System.out.println("The date is valid!"); //Valid Date
            return true; //Valid Date
           }
            else {
                System.out.println("The date is invalid!"); //Invalid Date
                return false; //Invalid Date
            }
       }
       else {
           return false; //Invalid Date
       }

    }

    public static void finalDate(int day, int month, int year, String weekday, int yearType, int beforeMarch, boolean validDate) {
        /*
        The final step! This will take all details into account, and provide the next occurence of the date if valid, else it'll provide an error message.
        */
       String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}; //Array to convert month number to month name
       if (yearType == 1) {
        //Code for a leap year
        if (beforeMarch == 0) {
        //For a date on/after 1st March.
        System.out.println("The next time that " + day + " " + months[month-1] + " is on a " + weekday + " is in " + (year+6) + "."); //The next occurence to be in 6 years!
        }
        else if (beforeMarch == 1) {
        //For a date before (and not including) 1st March.
        System.out.println("The next time that " + day + " " + months[month-1] + " is on a " + weekday + " is in " + (year+5) + "."); //The next occurence to be in 1 year!
       }
       }
       else if (yearType == 2) {
        //Code for the year before a leap year
        if (beforeMarch == 0) {
        //For a date on/after 1st March.
        System.out.println("The next time that " + day + " " + months[month-1] + " is on a " + weekday + " is in " + (year+5) + "."); //The next occurence to be in 5 years!
        }
        else if (beforeMarch == 1) {
        //For a date before (and not including) 1st March.
        System.out.println("The next time that " + day + " " + months[month-1] + " is on a " + weekday + " is in " + (year+11) + "."); //The next occurence to be in 11 years!
        }
       }
       else if (yearType == 3) {
        //Code for the year after a leap year
        if (beforeMarch == 0) {
        //For a date on/after 1st March.
        System.out.println("The next time that " + day + " " + months[month-1] + " is on a " + weekday + " is in " + (year+6) + "."); //The next occurence to be in 6 years!
        }
        else if (beforeMarch == 1) {
        //For a date before (and not including) 1st March.
        System.out.println("The next time that " + day + " " + months[month-1] + " is on a " + weekday + " is in " + (year+6) + "."); //The next occurence to be in 6 years!
        }
       }
       else if (yearType == 4) {
        //Code for a non-leap even number year
        if (beforeMarch == 0) {
        //For a date on/after 1st March.
        System.out.println("The next time that " + day + " " + months[month-1] + " is on a " + weekday + " is in " + (year+11) + "."); //The next occurence to be in 6 years!
        }
        else if (beforeMarch == 1) {
        //For a date before (and not including) 1st March.
        System.out.println("The next time that " + day + " " + months[month-1] + " is on a " + weekday + " is in " + (year+6) + "."); //The next occurence to be in 6 years!
        }
       }
    }
    
}
