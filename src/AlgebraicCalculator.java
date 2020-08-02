import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
/**Program now works with multiplication, division, addition and subtraction
 * Implemented powers and factorial following the order of BEDMAS
 * Title: Algebra Calculator
 * Date: 12th of June 2017
 * Version: 1.7
 *Author: Taylor Xi
*/
public class AlgebraicCalculator {
    
    //Added variable kinda
    
    
    //List: Characters, used to find which characters are used
     private static final ArrayList<Character> Characters = new ArrayList<Character>
        	 (Arrays.asList('*', '/', '+', '-','^','!','√'));
     //variable: step (int) used to show the number of steps to the equation
     private static int step = 0;
    
     public static void main(String[] args){
   	  BufferedReader Reader = new BufferedReader(new InputStreamReader(System.in));
   	 
   	  //variable: problem (String) is the expression or problem given
   	  String problem = "placeholder";
   	 
   	  //variable: variable (String) used to keep track of a variable n
   	  String variable = "";
   	 
   	  System.out.print("Enter your algebraic equation, please, and if there is a variable, please use n:");
   	 
   	  //for debugging purposes, to find where the error has occurred if it occurs
   	  try {
   		  problem = Reader.readLine();
   	  } catch (IOException exception){
   		  exception.printStackTrace();
   	  }
   	  //if there is a variable
   	  System.out.println("Given equation:" + problem);
   	  if (-1 !=problem.indexOf("n")){
   		  System.out.println("What is n equal to?");
   		  try {
   			  variable = Reader.readLine();
   		  } catch (IOException exception){
   			  exception.printStackTrace();
   		  }
   	  }
   	 
   	  //to replace any unwanted spaces and PI with the direct value
   	  problem = replace(problem,variable);
   	 
   	  System.out.println("Refined expression:" + problem);
   	 
   	  System.out.println("Answer: " +algebra(problem));
     }
    
     //continuously loop until problem is fully solved
     private static String algebra(String problem) {
    
   	 
   	 
   	 
   	  System.out.println("Step "+step +": " +problem);
   	 step += 1;
   	 
   	 //variable: check (int) used to check the position of characters
   	  int check = 0;

   	  /*if -1 is not equal to the check if the problem has a bracket,
   	   * as if there are no brackets, the indexOf method will return -1
   	   */
   	  if (-1 != (check = problem.indexOf("("))) {
   		  String BracketEquation = TheBInBedmasIsForBrackets(problem,check);
   		 
   		  /*To simultaneously check if there are additional brackets inside the brackets
   		  *and solve the bracket equation
   		  */
   		 
   		 problem = problem.replace("(" +BracketEquation+ ")", algebra(BracketEquation));


   		 return algebra(problem);
   		 
   	 
   		 //if there is a factorial symbol in the equation
   	  }else if (-1 != (check = problem.indexOf('!'))){
   		 
   		  //variable factorialnumber (String) used to find the number being factored
   		  String factorialnumber = Simplify(problem, check, -1);
   		 
   		  //variable counter (double) used to do the factorial
   		  double counter = 1;
   		  //self made factorial method, continuously multiply counter by i until i is equal to
   		  //factorial number
   		  for (int i = 1;
   				  i <= Double.parseDouble(factorialnumber); i++)
   			  counter = counter*i;
   		 
   		 
   		  problem = problem.replace(factorialnumber +"!", Double.toString(counter));

   		  return algebra(problem);
   	  }    
   	  //if there is a power symbol
   	  else if (-1 != (check = problem.indexOf('^'))){
   		 
   		  //variable power (String) used to find the number that is powering
   		  String power = Simplify(problem, check, 1);
   		 
   		  //variable powerednumber (String) used to find the number that is being powered
   		  String powerednumber = Simplify(problem,check, -1);
   		 
   		 
   		  problem = problem.replace(powerednumber +"^" +power,Double.toString(Math.pow
   				  (Double.parseDouble(powerednumber),Double.parseDouble(power))));
   		 
   		  return algebra(problem);
   	  }
   	  //if there is a square root symbol
   	  else if (-1 != (check = problem.indexOf('√'))){
   		 
   		  //variable root (String) the number that is being rooted
   		  String root = Simplify(problem, check, 1);
   		 
   		 
   		  problem = problem.replace("√" +root,Double.toString(Math.sqrt((
   				  Double.parseDouble(root)))));
   				 
   		 
   		  return algebra(problem);
   	  }
   	  //multiplication and division if there are multiplication or division symbols
   	  else if (problem.indexOf("*") > 0 || problem.indexOf("/") > 0){
   		 
   		  //variable checkmult (int) used to find the number being multiplied
   		  int checkmult = problem.indexOf("*");
   		  //variable checkdiv (int) used to find the number being divided
   		  int checkdiv = problem.indexOf("/");
   		 
   		  check = Math.min(checkmult, checkdiv);
   		 
   		  //if there no multiplication signs, check will check the numbers around the division
   		  //symbol, and vice versa
   		  if (checkmult < 0) check = checkdiv;
   		  else if (checkdiv < 0) check = checkmult;
   		 
   		  //variable operator (char) used to do whatever the operator is
   		  char operator = problem.charAt(check);
   		 
   		  //variable leftnum (String) used to find the number to the left of the operator
   		  String leftnum = Simplify(problem,check,-1);
   		  //variable rightnum (String) used to find the number to the right of the operator
   		  String rightnum = Simplify(problem,check,1);
   		 
   		  problem = problem.replace(leftnum + operator + rightnum,
   				  calculate(leftnum, operator, rightnum));
   	  return algebra(problem);
   	  }
   	 //same thing as mult and div, just with add and min
   	  else if (problem.indexOf("+") > 0 || problem.indexOf("-") > 0){
   	 
   		  //variable checkadd (int) find the number being added
   		  int checkadd = problem.indexOf("+");
   		  //variable checkmin (int) find the number being subtracted
   		  int checkmin = problem.indexOf("-");
   		 
   		  check = Math.min(checkadd, checkmin);
   		 
   		  //if there are no plus signs, set check to the minus sign, and vice versa
   		  if (checkadd < 0) check = checkmin;
   		  else if (checkmin < 0) check = checkadd;
   		 
   		  char operator = problem.charAt(check);
   		 
   		  String leftnum = Simplify(problem,check,-1);
   		  String rightnum = Simplify(problem,check,1);
   		 
   		  problem = problem.replace(leftnum + operator + rightnum,
   				  calculate(leftnum, operator, rightnum));
   	  return algebra(problem);
   	  }
   	 
   	 
   	  else return problem;
     }
     private static String Simplify (String problem, int check, int number){
   	 
   	  //variable result (String) used to become the sub expression
   	  String result = "";
   	 
   	  //variable symbol (int) to move the check onto the symbol on the left or right
   	  int symbol = check+number;
   	 
   	  //for negative numbers
   	  if (problem.charAt(symbol) == '-'){
   		  result += problem.charAt(symbol);
   		  symbol += number;
   	  }
   	 
   	  //continuously add on to the result
   	  for (; symbol >= 0 && symbol < problem.length() && !Characters.contains(problem.charAt(symbol)); symbol += number){
   		  result += problem.charAt(symbol);
   	  }
   	  //to flip the equation around since it'll be backwards
   	  if (number == -1) result = new StringBuilder(result).reverse().toString();
   	 
   	  return result;
     }
    
