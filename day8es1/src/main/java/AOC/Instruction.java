package AOC;

public class Instruction {
    Instruction(String line) {
        String[] splittedLine = line.split(" ");
        type = splittedLine[0];
        value = Integer.parseInt(splittedLine[1]);
        steppedIn = false;
    }
    
    public String type;
    public Integer value;
    public boolean steppedIn;

}
