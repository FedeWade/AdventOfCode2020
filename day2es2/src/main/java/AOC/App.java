package AOC;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class App 
{
    static boolean checkPsw(int pos1, int pos2, char letter, String password) {
        int occurrencies = 0;
        if(password.charAt(pos1-1) == letter) occurrencies ++;
        if(password.charAt(pos2-1) == letter) occurrencies ++;
        if(occurrencies == 1) return true;
        return false;
    }

    public static void main(String[] args) {
        try {
            File input = new File("input.txt");
            Scanner reader = new Scanner(input);

            int validatedPsw = 0;

            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                String[] tokenizedData = data.split(" ");

                String[] bounds = tokenizedData[0].split("-");
                int pos1 = Integer.parseInt(bounds[0]);
                int pos2 = Integer.parseInt(bounds[1]);
                char letter = (tokenizedData[1]).charAt(0);
                String password = tokenizedData[2];

                if (checkPsw(pos1, pos2, letter, password))
                    validatedPsw ++;
            }
            System.out.println(validatedPsw); 
            
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error reading file");
            e.printStackTrace();
        }
    }
}