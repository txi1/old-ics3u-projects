//Import Scanner
import java.util.Scanner;
public class DrawingShapes {
    
    public static void main(String[] args){
        //New Scanner
        Scanner boi = new Scanner(System.in);
        
        //Declare and initialise variable
        boolean replay = true;
        
        //While replay is true, continue playing the game again
        while (replay == true){
            
            drawShapes();
            System.out.println("\nWould you like to replay? (y/n): ");
            //Instead of breaking out of switch, the break will break out of the for loop
            OUTER:
            for (int i = 0; i <= 0;) {
                String playAgain = boi.nextLine();
                
                //If user inputs y or n, continues or stops program respectively.
                //Otherwise, reask for input.
                switch (playAgain.charAt(0)) {
                    case 'Y':
                    case 'y':
                        break OUTER;
                    case 'N':
                    case 'n':
                        replay = false;
                        break OUTER;
                    default:
                        System.out.print("You entered '" +playAgain +"'. "
                                + "Please enter either a 'y' or 'n': ");
                }
            }
        }
        System.out.println("Thank you for playing!");
    }
    
    private static void drawShapes() {
       //New Scanner
        Scanner boi = new Scanner(System.in);
        
        //Declare variables and initalize them
        int height = 0;
        int counter = 0;
        int pattern = 0;
        char symbol;
        
         System.out.println("Please enter the pattern you'd like to see:"
               + "\n1: Square \n2: Parallelogram \n3: Right Triangle \n4: "
                 + "Pyramid \n5: Hourglass \n6: Diamond \n7: Bowtie \n8: Circle"
                 + "\nPlease enter an integer from 1-8 and press [Enter] ");
       
        /* While the counter is 0 (always is), continuously try to set the 
         * height to the user's input. If there is an invalid input (negative
         * or incompatible value (double or string)) or if value is too low or
         * high, then reask for input.
         */
        while (counter == 0){
            try{
                pattern = boi.nextInt();
                if (pattern < 1){
                    System.out.print("The value '" +pattern +"' is too low."
                            + " Please enter a value from 1-8: ");
                    
                } else if (pattern > 8){
                    System.out.print("The value '" +pattern +"' is too high."
                            + " Please enter a value from 1-8: ");
                    
                } else
                    break;
                
            }catch (java.util.InputMismatchException ex){
                String placeHolder = boi.nextLine();
                System.out.print("You have entered an invalid value of '" +placeHolder
                        +"'. Please enter a value from 1-8: ");
            }
        }
        
        System.out.print("Please enter the height (radius for circle)"
                + " of your shape and press [Enter] ");
        
        /* While the counter is 0 (always is), continuously try to set the 
         * height to the user's input. If there is an invalid input (negative
         * or incompatible value (double or string)) then reask for input.
         */
        while (counter == 0){
            try{
                height = boi.nextInt();
                if (height < 0){
                    System.out.print("You have entered a negative value of '"
                    +height +"'. Please enter a positive integer: ");
                }else
                break;
            }catch (java.util.InputMismatchException ex){
                String placeHolder = boi.nextLine();
                System.out.print("You have entered an invalid value of '" 
                +placeHolder +"'. Please enter a positive integer: ");
            }
        }
        boi.nextLine();
        System.out.print("What character would you like to use as the pattern? "
                + "Keep in mind only the FIRST symbol will be read: ");
        
        String placeHolder2 = boi.nextLine();
        symbol = placeHolder2.charAt(0);
        
        switch (pattern){
            case 1:
                drawSquare(symbol,height);
                break;
                
            case 2:
                drawParallelogram(symbol,height);
                break;
            case 3:
                drawTriangle(symbol,height);
                break;
            
            case 4:
                drawPyramid(symbol,height);
               break;
               
            case 5:
                drawHourglass(symbol,height);
               break;
               
            case 6:
                drawDiamond(symbol,height);
               break;
               
            case 7:
                drawBowtie(symbol,height);
                break;
                
            case 8:
                drawCircle(symbol,height);
                break;
}
    }//end drawShapes method
    
    private static void drawSquare (char c, int h){
        System.out.println();
        //Draw h amount of rows
        for (int i = 0; i < h;i++){
            //Draw ONE row
            for (int j = 0;j < h;j++){
                System.out.print(c +" ");
            }
            System.out.println();
        }
    }//end drawSquare method
    