     //the actual calculations
     private static String calculate (String leftnum, int check, String rightnum){
   	  switch (check) {
   	      case '+':
   	     	 return Double.toString(Double.parseDouble(leftnum) + Double.parseDouble(rightnum));
   	      case '-':
   	     	 return Double.toString(Double.parseDouble(leftnum) - Double.parseDouble(rightnum));
   	      case '*':
   	     	 return Double.toString(Double.parseDouble(leftnum) * Double.parseDouble(rightnum));
   	      case '/':
   	     	 return Double.toString(Double.parseDouble(leftnum) / Double.parseDouble(rightnum));
   	      default:
   	     	 return "0";
   	  }
     }
    
     //do the bracket thing
     private static String TheBInBedmasIsForBrackets(String problem, int check) {
   	  //variable Bracket (int)  used as a safeguard
   	  int Bracket = 1;
   	 
   	  //variable BracketEquation (String) the equation in the brackets
   	  String BracketEquation = "";
   	 
   	  /*Continuously add the numbers and signs to the Bracket equation, and add the
   	   * surrounding brackets when a bracket is encountered, when case ( is encountered
   	   * open the bracket, and when case ) is encountered close the bracket. If any other
   	   * key is encountered, default to adding that key or case
   	   */
   	      for (int e = check+1 ;e < problem.length(); e++) {
   	      switch (problem.charAt(e)){
   	      case '(':
   	     	 Bracket ++;
   	     	 BracketEquation += "(";
   	      case ')':
   	     	 Bracket --;
   	     	 if (Bracket !=0)
   	     		 BracketEquation += ")";
   	      default:
   	     	 if (Bracket > 0)
   	     		 BracketEquation += problem.charAt(e);
   	      }
   	  }      			 
   	 return BracketEquation;
   	   }
    
     //replace PI, capital x's and unwanted spaces
     private static String replace(String problem, String variable){
   	 
   	  problem = problem.replace("PI", Double.toString(Math.PI));
   	  problem = problem.replace(" ", "");
   	  problem = problem.replace("X", "*");
   	  problem = problem.replace("n", variable);
   	  return problem;
     }

    
}
