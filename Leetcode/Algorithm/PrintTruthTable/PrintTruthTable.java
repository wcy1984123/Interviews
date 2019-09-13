/**
 * The class for printing truth table.
 */
public class PrintTruthTable {
    /**
     * Minimum truth table size.
     */
    private static int MinTruthTableSize = 3;

    /**
     * Print truth table of size n.
     * 
     * @param n the size of truth table.
     */
    public static String printTruthTable(int n) {
        if (n <= 0)
            n = MinTruthTableSize;

        int rows = (int) Math.pow(2, n);
        int value = rows - 1;

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= rows; i++) {
            String line = "";
            int temp = value & (i - 1);
            for (int j = 0; j < n; j++) {
                if (((temp >>> j) & 1) == 0) {
                    line = "T" + line;
                } else {
                    line = "F" + line;
                }

                line = " " + line;
            }

            line = ("" + i + ": ") + line + "\n";
            sb.append(line);
        }

        return sb.length() == 0 ? "" : sb.toString();
    }

    /**
     * Main program
     * 
     * @param args
     */
    public static void main(String[] args) {
        String table = printTruthTable(4);
        System.out.println(table);
    }
}