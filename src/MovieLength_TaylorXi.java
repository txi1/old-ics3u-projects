import java.util.Scanner;

/** Author: Taylor Xi
 *  Date: September 13th 2018
 *  Version: 1.5
 */
public class MovieLength_TaylorXi {

   
    public static void main(String[] args) {
       Scanner boi = new Scanner(System.in);
        int counter = 0;
        int movieTotal = 0;
           System.out.print("Please enter the length of a movie in seconds and press [Enter] ");
        
           while (counter == 0){
            try{
                movieTotal = boi.nextInt();
                counter++;
         } 
            catch(java.util.InputMismatchException ex){
            
             String place = boi.nextLine();
             System.out.print("You have entered an invalid value of '" +place +"'. Please reenter a number:  ");
         }
            
        }        
        
        int movieHours = (movieTotal/3600);
        int movieMinutes = ((movieTotal-movieHours * 3600) / 60);
        int movieSeconds = (movieTotal-(movieHours * 3600 + movieMinutes * 60));
        
        

     System.out.print("The length of the movie is " + movieHours +" hours, " + movieMinutes +" minutes and " + movieSeconds +" seconds, or " + movieHours +":" + movieMinutes +":" + movieSeconds +"." );
     
         }
    }    


