//import Scanner
import java.util.Scanner;

/*
 * Author: Taylor Xi
 * Date: 16th of September 2018
 * Version: 1.2
 */
public class Part1Decisions {

   
    public static void main(String[] args) {
       //Scanner
        Scanner boi = new Scanner(System.in);
       
        //Declare and initialize variables
        int lottoNum = 0;
        int counter = 0;
        
       System.out.print("Please enter a 5 digit number and press [Enter] ");
        //While the counter is 0, continuously try to set lottoNum to an integer, if there's a non-int or negative int input, re-ask user for input
        while (counter == 0){
            try{
                lottoNum = boi.nextInt();
            if (lottoNum < 0){
                System.out.print("You have entered a negative value of '" +lottoNum +"'. Please enter a positive integer and press [Enter] ");
            
            }   else if (lottoNum < 10000){
                        System.out.print("The value '" +lottoNum +"' is too small. Please enter a positive 5 digit integer and press [Enter] ");
                
            }   else if (lottoNum > 99999){
                        System.out.print("The value '" +lottoNum +"' is too big. Please enter a positive 5 digit integer and press [Enter] ");
            }   else
                counter++;
            
            //If there the value the user inputted is too big for an integer to hold or if they inputted a string, re-ask the user for an input       
            }catch (java.util.InputMismatchException ex){
                String placeHolder = boi.nextLine();
                System.out.print("You have an invalid value of '" +placeHolder +"'. Please enter a positive 5 digit integer and press [Enter] ");
            }
        }
        
        if (lottoNum == 34567){
            System.out.print("Congratulations! You are a winner! You have won 1 MILLION DOLLARS!");
        }
        else {
            System.out.print("Unfortunately, you have lost. Better luck next time!");
        }
}
}
