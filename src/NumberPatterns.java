//import Scanner
import java.util.Scanner;

/**
 * Author: Taylor
 * Date: 23rd of September, 2018
 * Version: 1.0
 */
public class NumberPatterns {
    
    public static void main(String[] args) {
        //Scanner2
        Scanner boi = new Scanner(System.in);
        
        //declare variables
        int i = 1;
        long j = 0;
        int counter = 0;
        int pattern = 0;
        String space = "                    ";
        
        System.out.print("Please input the number pattern you'd like to see. (1-4) ");
        //While the counter is 0, continuously try to set pattern to an integer, if there's a non-int or negative int input, re-ask user for input
        while (counter == 0){
            try{
                pattern = boi.nextInt();
            if (pattern < 0){
                System.out.print("You have entered a negative value of '" +pattern +"'. Please enter a number from 1-4 and press [Enter] ");
            
            }   else if (pattern < 1){
                        System.out.print("The value '" +pattern +"' is too small. Please enter a number from 1-4 and press [Enter] ");
                
            }   else if (pattern > 5){
                        System.out.print("The value '" +pattern +"' is too big. Please enter a number from 1-4 and press [Enter] ");
            }   else
                counter++;
            
            //If there the value the user inputted is too big for an integer to hold or if they inputted a string, re-ask the user for an input       
            }catch (java.util.InputMismatchException ex){
                String placeHolder = boi.nextLine();
                System.out.print("You have an invalid value of '" +placeHolder +"'. Please enter a number from 1-4 and press [Enter] ");
            }
        
            //Case selection
        switch (pattern){
        
            case 1:
                while (i <= 9){
                    j = j*10+i;
                    System.out.print(space.substring(i) +j +" * " +8 +" + " +i + " = " +(j*8+i) +"\n");
                    i++;
        }       
                break;
            
            case 2:
                while (i <= 7){
                    j = j*10+1;
                    System.out.println(space.substring(i*2) +j +" * " +j +" = " +(j*j));
                    i++;
        }
                break;
    
            case 3:
                i = 2;
                while (i <= 10){
                    j = j*10+i-1;
                    System.out.print(space.substring(i) +j +" * " +9 +" + " +i + " = " +(j*9+i) +"\n");
                    i++;
        }
                break;

            case 4:
                i = 7;
                j = 9;
                int k = 1;
                while (i >= 1){
                    j = j*10+i+1;System.out.print(space.substring(k) +j +" * " +9 +" + " +i + " = " +(j*9+i-1) +"\n");
                    i--;
                    k++;
        }
}
}
}
}


