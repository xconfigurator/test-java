package liuyang.io;

import java.util.Scanner;

/**
 * @author xconf
 * @since 2024/1/26
 */
public class ConsoleReadLineScanner {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String line = cin.nextLine();
        System.out.println(line);
    }
}
