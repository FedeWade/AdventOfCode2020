package AOC;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class App {
    public static void main(String[] args) {
        try {
            File file = new File("input.txt");
            Scanner scanner = new Scanner(file);
            Vector<Integer> inputVec = new Vector<Integer>();

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                inputVec.add(Integer.parseInt(line));
            }
            Collections.sort(inputVec);

            Integer jolt1 = 0, jolt2 = 0, jolt3 = 0;
            Integer currJolt = 0;
            for (int i = 0; i < inputVec.size(); i++) {
                Integer joltDiff = inputVec.get(i) - currJolt;
                if (joltDiff.equals(1))
                    jolt1++;
                else if (joltDiff.equals(2))
                    jolt2++;
                else if (joltDiff.equals(3))
                    jolt3++;
                else {
                    System.out.println("Error: jolt difference error");
                    break;
                }
                currJolt = inputVec.get(i);
            }
            jolt3++; // last one always +3
            Integer result = jolt1 * jolt3;

            System.out.println(result);

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error in reaging the file.");
            e.printStackTrace();
        }
    }
}