    private static void drawParallelogram (char c, int h){
        System.out.println();
        //Draw h amount of rows
        for (int i = 0; i < h;i++){
            //Spacing
            for (int j = h;j > 0+i;j--){
                System.out.print(" ");
            }
            //Draw ONE row
            for (int k = h;k > 0;k--){
                System.out.print (c + " ");
            }
            System.out.println();
        }
    }//end drawParallelogram method
    
    private static void drawTriangle (char c, int h){
        System.out.println();
        //Draw h amount of rows
        for (int i = 0;i < h; i++){
            //Draw ONE row, with number of characters decreaasing per row
                   for (int j = 0;j <= i;j++){
                       System.out.print(c +" ");
               }
                   System.out.println();
        }
    }//end drawTraingle method
    
    private static void drawPyramid (char c, int h){
        System.out.println();
        //Draw h amount of rows
        for (int i = 0;i < h;i++){
            //Spacing, with number of spaces decreasing per row
                   for(int j = i;j <= h;j++ ){
                       System.out.print(" ");
                   }
                   //Draw ONE row, with amount of characters increasing per row
                   for (int j = i;j >= 0;j--){
                       System.out.print(c +" ");
                   }
                   System.out.println();
        }
    }//end drawPyramid method
    
    private static void drawHourglass (char c, int h){
        //If height is even
        if (h%2 == 0){
                //Draw half of h amount of rows (Top half)
                for (int i = 0;i < h/2;i++){
                   System.out.println();
                   
                   //Spacing, with spacing increasing per row
                    for(int j = i;j > 0;j-- ){
                       System.out.print(" ");
                       
                   }
                    //Draw ONE row, with amount of characters decreasing per row
                    for (int k = h/2;k > i;k--){
                       System.out.print(c +" ");
                       
               }
        }
                //Draw half of h amount of rows (Bottom half)
                for (int i = 0;i <= h/2;i++){
                    
                   //Spacing, with spacing decreasing per row
                   for(int j = i;j < h/2;j++ ){
                       System.out.print(" ");
                   }
                   
                    //Draw ONE row, with amount of characters increasing per row
                    for (int j = i;j > 0;j--){
                       System.out.print(c +" ");
                   }
                       System.out.println();
        }
    }
        
        //If height is odd
        if (h%2 == 1){
                //Draw half of h amount of rows (Top half)
                for (int i = 0;i <= h/2;i++){
                   System.out.println();
                    
                    //Spacing, with spacing increasing per row
                    for(int j = i;j >= 0;j-- ){
                       System.out.print(" ");
                   }
                    //Draw ONE row, with amount of characters decreasing per row
                    for (int k = h/2;k >= i;k--){
                       System.out.print(c +" ");
                       
               }
        }
                //Draw half of h amount of rows (Bottom half), but offset by 1
                for (int i = 0;i <= h/2-1;i++){
                    System.out.println();
                    
                    //Spacing, with spacing increasing per row, but offset by 1
                    for(int j = i+1;j <= h/2;j++ ){
                       System.out.print(" ");
                   }
                    //Draw ONE row, with amount of characters decreasing per row,
                    //but offset by 1
                    for (int j = i+1;j >= 0;j--){
                       System.out.print(c +" ");
                   }
        }
                System.out.println();
                }
    }//end drawHourglass method
    
    private static void drawDiamond (char c, int h){
        //If height is even
        if (h%2 == 0){     
                //Print half of h amount of rows (Top half)
                for (int i = 0;i <= h/2;i++){
                   
                    //Spacing, with spacing decreasing per row
                    for(int j = i;j < h/2;j++ ){
                       System.out.print(" ");
                   }
                    
                    //Draw ONE row, with amount of characters increasing per row
                    for (int j = i;j > 0;j--){
                       System.out.print(c +" ");
                   }
                    System.out.println();
        }
                //Print half of h amount of rows (Bottom half)
                for (int i = 0;i < h/2;i++){
                    
                    //Spacing, with spacing increasing per row
                    for(int j = i;j > 0;j-- ){
                       System.out.print(" ");
                   }
                    
                    //Draw ONE row, with amount of characters decreasing per row
                    for (int k = h/2;k > i;k--){
                       System.out.print(c +" ");
               }
                   System.out.println();
        }
              }
        
        //If height is odd
        if (h%2 == 1){
            //Print half of h amount of rows (Top half)
            for (int i = 0;i <= h/2-1;i++){
                System.out.println();
                //Spacing, with spacing decreasing per row, but offset by 1
                for(int j = i;j <= h/2;j++ ){
                    System.out.print(" ");
        }
                //Draw ONE row, with amount of characters increasing per row,
                //but offset by 1
                for (int j = i;j >= 0;j--){
                       System.out.print(c +" ");
                   }
        }
            
                //Print half of h amount of rows (Bottom half)
                for (int i = 0;i <= h/2;i++){
                   System.out.println();
                    
                    //Spacing, with spacing increasing per row
                    for(int j = i;j >= 0;j-- ){
                       System.out.print(" ");
                   }
                    
                    //Draw ONE row, with amount of characters decreasing per row
                    for (int k = h/2;k >= i;k--){
                       System.out.print(c +" ");
                    }
                }
                System.out.println();
        }
    
    }//end drawDiamond method
    
