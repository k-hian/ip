package rotodo.exception;

public class InvalidInputException extends Exception {
    private static int count = 0;
    private static String[] error = new String[] {
        "RoTodo.Error: Invalid Input",
        "Ro7o0OoODdDDdDDDoO0.o.oo >< .. . 3RR0rrre3rrr4rrrrr"
        + "rrrrrrrrrrrr.rrr.r..r..r...r......r.r..........",
        "01010010011011110101010001101111011001000 oVeRH3471n9"
        + " 7o0 m4nY 3rR0r 10011110010111001000101011100100111" 
        + "00100110111101110010"};

    public static void noError() {
        count -= 1;
    }
    
    public InvalidInputException(String arg) {
        super("\u001B[31m" + (count < 3 ? error[0] : 
                (count < 8 ? error[1] : error[2]))
            + "\n  " + arg + "\u001B[0m\n"
            + "type 'help' to see guide");
        count += 1;
    }

    @Override
    public String toString() {
        return getLocalizedMessage();
    }
}
