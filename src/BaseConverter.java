import java.io.PrintWriter;
import java.util.Scanner;
import java.io.File;

/**
 * Javadoc me
 */
public class BaseConverter {
    private final String DIGITS = "0123456789ABCDEF";

    /**
     * Convert a String num in fromBase to base-10 int.
     * @param num      the original number
     * @param fromBase the original from base
     * @return a base-10 int of num base fromBase
     */
    public int strToInt(String num, String fromBase) {
        // "FF" "16"
        int value = 0, exp = 0;
        //String s = "" + 'c';
        for (int i = num.length() - 1; i >= 0; i--) {
            value += DIGITS.indexOf(num.charAt(i)) * Math.pow(Integer.parseInt(fromBase), exp);
            exp++;
        }

        return value;
    }
     /*
        start at the right-most digit of num
        run a loop for i digits of num -- backwards
            pull out the character at index i
            find the indexOf that charactoer in DIGITS
            value += indexOf character * Math.pow(fromBase, exp);
            exp++ or exp += 1

         */




    /**
     * Javadoc me
     * @param num
     * @param toBase
     * @return
     */
    public String intToStr(int num, int toBase) {
        String toNum = new String();
        //int index = -1;
        while (num > 0) {
            toNum = DIGITS.charAt(num % toBase) + toNum;
            num /= toBase;

        }
        return (toNum.equals("")) ? "0" : toNum;
    }
    /**
     * Javadoc me
     */
    public void inputConvertPrintWrite() {
        Scanner in = null;
        PrintWriter out = null;

        try {
            in = new Scanner(new File("datafiles/values20.dat"));
            out = new PrintWriter(new File("datafiles/converted.dat"));
            String[] line;
            String output;
            while(in.hasNext()) {
                line = in.nextLine().split("\t");
                //to write to the file
                // write to original number
                //tab
                //write the converted number
                //tab
                // write the toBase
                //wrtie the toBase - STRING
                if(Integer.parseInt(line[1]) < 2 || Integer.parseInt(line[1]) > 16)
                    System.out.println("invalid input base" + line[1]);
                else if(Integer.parseInt(line[2]) < 2 || Integer.parseInt(line[2]) > 16)
                    System.out.println("invalid input base " + line[1]);
                else {
                    output = intToStr(strToInt(line[0], line[1]), Integer.parseInt(line[2]));
                    out.println(line[0] + "\t" + line[1] + "\t" + output + "\t" + line[2]);
                    System.out.println(line[0] + " base " + line[1] + " = " + output + " base " + line[2]);
               /*System.out.println();
                System.out.println(line[0]);
                System.out.println(line[1]);
                System.out.println(line [2]);
                */

                }
            }
            if (out != null) ;
                out.close();
            if (out != null);
                in.close();
            //System.out.print("The revolution will not be televised ");
        }
        catch (Exception e) {
                System.out.println("Something had happened. Detail here:" + e.toString());
                }
        }
            /**
     * Javadoc me
     * @param args
     */
    public static void main(String[] args){
            BaseConverter bc = new BaseConverter();
            bc.inputConvertPrintWrite();
        }
}


