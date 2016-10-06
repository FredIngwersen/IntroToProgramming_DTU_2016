package assignment_1;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;
 
public class tickets {
    public static Scanner scanner = new Scanner(System.in);
    public static Random rand = new Random(53332274312L);
    public static DecimalFormat df2 = new DecimalFormat("00");
     
    public static String randomTime() {
        return df2.format(rand.nextInt(24)) + ":" + df2.format(rand.nextInt(60));
    }
     
    //The main method of the program. In the start our variables are defined. Furthermore the randomTime() method is saved to an array, which is 
    //split into two integers "hours" and "minutes". The string value according to correct array index is then parsed into the correct integer. Index 0 = hours and index 1 = minutes. 
    public static void main(String[] args) {
        String input = "";
        String time = randomTime();
        String parktime = time;
        String[] time_comps = time.split(":");
        int hours = Integer.parseInt(time_comps[0]);
        int minutes = Integer.parseInt(time_comps[1]);
        int total = 0;
        int change = 0;
        boolean total_reached = false;
         
        //The UI of the program is running in a while loop. If anything but T is pressed the program will keep running. 
        //If T is pressed though, the while loop will be skipped and thus the program will terminate, shutdown message will be printed according to the last string.
        while (!input.equals("T")) {
        	if(total == 120){
                input = "";
                System.out.println("****************************");
                System.out.println(" The time is " + time);
                System.out.println(" Parking time until " + parktime);
                System.out.println(" C - Cancel");
                System.out.println(" B - Buy");
                System.out.println("****************************"); 
                input = scanner.nextLine();
        	} else {
	            //The following initializes our variable input and prints the ticket graphics.
	            input = "";
	            System.out.println("****************************");
	            System.out.println(" The time is " + time);
	            System.out.println(" Parking time until " + parktime);
	            System.out.println(" Please insert Coins");
	            System.out.println(" C - Cancel");
	            System.out.println(" B - Buy");
	            System.out.println("****************************"); 
	            input = scanner.nextLine();
        	}
            //A nested if statement which controls if the input from the scanner is exactly as shown below. This prevents illegal coins to be inserted to the program.
            if (input.equals("1") || input.equals("2") || input.equals("5") || input.equals("10") || input.equals("20")) {
                 
                //A nested if statement which controls maximum parking time. If total_reached is true, no more time can be bought.
                if (!total_reached) {
                    int coin = Integer.parseInt(input);
                    change += coin;
                    minutes += coin * 2;
                    total += coin * 2;
                     
                    //An if statement which controls amount of coins which is inserted. If the amount exceeds 60 and more than 120 minutes have been bought, it will
                    //return coins accordingly to the minutes above 120 that is paid for. 140 minutes bought will return 10 coins, print message and return a total_reached value of true,
                    //thus skipping above if statement.
                    if (total >= 120) {
                        change = (total % 120) / 2;
                        System.out.println("Maximum Parking time reached. " + change + " dkk returned.");
                        minutes -= coin * 2;
                        minutes += (coin - change) * 2;
                        total_reached = true;
                    }
                     
                    //An if statement which correctly controls the time. If minutes passes 60, it will be reduced to 0 and hours will be raised by 1.
                    if (minutes >= 60) {
                        minutes = minutes % 60;
                        hours += 1;
                        if (hours >= 24) {
                            hours = 0;
                        }
                    }
                    //The following two if/else statements converts an hour/minute integer to a string. If the string is shorter than the length of 2, a 0 will be added in front.
                    if (Integer.toString(hours).length() < 2) {
                        parktime = "0" + hours + ":";
                    } else {
                        parktime = hours + ":";
                    }
                    if (Integer.toString(minutes).length() < 2) {
                        parktime += "0" + minutes;
                    } else {
                        parktime += minutes;
                    }
                 
                //Rejects further coin inserts and prints message if total_reached evaluates to true.   
                } else {
                    System.out.println("Maximum Parking time reached.");
                }
             
            //An else if statement which is started if input is exactly C or c. It cancels the ticket purchase and returns coins inserted; printing transaction completed.  
            //It also resets the values of our variables, so that they are ready to be used again in the start of our while loop with a new randomTime().   
            } else if (input.equals("C") || input.equals("c")) {
                System.out.println("Operation cancelled. Money returned " + change + " dkk.");
                System.out.println("=== Transaction completed ===");
                total = 0;
                time = randomTime();
                parktime = time;
                change = 0;
                time_comps = time.split(":");
                minutes = Integer.parseInt(time_comps[1]);
                hours = Integer.parseInt(time_comps[0]);
                total_reached = false;
             
            //Same scenario as above else if statement. Only change is, if B or b is pressed a ticket will be paid for and the purchase completed; printing message according to.   
            } else if (input.equals("B") || input.equals("b")) {
                System.out.println("Your ticket is printed. Thank you");
                System.out.println("=== Transaction completed ===");
                total = 0;
                time = randomTime();
                parktime = time;
                change = 0;
                time_comps = time.split(":");
                minutes = Integer.parseInt(time_comps[1]);
                hours = Integer.parseInt(time_comps[0]);
                total_reached = false;
             
            //An else if statement which returns an error message if the input is anything but T.   
            } else if (!input.equals("T")) {
                System.out.println("Illegal coin, try again.");
            }   
        }
        //If input is T, the while loop is skipped and the following shut down message is printed.
        System.out.println("Shutting down.");
    }
}