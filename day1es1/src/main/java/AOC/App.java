package AOC;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;


public class App 
{
    public static void main( String[] args )
    {
        try {
            File input = new File("input.txt");
            Scanner reader = new Scanner(input);
            Vector<Integer>inputVector = new Vector<Integer>();
            while(reader.hasNextLine()) {
                Integer data = Integer.parseInt(reader.nextLine());
                inputVector.add(data);
            }
            
            for (int i=0; i<inputVector.size(); i++) {
                for (int y =i+1; y<inputVector.size(); y++) {
                    if(inputVector.get(i) + inputVector.get(y) == 2020) {
                        System.out.println(inputVector.get(i) * inputVector.get(y));
                    }
                }
            }
            
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error reading file");
            e.printStackTrace();
        }
    }
}
