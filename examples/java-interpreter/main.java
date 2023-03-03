import java.util.*;

class Execution {

    // Some classes for storing memory and registers

    public static class Memory {
        int ram_words;
        short ram_word_width;
        int pc;
        int pointer;
        short pointer_mem_contents;
        short[] ram;
        Stack<Integer> loop_stack;

        public Memory(int ram_words, short ram_word_width) {
            this.ram_words = ram_words;
            this.ram_word_width = ram_word_width;
            this.pc = 0;
            this.pointer_mem_contents = 0;
            this.pointer = 0;
            this.loop_stack = new Stack<>();

            this.ram = new short[ram_words];
        }
    }

    // Define some variables
    Memory memory;
    byte[] code;
    int code_length;

    // Define methods


    // TODO: Make this 4 bit int (or even 3 bits)
    byte convert_char_to_id(char character) {
        return switch (character) {
            case '[' -> (byte) 0;
            case ']' -> (byte) 1;
            case '+' -> (byte) 2;
            case '-' -> (byte) 3;
            case '<' -> (byte) 4;
            case '>' -> (byte) 5;
            case '.' -> (byte) 6;
            case ',' -> (byte) 7;
            default -> (byte) 8;
        };
    }

    void get_pointer_mem_contents() {
        memory.pointer_mem_contents = memory.ram[memory.pointer];
    }
    
    int simulateBitWidth(int number) {
      int fit_num = number % (memory.ram_word_width);
      if (fit_num < 0) {
         fit_num = fit_num + memory.ram_word_width;
      }
      return fit_num;
    }

    void execute_instruction(byte character, boolean simulate) {
        get_pointer_mem_contents();
        switch(character) {
            case 0 -> {int start_of_loop = memory.pc; memory.loop_stack.push(start_of_loop); if(memory.pointer_mem_contents == (byte) 0) {memory.pc++; while(memory.loop_stack.search(start_of_loop) != -1) {execute_instruction(this.code[memory.pc], false);} memory.pc--;}}
            case 1 -> {int start_of_loop = memory.loop_stack.pop(); if(memory.pointer_mem_contents != (byte) 0) {memory.pc = start_of_loop; memory.loop_stack.push(start_of_loop);}}
            case 2 -> {if(simulate)memory.ram[memory.pointer]++; memory.ram[memory.pointer] = (short)simulateBitWidth(memory.ram[memory.pointer]);}
            case 3 -> {if(simulate)memory.ram[memory.pointer]--; memory.ram[memory.pointer] = (short)simulateBitWidth(memory.ram[memory.pointer]);}
            case 4 -> {if(simulate)memory.pointer--;}
            case 5 -> {if(simulate)memory.pointer++;}
            case 6 -> {if(simulate)System.out.print((char) memory.pointer_mem_contents);} // (char) memory.pointer_mem_contents
            case 7 -> {if(simulate) {Scanner input = new Scanner(System.in); System.out.print("?:"); memory.ram[memory.pointer] = (byte) input.next().charAt(0);}}

        }
        memory.pc++;
    }

    void execute_program() {
        while(memory.pc < code_length) {
            execute_instruction(this.code[memory.pc], true);
        }
    }

    public Execution(String code) {
        // Parse the BrainF code to an array of ints
        this.code_length = 0;
        this.code = new byte[code.length()];
        int parsed_code_index = 0;
        for(int i = 0; i < code.length(); i++) {
            if (convert_char_to_id(code.charAt(i)) != 8) {
                this.code_length++;
                this.code[parsed_code_index] = convert_char_to_id(code.charAt(i));
                parsed_code_index++;
            }
        }
        // TODO: Implement the ram_word_width variable
        memory = new Memory(4096, (short)256);
    }
}
