package AOC;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class App 
{
    static boolean checkPsw(int min, int max, char letter, String password) {
        int occurrencies = 0;
        for (int i = 0; i < password.length(); i++) {
            if (password.charAt(i) == letter)
                occurrencies++;
        }
        if (occurrencies >= min && occurrencies <= max)
            return true;
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
                int min = Integer.parseInt(bounds[0]);
                int max = Integer.parseInt(bounds[1]);
                char letter = (tokenizedData[1]).charAt(0);
                String password = tokenizedData[2];

                if (checkPsw(min, max, letter, password))
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