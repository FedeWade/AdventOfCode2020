package AOC;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

public class App {

    public static void main(String[] args) {
        try {
            File input = new File("input.txt");
            Scanner reader = new Scanner(input);
            Vector<Instruction> inputVec = new Vector<Instruction>();
            Integer accumulator = 0;

            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                inputVec.add(new Instruction(line));
            }

            boolean loopStarted = false;
            Integer i=0;
            
            while(!loopStarted) {
                Instruction instruction = inputVec.get(i);
                if(instruction.steppedIn) {
                    loopStarted = true;
                    System.out.println("loop found, accumulator: " + accumulator);
                }                
                switch (instruction.type) {
                    case "nop":
                        i++;
                        break;

                    case "acc":
                        accumulator += instruction.value;
                        i++;
                        break; 
                        
                    case "jmp":
                        i += instruction.value;
                        break;
                
                    default:
                        break;
                }
                instruction.steppedIn = true;
            }

            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error reading file");
            e.printStackTrace();
        }
    }
}