//import Scanner
import java.util.Scanner;

/*
* Author: Taylor Xi
* Date: September 11th of 2018
* Version: 1.3
*/

public class CashierProgram {
     
    
    
    
    public static void main(String[] args){

        //Declare variables
        double item1, item2, item3, item4, item5, subtotal;
        
        //Ask the user for item prices
        System.out.print("Please enter the price of item 1: ");
        item1 = itemPrice();
        System.out.print("Please enter the price of item 2: ");
        item2 = itemPrice();
        System.out.print("Please enter the price of item 3: ");
        item3 = itemPrice();
        System.out.print("Please enter the price of item 4: ");
        item4 = itemPrice();
        System.out.print("Please enter the price of item 5: ");
        item5 = itemPrice();
        
        //Print item prices rounded to 2 decimal places
        System.out.printf("\n\nPrice of item 1: $%.2f", item1);
        System.out.printf("\nPrice of item 2: $%.2f", item2);
        System.out.printf("\nPrice of item 3: $%.2f", item3);
        System.out.printf("\nPrice of item 4: $%.2f", item4);
        System.out.printf("\nPrice of item 5: $%.2f", item5);
        
        //Add all the prices together to get subtotal
        subtotal = item1 + item2 + item3 + item4 + item5;
        
        //Print the subtotal, multiply subtotal by tax, which is 0.13, and add them both to obtain total price
        System.out.printf("\n\nSubtotal: $%.2f", subtotal);
        System.out.printf("\nTax: $%.2f", (subtotal * 0.13));
        System.out.printf("\nTotal price: $%.2f", (subtotal + (subtotal * 0.13)));
        }
        
//itemPrice method, to check if the price the user entered was a double
    private static double itemPrice() {
        Scanner userInput = new Scanner(System.in);
     
    //while what the user is inputting does NOT have a double        
      while (!userInput.hasNextDouble()){
          
        //Flush buffer  
        userInput.next();
        
        //Re-ask for user input, this time specifying for a double value  
        System.out.print("You have entered an invalid value; Please enter a double value: ");         
            
        }
      return userInput.nextDouble();
    }
}
    

