package liuyang.io;

import java.util.Scanner;

/**
 * @author liuyang
 * @since 2021/12/1
 */
public class TestConsoleScannerStrings {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String s1 = cin.next();
        String s2 = cin.next();
        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);

        /*
        联想C++的输入：
        读字符：scanf, cin
        读一行：gets，cin.getline(), getline(cin, [string类]);
         */
    }
}
