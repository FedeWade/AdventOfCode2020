package AOC;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.*;

public class App {
    public static boolean byr_check(String value) {
        try {
            int intValue = Integer.parseInt(value);
            if (intValue >= 1920 && intValue <= 2002)
                return true;
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean iyr_check(String value) {
        try {
            int intValue = Integer.parseInt(value);
            if (intValue >= 2010 && intValue <= 2020)
                return true;
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean eyr_check(String value) {
        try {
            int intValue = Integer.parseInt(value);
            if (intValue >= 2020 && intValue <= 2030)
                return true;
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean hgt_check(String value) {
        String[] part = value.split("(?<=\\d)(?=\\D)");

        try {
            int intValue = Integer.parseInt(part[0]);
            if (part[1].equals("cm") && intValue >= 150 && intValue <= 193)
                return true;
            if (part[1].equals("in") && intValue >= 59 && intValue <= 76)
                return true;
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean hcl_check(String value) {
        Pattern p = Pattern.compile("^#[a-f0-9]{6}$");
        Matcher m = p.matcher(value);
        return m.matches();
    }

    public static boolean ecl_check(String value) {
        if (value.equals("amb") || value.equals("blu") || value.equals("brn") || value.equals("gry")
                || value.equals("grn") || value.equals("hzl") || value.equals("oth"))
            return true;
        return false;
    }

    public static boolean pid_check(String value) {
        Pattern p = Pattern.compile("^[0-9]{9}$");
        Matcher m = p.matcher(value);
        return m.matches();
    }

    public static boolean checkPassport(String passport) {

        if (passport.contains("byr:") && passport.contains("iyr:") && passport.contains("eyr:")
                && passport.contains("hgt:") && passport.contains("hcl:") && passport.contains("ecl:")
                && passport.contains("pid:")) {

            String[] fieldsArray = passport.split(" "); //splitting every field in the passport 
            for (String field : fieldsArray) {
                String[] fieldValues = field.split(":"); //splitting key:value for every field [0]=key [1]=value
                switch (fieldValues[0]) {
                    case "byr":
                        if (!byr_check(fieldValues[1]))
                            return false;
                        break;

                    case "iyr":
                        if (!iyr_check(fieldValues[1]))
                            return false;
                        break;

                    case "eyr":
                        if (!eyr_check(fieldValues[1]))
                            return false;
                        break;

                    case "hgt":
                        if (!hgt_check(fieldValues[1]))
                            return false;
                        break;

                    case "hcl":
                        if (!hcl_check(fieldValues[1]))
                            return false;
                        break;

                    case "ecl":
                        if (!ecl_check(fieldValues[1]))
                            return false;
                        break;

                    case "pid":
                        if (!pid_check(fieldValues[1]))
                            return false;
                        break;

                    default:
                        break;
                }
            }
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