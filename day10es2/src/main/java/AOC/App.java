package AOC;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class App {
    public static BigInteger possibleCombination(Vector<Integer> inputVec, Integer i) {
        // caso base
        if (i >= inputVec.size() || i.equals(inputVec.size() - 1) || i.equals(inputVec.size() - 2))
            return new BigInteger("1");
        // caso ricorsivo
        Integer diff1 = inputVec.get(i + 1) - inputVec.get(i);
        Integer diff2 = inputVec.get(i + 2) - inputVec.get(i);

        if (diff1.equals(3)) // caso con unica combinazione
            return possibleCombination(inputVec, i + 1);

        if (diff2.equals(3) || i.equals(inputVec.size() - 3)) // caso posso prendere sia i+1 che i+2
            return possibleCombination(inputVec, i + 1).multiply(new BigInteger("2"));

        BigInteger a = possibleCombination(inputVec, i + 1);
        BigInteger result = a.multiply(new BigInteger("3"));
        // System.out.println(result);

        return result;
    }

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

            BigInteger currCombi = possibleCombination(inputVec, 0);

            System.out.println(currCombi);

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error in reaging the file.");
            e.printStackTrace();
        }
    }
}
