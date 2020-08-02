//Import scanner
import java.util.Scanner;
/*
 * Author: Taylor Xi
 * Date: 16th of September 2018
 * Version: 1.1
 */
public class Part2Decisions {
    
    public static void main(String[] args) {
        //Scanner
        Scanner boi = new Scanner(System.in);
       
        //Declare and initialize variables
       int counter = 0;
       int lottoNum = 0;
       int lottoNum2 = 0;
        
       System.out.print("Please enter an integer and press [Enter] ");
       
       //While the counter is 0, continuously try to set lottoNum to a 5 digit int integer, if there's a non-int or a non 5 digit int, re-ask user for input
        while (counter == 0){
            try{
                lottoNum = boi.nextInt();
                counter++;
            }catch (java.util.InputMismatchException ex){
                String placeHolder = boi.nextLine();
                System.out.print("You have an invalid value of '" +placeHolder +"'. Please enter an integer and press [Enter] ");
            }
    }
        
        System.out.print("Please enter a second integer and press [Enter] ");
        
        //While the counter is 1, continuously try to set lottoNum2 to a 5 digit int integer, if there's a non-int or a non 5 digit int, re-ask user for input
        while (counter == 1){
            try{
                lottoNum2 = boi.nextInt();
                counter++;
                    
            }catch (java.util.InputMismatchException ex){
                String placeHolder = boi.nextLine();
                System.out.print("You have an invalid value of '" +placeHolder +"'. Please enter an integer and press [Enter] ");
            }
            
            if (lottoNum > lottoNum2){
            System.out.print( "\n" +lottoNum +" is bigger than " +lottoNum2 +".");
        }
            if (lottoNum < lottoNum2){
            System.out.print( "\n" +lottoNum2 +" is bigger than " +lottoNum +".");
        }
            if (lottoNum == lottoNum2){
            System.out.print( "\n" +lottoNum +" is equal to " +lottoNum2 +".");
        }
    }
    
}
}
