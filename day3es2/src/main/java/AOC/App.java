package AOC;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class App 
{
    public static int checkLenght(int index, int lenght) {
        if(index >= lenght) index = index % lenght;
        return index;
    }

    public static void main(String[] args) {
        try {
            File input = new File("input.txt");
            Scanner reader = new Scanner(input);
            long treesFound1 = 0, treesFound2 = 0, treesFound3 = 0, treesFound4 = 0, treesFound5 = 0; 
            Integer index1 = 0, index2 = 0, index3 = 0, index4 = 0, index5 = 0;
            Integer rowIndex = 0; 

            while (reader.hasNextLine()) {
                String row = reader.nextLine();
                if(row.charAt(index1) == '#') treesFound1 ++;
                if(row.charAt(index2) == '#') treesFound2 ++;
                if(row.charAt(index3) == '#') treesFound3 ++;
                if(row.charAt(index4) == '#') treesFound4 ++;
                if(row.charAt(index5) == '#' && rowIndex % 2 == 0) treesFound5 ++;
                    
                index1 ++;
                index1 = checkLenght(index1, row.length());
                index2 +=3;
                index2 = checkLenght(index2, row.length()); 
                index3 +=5;
                index3 = checkLenght(index3, row.length());
                index4 +=7;
                index4 = checkLenght(index4, row.length()); 
                if(rowIndex % 2 == 0) {
                    index5 ++;
                    index5 = checkLenght(index5, row.length()); 
                }

                rowIndex ++;
            }
            System.out.println(treesFound1 + " " + treesFound2 + " " + treesFound3 + " " + treesFound4 + " " + treesFound5);
            long result = treesFound1 * treesFound2 * treesFound3 * treesFound4 * treesFound5;
            System.out.println(result);
            
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error reading file");
            e.printStackTrace();
        }
    }
}