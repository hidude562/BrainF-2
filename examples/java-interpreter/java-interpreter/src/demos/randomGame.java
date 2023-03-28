package src.demos;

import src.com.Execution;

public class randomGame {
    public static void main(String[] args) {
        // Hello world program as the code for the execution (program from copy.sh)
        Execution program = new Execution("""
                [By Nathan Mills, 2023]


                Init random num zero to ten
                Note that this will be normally distrubuted at 5 because math

                %%%%%%%%%%

                !


                Init to 71
                +++++++[->++++++++++<]>+


                G.
                U++++++++++++++.
                E----------------.
                S++++++++++++++.
                S.
                
                
                #
                """);
        program.execute_program();
    }
}