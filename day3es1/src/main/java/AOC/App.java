package AOC;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class App 
{
    public static void main(String[] args) {
        try {
            File input = new File("input.txt");
            Scanner reader = new Scanner(input);
            int treesFound = 0, index = 0;

            while (reader.hasNextLine()) {
                String row = reader.nextLine();
                if(row.charAt(index) == '#') 
                    treesFound ++;
                
                index +=3;
                if(index >= row.length()) 
                    index = index % (row.length());                
            }
            System.out.println(treesFound);
            
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error reading file");
            e.printStackTrace();
        }
    }
}