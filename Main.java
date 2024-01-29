import java.util.Arrays;
import java.util.Scanner;
class State{
    public final int A = 1;
    public final int B = 10;
    public final int C = 11;
    public final int HALT = 100;
public State(int zero, int one){
    write_symbol_if_zero = zero;
    write_symbol_if_one = one;
}
    public int write_symbol_if_zero;
    public int write_symbol_if_one;
}
public class Main {

    public static void main(String[] args) {
        Scanner user_input = new Scanner(System.in);
        boolean halted = false;
        State state = new State(1,1);
        State state_a = new State(1,1);
        State state_b = new State(1,1);
        State state_c = new State(1,1);
        int current_state = state.A;

        // welcome text
        System.out.println("3-state, 2-symbol busy beaver");
        // user input - length of tape
        System.out.println("Enter length of tape:");
        String tape_length_tmp = user_input.nextLine();
        // conversion from string to int
        int tape_length = Integer.valueOf(tape_length_tmp);
        //creation of an array
        int[] tape = new int[tape_length];
        // initialize tape
        Arrays.fill(tape, 0);
        int i = tape.length / 2;
        while(!halted){
            // display of an array
            display_array(tape);
            switch(current_state){
                case 1:
                    if(tape[i] == 0){
                        tape[i] = state_a.write_symbol_if_zero;
                        i++;
                        current_state = state.B;
                        break;
                    }
                    if(tape[i] == 1){
                        tape[i] = state_a.write_symbol_if_one;
                        i--;
                        current_state = state.C;
                    }
                    break;
                case 10:
                    if(tape[i] == 0){
                        tape[i] = state_b.write_symbol_if_zero;
                        i--;
                        current_state = state.A;
                        break;
                    }
                    if(tape[i] == 1){
                        tape[i] = state_b.write_symbol_if_one;
                        i++;
                        current_state = state.B;
                    }
                    break;
                case 11:
                    if(tape[i] == 0){
                        tape[i] = state_c.write_symbol_if_zero;
                        i--;
                        current_state = state.B;
                        break;
                    }
                    if(tape[i] == 1){
                        tape[i] = state_c.write_symbol_if_one;
                        i++;
                        current_state = state.HALT;
                    }
                    break;

                case 100:
                    halted = true;
                    break;
            }

        }
    }
    public static void display_array(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println(" ");
    }
}
