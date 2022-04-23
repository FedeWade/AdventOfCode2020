package AOC;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {

    public static Integer calculateID(String line) {
        Integer lBound = 0, hBound = 127;

        for(int i=0; i<7; i++) {
            char letter = line.charAt(i);
            if(letter == 'F') {
                hBound = hBound - (hBound+1 - lBound)/2;
            }
            else if(letter == 'B') {
                lBound = lBound + (hBound+1 - lBound)/2;
            }
        }
        Integer row = lBound; // or hBound - same value after iteration
        Integer rightBound =7, leftBound =0;

        for(int i=7; i<10; i++) {
            char letter = line.charAt(i);
            if(letter == 'L') {
                rightBound = rightBound - (rightBound+1 - leftBound)/2;
            }
            else if(letter == 'R') {
                leftBound = leftBound + (rightBound+1 - leftBound)/2;
            }
        }

        Integer column = leftBound; //or rightBound - same value after iteraton
        return 8*row+column;
    }


    public static void main(String[] args) {
        try {
            File input = new File("input.txt");
            Scanner reader = new Scanner(input);
            Integer maxID = 0;
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                Integer ID = calculateID(line);

                if(ID > maxID) 
                    maxID = ID;
            }
            System.out.println(maxID);
            reader.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error reading file");
            e.printStackTrace();
        }
    }
}