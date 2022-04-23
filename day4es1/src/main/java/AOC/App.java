package AOC;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {
    public static boolean checkPassport(String passport) {
        if (passport.contains("byr") && passport.contains("iyr") && passport.contains("eyr") && passport.contains("hgt")
                && passport.contains("hcl") && passport.contains("ecl") && passport.contains("pid")) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        try {
            File input = new File("input.txt");
            Scanner reader = new Scanner(input);
            Integer validPassports = 0;

            while (reader.hasNextLine()) {
                String passport = "";
                boolean lineIsEmpty = false;

                while (!lineIsEmpty) {
                    String row = "";
                    if (reader.hasNextLine())
                        row = reader.nextLine();
                    if (row.isEmpty())
                        lineIsEmpty = true;
                    else
                        passport = passport + " " + row;
                }
                if (checkPassport(passport))
                    validPassports++;
            }
            System.out.println(validPassports);
            reader.close();
            
        } catch (FileNotFoundException e) {
            System.out.println("Error reading file");
            e.printStackTrace();
        }
    }
}