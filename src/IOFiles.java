import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class IOFiles {

    public static void main(String[] args) {

        IO boi = new IO();
        
        String filePath = "Poetry.txt";
        
        boi.createOutputFile(filePath);
        
        boi.println("Files are read,");
        boi.println("Concepts are new...");
        boi.println("IO is neat,");
        boi.println("There's much to do!");
        boi.closeOutputFile();
        
        boi.openInputFile(filePath);
        try{
            String text = boi.readLine();
            while(text != null){
            System.out.println(text);
            text = boi.readLine();
            }
            boi.closeInputFile();
        }catch(IOException e){
            System.out.println("Sorry, there was an error reading the file.");
        }
                   
                   
		}
}
