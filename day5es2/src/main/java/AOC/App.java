package AOC;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;
import java.util.Collections;


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
            Vector<Integer> vecID = new Vector<Integer>();
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                Integer ID = calculateID(line);
                vecID.add(ID);
            }
            reader.close();

            Collections.sort(vecID); //sort vector
            Integer prec = 0;
            for (Integer value : vecID) {
                if(!prec.equals(0) && !prec.equals(value-1)) //check if there is a gap between prec and value
                    System.out.println(value-1);
                prec = value;
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error reading file");
            e.printStackTrace();
        }
    }
}