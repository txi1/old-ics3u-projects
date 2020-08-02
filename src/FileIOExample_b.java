import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class FileIOExample_b {

	public static void main(String[] args)  {
		
		//Note that you need to try catch these elements since some of the lower
		//level commands that we use may "throw" an exception back up to use to deal
		//with! 
		
        //For file in folder called "data" at same hierarchy level as src:
		//String filePath = "data\\testing.txt";
		//But note that the folder "data" must already exist or error
		
		//For file at same hierarchy level as src:
		String filePath = "testing.txt";
		
		//Let's write some data to a file!
		
		try  {
		   //Creates file - Note: Directory for path must already exist
		   PrintWriter fileout = new PrintWriter(
				                 new BufferedWriter(
				                 new FileWriter(filePath)));
							     //to simply open file so that more can be added
				                 //you would use -> new FileWriter(filePath, true)));
		
		   fileout.println("Hey ICS3U, Hope you had a nice weekend!");
		   fileout.println("How do you like file I/O so far?");
		   fileout.println("It will be a handy tool for our summatives.");
		   fileout.close();
		}
		catch (IOException e){
			System.out.println("Sorry there was an error writing");
		}
		
		//Now let's read our data back from file and print to the console!
		
		try {
			BufferedReader filein = new BufferedReader(
				                	new FileReader(filePath));
		
			String line = filein.readLine();
		
			while (line != null)
			{
				System.out.println(line);
				line = filein.readLine();
			}
		
			filein.close();
		}
		catch (IOException e)
		{
			System.out.println("Sorry there was an error reading");
		}
	}
}