package AOC;

import java.util.Vector;

public class Bag {

    Bag(String line) {
        String[] halfLine = line.split(" bags contain ");
        name = halfLine[0].replaceAll(" ","");

        bagsInside = new Vector<String>();
        bagsAmount = new Vector<Integer>();

        if(!halfLine[1].equals("no other bags.")) {
            String onlyDigits = halfLine[1].replaceAll("[^0-9,]", "");

            halfLine[1] = halfLine[1].replaceAll("\\d","");
            halfLine[1] = halfLine[1].replaceAll(" ","");
            halfLine[1] = halfLine[1].replaceAll("\\.","");
            halfLine[1] = halfLine[1].replaceAll("bags","");
            halfLine[1] = halfLine[1].replaceAll("bag","");

            String[] containedBags = halfLine[1].split(",");
            for (String containedBagName : containedBags) {
                bagsInside.add(containedBagName);
            }

            String[] bagsNumbers = onlyDigits.split(",");
            for (String bagQuantity : bagsNumbers) {
                bagsAmount.add(Integer.parseInt(bagQuantity));
            }
        }
    }
    
    private String name;
    private Vector<String> bagsInside;
    private Vector<Integer> bagsAmount;

    public String getName() {
        return name;
    }

    public boolean hasInside(String bagToFind) {
        for (String name : bagsInside)
            if(name.equals(bagToFind)) return true;
        return false;
    }

    public Vector<String> getContainedBagsVector() {
        return bagsInside;
    }

    public Vector<Integer> getBagsAmountVector() {
        return bagsAmount;
    }
    
}
