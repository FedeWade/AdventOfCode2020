package AOC;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

public class App {
    public static int endOfSequence(Vector<Long> inputVec, Integer start, Long sum, Integer indexSum) {
        Long currSum = 0L;
        for (int i = start; i < indexSum && currSum <= sum; i++) {
            currSum += inputVec.get(i);
            if (currSum.equals(sum)) {
                return i;
            }
        }
        return -1;
    }

    public static boolean checkIntegrity(Vector<Long> inputVec, Integer index) {
        Long sum = inputVec.get(index);
        for (int x = index - 25; x < index; x++) {
            for (int y = x + 1; y < index; y++) {

                Long first = inputVec.get(x);
                Long second = inputVec.get(y);
                if (!first.equals(second) && (first + second == sum))
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        try {
            File input = new File("input.txt");
            Scanner reader = new Scanner(input);
            Vector<Long> inputVec = new Vector<Long>();
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                inputVec.add(Long.parseLong(line));
            }

            int start = 0, end = 0;
            for (int i = 25; i < inputVec.size(); i++) {
                Long checkingValue = inputVec.get(i);
                if (!checkIntegrity(inputVec, i)) {
                    for (start = 0; start < i; start++) {
                        end = endOfSequence(inputVec, start, checkingValue, i);
                        if (end != -1)
                            break;
                    }
                    break;
                }
            }

            Long min = 99999999999L;
            for (int i = start; i <= end; i++) {
                if (inputVec.get(i) < min)
                    min = inputVec.get(i);
            }

            Long max = 0L;
            for (int i = start; i <= end; i++) {
                if (inputVec.get(i) > max)
                    max = inputVec.get(i);
            }

            System.out.println(max + min);

            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error reading file");
            e.printStackTrace();
        }
    }
}