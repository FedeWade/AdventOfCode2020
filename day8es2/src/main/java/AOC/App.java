package AOC;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

public class App {

    public static Vector<Instruction> cloneVec(Vector<Instruction> inputVec) {
        Vector<Instruction> clone = new Vector<Instruction>(inputVec.size());
        for (Instruction item : inputVec) clone.add(item.clone());
        return clone;
    }

    public static Integer findFix(Vector<Instruction> copyVec, Integer instToChange ) {
        boolean loopStarted = false;
        Integer i=0, accumulator=0;
        Integer nop_jump_index= 0;

        while(!loopStarted) {
            if(i.equals(copyVec.size())) return accumulator;

            Instruction instruction = copyVec.get(i);
            if(instruction.steppedIn) loopStarted = true;

            if(instruction.type.equals("nop") || instruction.type.equals("jmp")) {
                if(instToChange.equals(nop_jump_index)) {
                    if(instruction.type.equals("nop")) instruction.type = "jmp";
                    else if(instruction.type.equals("jmp")) instruction.type = "nop";
                }
            }
        
            switch (instruction.type) {
                case "nop":
                    i++;
                    nop_jump_index ++;
                    break;

                case "acc":
                    accumulator += instruction.value;
                    i++;
                    break; 
                
                case "jmp":
                    i += instruction.value;
                    nop_jump_index ++;
                    break;
        
                default:
                    break;
            }
            instruction.steppedIn = true;
        }
        return -1;
    }

    public static void main(String[] args) {
        try {
            File input = new File("input.txt");
            Scanner reader = new Scanner(input);
            Vector<Instruction> inputVec = new Vector<Instruction>();

            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                inputVec.add(new Instruction(line));
            }

            boolean fixFound = false;
            for (int i=0; i<inputVec.size() && !fixFound; i++) {
                Vector<Instruction> copyVec = cloneVec(inputVec);
                Integer result = findFix(copyVec, i);
   
                if(result.equals(-1)) {
                    for (Instruction instruction : inputVec) {
                        instruction.steppedIn = false;
                    }
                }
                else {
                    fixFound = true;
                    System.out.println("fix found, accumulator: " + result);
                }
            }
            if(!fixFound) System.out.println("nessun fix è stato trovato");

            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error reading file");
            e.printStackTrace();
        }
    }
}