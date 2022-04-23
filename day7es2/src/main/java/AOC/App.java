package AOC;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

public class App {

    public static Integer totalBagsInside(Bag bag, Vector<Bag> inputVec) {
        Vector<String> bagsInside = (bag.getContainedBagsVector());
        Vector<Integer> bagsAmount = (bag.getBagsAmountVector());
        if(bagsInside.isEmpty()) return 0;

        Integer total =0;
        for (int i=0; i<bagsInside.size(); i++) { //scorro le borse contenute in bag
            for (Bag otherBag : inputVec) { //scorro le borse nel vec di input
                if(otherBag.getName().equals(bagsInside.get(i)))
                    total = total + bagsAmount.get(i) +(totalBagsInside(otherBag, inputVec) * bagsAmount.get(i));
            }
        }
        return total;
    }

    public static void main(String[] args) {
        try {
            File input = new File("input.txt");
            Scanner reader = new Scanner(input);
            Vector<Bag> inputVec = new Vector<Bag>();

            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                inputVec.add(new Bag(line));
            }
            for (Bag bag : inputVec) {
                if(bag.getName().equals("shinygold")) {
                    System.out.println(totalBagsInside(bag, inputVec));
                } 
            }
            
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error reading file");
            e.printStackTrace();
        }
    }
}