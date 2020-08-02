import java.util.Scanner;

/**
 * Calculate someone's body mass index to indicate whether
 * or not that person is at a healthy body weight.
 *
 * @author  Ms Cianci
 * @since   Monday, September 15, 2008
 * Modified by: Taylor Xi
 * Date of modification: The 9th of October, 2018
 */
public class BMICalculator
{
	// constants used to represent the posible user's choices
	private static final int IMPERIAL_CHOICE = 1;
	private static final int METRIC_CHOICE = 2;	

	// create a Scanner object so that input can be obtained 
	// from within any method
	private static Scanner console = new Scanner(System.in);

	
	/** 
	 * Call on appropriate methods to get input from the user so that the
	 * corresponding BMI can be calculated and displayed
	 */
	public static void main(String[] args) 
	{			
		// display title
		System.out.print("HOW HEALTHY ARE YOU?");
		
                System.out.println("\nInput 1 for imperial measurements and "
                    + "input 2 for metric measurements: ");
                int choice = getChoice();
                        while (choice != 1 && choice !=2){
                            System.out.print("You inputted an invalid value of '" +choice 
                            +"'. Please enter either 1 or 2: ");
                            choice = getChoice();
                        }
		int weight = getWeight(choice);
		double height = getHeight(choice);
			
		int bmi = getBMI(weight, height, choice);
			
		System.out.println("\n\nThe corresponding BMI is " + bmi + ".");
			
		displayHealthMessage(bmi);
			
	} // end main
	
	
	/**
	 * Ask the user to enter one for imperial and two for metric.
	 * Continue to ask the user to enter one or two if they enter 	 
	 * any other numeric value.
 	 */
	public static int getChoice() 
	{
            
            int choice = 0;
            for (int i = 0; i == 0;){
            try{
                choice = console.nextInt();
                if (choice < 0){
                    System.out.print("You have inputted a negative value of '" +choice +"'. Plesae reenter a value: ");
                }else 
                    break;
            }catch (java.util.InputMismatchException ex){
                String placeHolder = console.nextLine();
                System.out.print("You have inputted an invalid value of '" +placeHolder
                +"'. Please enter 1 or 2: ");
            }
            }return choice;
        }
        
        //Ask the user for a given value, then re-ask if given value is invalid
        public static double getChoiceDouble() 
	{
            
            double choice = 0;
            for (int i = 0; i == 0;){
            try{
                choice = console.nextDouble();
                if (choice < 0){
                    System.out.print("You have inputted a negative value of '" +choice +"'. Plesae reenter a value: ");
                }else 
                    break;
            }catch (java.util.InputMismatchException ex){
                String placeHolder = console.nextLine();
                System.out.print("You have inputted an invalid value of '" +placeHolder
                +"'. Please enter 1 or 2: ");
            }
            }return choice;
        }
	
	
	
	/**
	 * Get the user's weight (from the console) in either pounds or kgs and return the input.
	 * @param c Represents either imperial or metric units
	 * @return  The weight entered by the user (either in pounds or kilograms)
	 * NOTE: THIS METHOD HAS BEEN COMPLETED FOR YOU! JUST READ AND UNDERSTAND IT...
	 */
	public static int getWeight(int c) 
	{
		int w = -1;			// initial with a "default value"
		
		if(c == IMPERIAL_CHOICE)
		{
			// get weight in pounds
			System.out.print("\nEnter weight in pounds: \t\t");
			w = getChoice();
		}
		
		else if(c == METRIC_CHOICE)
		{
			// get weight in kilograms
			System.out.print("\nEnter weight in kilograms: \t\t\t\t");
			w = getChoice();
		}
		
		return w;
	} // end getWeight method

	
	/**
	 * Get the user's height (from the console) in either feet and inches or in meters and 
	 * return the height (in either inches or meters)
	 * @param c The user's choice, (representing either imperial or metric)
	 * @return The height entered by the user (either in inches or meters)
	 */
	public static double getHeight(double c)
	{
		double h = 0;
		
		if(c == IMPERIAL_CHOICE)
		{
			// get height in feet and inches
                        System.out.print("\nEnter height in feet: \t\t\t\t");
			h = getChoiceDouble();
			
			// calculate corresponding height in inches only and store in h			
			h*=12;
		}
		
		else if(c == METRIC_CHOICE)
		{
			// get height in meters
                        System.out.print("\nEnter height in meters: \t\t\t\t");
			h = getChoiceDouble();
			
		}
		
		return h;
	} // end getheight method
	

	/**
	 * @param w  The weight (in pounds or kilograms)
	 * @param h  The height (in inches or meters)
	 * @param c  The user's choice, (representing either imperial or metric)
	 * @return   The corresponding BMI
	 * NOTE: THIS METHOD HAS BEEN COMPLETED FOR YOU. YOU NEED TO READ AND UNDERSTAND IT.
	 */
	public static int getBMI(int w, double h, int c)
	{
		// if the user chose imperial then bmi = 703 x weight in pounds / height in inches squared
		if(c == IMPERIAL_CHOICE)
			return (int)(w * 703 / (h * h));
		
		// if the user chose metric then bmi = weight in kilograms / height in meters squared
		else if(c == METRIC_CHOICE)
			return (int)(w / (h * h));
		
		return -1; // this should "never" be reached but the method always needs to return something
	} // end getBMI method
	
	
	/**
	 * Display a message describing a person's health with the given BMI
	 * @param bmi Someone's body mass index
	 * NOTE: THIS METHOD HAS BEEN COMPLETED FOR YOU. YOU NEED TO READ AND UNDERSTAND IT.
	 */
	public static void displayHealthMessage(int bmi)
	{
			// display a message describing if this is a healthy weight
			if(bmi < 18.5)
				System.out.println("This person is underweight.\n\n");
			else if(bmi < 24.9)
				System.out.println("This person is at a normal weight.\n\n");
			else if(bmi < 29.9)
				System.out.println("This person is overweight.\n\n");
			else
				System.out.println("This person is obese.\n\n");
	
	} // end displayHealthMessage method		
		
} // end class