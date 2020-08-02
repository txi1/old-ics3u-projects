import java.util.Scanner;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 *
 * @author iviv
 */
public class AlexProgram {

   
    public static void main(String[] args) {

        //Set of integers for all of the sets of numbers
        long num = 1;
        int add = 1;
        //Extra variables that the third number set
        int subtract = 7;
        long oneone = 1;
        int addadd = 1;
        int increase = 1;
        //String variables makes the output a pyramid
        String space = "                  ";
        String space2 = "                  ";

        System.out.print("There are four different mathimagical patterns that you"
                + " can choose from! Enter a number between 1 and 4 to see them!");

        Scanner userInput = new Scanner(System.in);
while(num > 0 && num < 5){

            try{
                int option = userInput.nextInt();

                    switch(option) {

                    case 1: while(add <= 9){
                                System.out.println(space.substring(add) + num 
                                        + " * 8 + 1 = " + (num * 8 + add));
                                add++;
                                num = num*10 + add;
                        }
                            break;

                    case 2: while(num <= 111111111){
                            System.out.println(space.substring(increase * 2)+ num + " * " + oneone + " = " + (num * oneone));
                            num = (num * 10) + add;
                            oneone = (oneone*10) + addadd;
                            increase++;
                        }
                            break;

                    case 3: while(subtract <= 7 && subtract >=0){
                                System.out.println(space.substring(add) + (num * 8 + add) 
                                        + " * " + "9" + "+" + subtract + " = " 
                                        + ((num * 8 + add) * 9 + subtract));
                                add++;
                                subtract--;
                                num = num*10 + add;
                        }
                            break;

                    case 4: while(add <= 9){
                                System.out.println(space.substring(add) + num 
                                        + " * 9 + 2 = " + (num * 9 + add + 1));
                                add++;
                                num = num*10 + add;
                        }
                            break;

                    default: System.out.print("Sorry, you didn't enter one of the four options!");

                    }
}catch(java.util.InputMismatchException ex){
                        String no = userInput.nextLine();
                        System.out.print("Input an integer between 1 and 4!");

                }
            }
        num++;
        }
    }