    private static void drawBowtie (char c, int h){
        System.out.println();
        //If h is even
        if (h % 2 == 0){
                //Print half of h amount of rows (Top half)
                for (int i = h/2;i > 0;i--){
                    
                    //Draw HALF of a row (Left side), with characters increasing
                    //per row
                    for (int j = i; j <= h/2; j++){
                        System.out.print(c +" ");
                    }
                    //Spacing, with spacing decreasing by 2 per row
                    for(int l = (i-1)*2;l > 0;l--){
                        System.out.print("  ");
                    }
                    //Draw HALF of a row (Right side), with characters increasing
                    //per row
                    for (int j = i; j <= h/2; j++){
                        System.out.print(c +" ");
                    }
                    System.out.println();
                }
                //Print half of h amount of rows (Bottom Half)
                for (int i = 1;i <= h/2;i++){
                    //Draw HALF of a row (Left side), with characters decreasing
                    //per row
                    for (int j = i; j <= h/2; j++){
                        System.out.print(c +" ");
                    }
                    //Spacing, with spacing increasing by 2 per row
                    for(int l = (i-1)*2;l > 0;l--){
                        System.out.print("  ");
                    }
                    //Draw HALF of a row (Right side), with characters decreasing
                    //per row
                    for (int j = i; j <= h/2; j++){
                        System.out.print(c +" ");
                    }
                    System.out.println();
                }
        }
                
        //If height is odd
        if (h % 2 == 1){
                //Print half of h amount of rows (Top half), but offset by 1
                for (int i = h/2+1;i > 0;i--){
                    //Draw HALF of a row (Left side), with characters decreasing
                    //per row, and offset by 1
                    for (int j = i; j <= h/2+1; j++){
                        System.out.print(c +" ");
                    }
                    //Spacing, with spacing increasing by 2 per row
                    for(int l = (i-1)*2;l > 0;l--){
                        System.out.print("  ");
                    }
                    //Draw HALF of a row (Right side), with characters decreasing
                    //per row, and offset by 1
                    for (int j = i; j <= h/2+1; j++){
                        System.out.print(c +" ");
                    }
                    System.out.println();
                }
                    
                    //Print half of h amount of rows (Bottom half)
                    for (int i = 2;i <= h/2+1;i++){
                    //Draw HALF of a row (Left side), with characters decreasing
                    //per row
                    for (int j = i; j <= h/2+1; j++){
                        System.out.print(c +" ");
                    }
                    //Spacing, with spacing decreasing by 2 per row
                    for(int l = (i-1)*2;l > 0;l--){
                        System.out.print("  ");
                    }
                    //Draw HALF of a row (Right side), with characters decreasing
                    //per row
                    for (int j = i; j <= h/2+1; j++){
                        System.out.print(c +" ");
                    }
                    System.out.println();
                }
        }
    }//end drawBowtie method
    
    private static void drawCircle (char c, int r){
        System.out.println();
        //Draw basically r*2 amount of rows, the negative will come in handy later
        for (int i = -r; i <= r; i++) {
            //Basically, draw a bubble shape of spaces, then fill in the middle
            //with the symbols. 
            for (int j = -r; j <= r; j++) {
                /* Pretty much, if it's in the middle, write a character, else
                 * input a space. The amount of symbols in the middle will increase
                 * and decrease in comparaison to the radius per row. Since the
                 * i is negative, it'll slowly decrease the characters as we add to it
                 * (negative times negative is positive) until it's 0, then 
                 * increase the characters (positive times positive is positive),
                 * creating the bubble effect. It'll also increase the amount of
                 * spaces and then decrease it, because of the if else statement.
                 */
                if (i*i + j*j <= r*r) 
                    System.out.print(c +" ");
                else
                    System.out.print("  ");
            }
            System.out.println();
        }
    }//end drawCircle method
}//end main class