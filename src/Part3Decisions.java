//Import Scanner
import java.util.Scanner;

/**
 * Author: Taylor Xi
 * Date: 16th of September 2018
 * Version: 1.4
 */
public class Part3Decisions {

    public static void main(String[] args) {
      
        //Declare and initialize variables
        int lottoNum, lottoNum2, lottoNum3;
        lottoNum = lottoSet();
        lottoNum2 = lottoSet();
        lottoNum3 = lottoSet();
         
        if ((lottoNum - lottoNum2) == lottoNum3){
            System.out.print("\nCongratulations! " +lottoNum +"-" +lottoNum2 +" = " +lottoNum3 +", you won!");
            
        }else if ((lottoNum2 - lottoNum) == lottoNum3){
            System.out.print("\nCongratulations! " +lottoNum2 +"-" +lottoNum +" = " +lottoNum3 +", you won!");
            
        } else if ((lottoNum + lottoNum2) == lottoNum3){
            System.out.print("\nCongratulations! " +lottoNum +"+" +lottoNum2 +" = " +lottoNum3 +", you won!");
            
        } else if ((lottoNum * lottoNum2) == lottoNum3){
            System.out.print("\nCongratulations! " +lottoNum +"*" +lottoNum2 +" = " +lottoNum3 +", you won!");
          
            //if lottoNum2 is not equal to 0, attempt the division.
        } else if (lottoNum2 != 0){
           
            if ((lottoNum / lottoNum2) == lottoNum3){
                System.out.print("\nCongratulations! " +lottoNum +"/" +lottoNum2 +" = " +lottoNum3 +", you won!");
       
            } else if (lottoNum != 0){
                    
                        if ((lottoNum2 / lottoNum) == lottoNum3){
                        System.out.print("\nCongratulations! " +lottoNum2 +"/" +lottoNum +" = " +lottoNum3 +", you won!");
                        } else
               System.out.print("\nUnfortunately, you have lost... Better luck next time!");
      
        } 
        
        }
    }
    private static int lottoSet (){
        
        Scanner boi = new Scanner(System.in);
        //Declare and initalize variables
        int counter = 0;
        
        System.out.print("Please enter the value for integer and press [Enter] ");
        //While the counter is 0, continuously try to set lottoNum to an integer, if there's a non-int, re-ask user for input
        while (counter == 0){
            try{
                counter++;
            }catch (java.util.InputMismatchException ex){
                String placeHolder = boi.nextLine();
                System.out.print("You have an invalid value of '" +placeHolder +"'. Please enter an integer and press [Enter] ");
            }
    }
        return boi.nextInt();  
    }
}
    
