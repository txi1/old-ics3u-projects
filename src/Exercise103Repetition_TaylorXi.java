import java.util.Scanner;

/**
 *
 * @author S332647338
 */
public class Exercise103Repetition_TaylorXi {
    
    public static void main(String[] args) {
      
        Scanner boi = new Scanner(System.in);
        
        int counter = 0;
        int helpMe = 0;
        
        System.out.print("Please enter a positive even integer and press [Enter] ");
        
        while (counter == 0){
            try{
                helpMe = boi.nextInt();
                if (helpMe < 0){
                System.out.print("You have entered a negative value of '" +helpMe +"'. Please enter a positive even integer and press [Enter] ");
                    }else if ((helpMe%2) != 0){
                     System.out.print("You have entered an odd value of '" +helpMe +"'. Please enter a positive even integer and press [Enter] ");   
                        
                    }else
                       counter++;
                        }  
               
            catch (java.util.InputMismatchException ex){
                String placeHolder = boi.nextLine();
                System.out.print("You have an invalid value of '" +placeHolder +"'. Please enter a positive even integer and press [Enter] ");
            }
        }
        
        System.out.print("\nYou have entered an even number.");
        System.out.print("\nHalf of [" +helpMe +"] is [" +(helpMe/2) +"].");
    }
    
}
