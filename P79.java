package p79;

import java.io.*;
import java.util.*;

/**
 *
 * @author Shiv
 */
public class P79 {
    
    public static final String filename = "/Users/Icey/Desktop/Keylog/keylog.txt";

    public static void main(String[] args) throws Exception {
        //___________________________________________________________________________________________________________
        // read keylog.txt file containing 50 successful login attempts
        int total = 50;
        String[] keylog = new String[total];

        Scanner S = new Scanner(new BufferedReader(new FileReader("/Users/Icey/Desktop/Keylog/keylog.txt")));

        System.out.print("List of 50 Successful Login Attempts:\t ");
        while (S.hasNextLine()) {
            for (int i = 0; i <= total - 1; i++) {
                keylog[i] = S.nextLine();
                //System.out.println(i + ": " + keylog[i]);
            }
        }

        //___________________________________________________________________________________________________________
        // 1) convert array to array list
        // 2) remove numbers not present in password
        // 3) find numbers that are present in password
        List<Integer> keylog_2 = new ArrayList<>();

        // 1
        for (String s : keylog) {
            keylog_2.add(Integer.parseInt(s));
        }

        System.out.println(keylog_2);

        // 2 & 3
        List<Integer> numbers_present = new ArrayList<>();
        List<Integer> numbers_removed = new ArrayList<>();

        //___________________________________________________________________________________________________________
        // Seperate Numbers that are Present VS not Present in the Password
        for (Integer i : keylog_2) {
            for (int j = 0; j <= 10; j++) {
                int digit1 = i % 10;
                int digit2 = (i % 10) / 10;
                int digit3 = i / 100;

                if (digit1 == j || digit2 == j || digit3 == j) {
                    numbers_present.add(j);
                }
            }
        }

        // convert to hashset to remove duplicates
        HashSet present2 = new HashSet(numbers_present);
        System.out.println("The numbers that are present include:\t " + present2);

        // convert back to array list
        // determine numbers not present
        List<Integer> present3 = new ArrayList<Integer>(present2);
        for (Integer i : present3) {
            for (int j = 0; j < 10; j++) {
                if (!(present3.contains(j))) {
                    numbers_removed.add(j);
                }
            }
        }

        HashSet removed2 = new HashSet(numbers_removed);
        System.out.println("The numbers that aren't present include: " + removed2);
        List<Integer> removed3 = new ArrayList<Integer>(removed2);

        //___________________________________________________________________________________________________________
    }
    
    public static void PrintCode (Node n) {
        Node temp = n;
        Stack<Node> stack = new Stack<Node>();
        while(temp.hasParent()) {
            stack.push(temp);
            temp = temp.getParent();
        }
        stack.push(temp);

        System.out.print("Password:\t\t\t\t " + "[");
        while(!stack.isEmpty()) {
            System.out.print(stack.pop().getValue());
        }
        System.out.print("]");
    }
}
