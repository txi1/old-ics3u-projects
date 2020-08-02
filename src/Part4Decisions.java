//Import scanner
import java.util.Scanner;

/*
 * Author: Taylor Xi 
 * Date: Technically the 17th of September 2018, but going to say the 16th of September 2018
 * Version: 1.4
 */

public class Part4Decisions {
    
    public static void main(String[] args) {
       
        //Scanner
        Scanner boi = new Scanner(System.in);
        
        //Declare and initialize variables
        int counter = 0;
        double discPrice = 0;
        int discQuantity = 0;
        
        System.out.print("Please enter the amount of DVDs you'd like to purchase and press [Enter] ");
          //While the counter is 0, continuously try to set discQuantity to an integer, if there's a non-int or negative int input, re-ask user for input
          while (counter == 0){
            try{
                discQuantity = boi.nextInt();
            if (discQuantity < 0){
                System.out.print("You have entered a negative value of '" +discQuantity +"'. Please enter a positive integer and press [Enter] ");
           
            }   else
                counter++;
            
            //If there the value the user inputted is too big for an integer to hold or if they inputted a string, re-ask the user for an input       
            }catch (java.util.InputMismatchException ex){
                String placeHolder = boi.nextLine();
                System.out.print("You have an invalid value of '" +placeHolder +"'. Please enter a positive integer and press [Enter] ");
            }
        }
         
        System.out.print("Please enter the price of the DVDs you'd like to purchase and press [Enter] ");  
          
        //While the counter is 1, continuously try to set discPrice to a double, if there's a non-double or negative double input, re-ask user for input
        while (counter == 1){
            try{
                discPrice = boi.nextDouble();
            if (discPrice < 0){
                System.out.print("You have entered a negative value of '" +discPrice +"'. Please enter a positive integer and press [Enter] ");
           
            }   else
                counter++;
            
            //If there the value the user inputted is too big for an integer to hold or if they inputted a string, re-ask the user for an input       
            }catch (java.util.InputMismatchException ex){
                String placeHolder = boi.nextLine();
                System.out.print("You have an invalid value of '" +placeHolder +"'. Please enter a positive integer and press [Enter] ");
            }
        }
        //The calculations are done here
        System.out.printf("\n\nPrice of the DVDs: $%.2f", discPrice);
        System.out.printf("\n\nSubtotal: $%.2f", (discQuantity*discPrice));
        System.out.printf("\nTax: $%.2f", ((discQuantity*discPrice) * 0.13));
        System.out.printf("\nTotal price: $%.2f", (discQuantity*discPrice + (discQuantity*discPrice * 0.13)));
    }
    
}
