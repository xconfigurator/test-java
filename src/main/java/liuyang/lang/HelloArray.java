package liuyang.lang;

public class HelloArray {
    public static void main(String[] args) {
        // demo01
        int[][] tdarr01 = new int[2][2];

        // Java支持但，但C++不支持的写法
        int tdarr02[][] = {{2, 2}, {2, 2}};// C++不能这样写！
        int[][] tdarr03 = {{2, 2}, {2, 2}};// C++不能这样写！
        printArr(tdarr02);

        //int tdarr04[2][2] = {{2, 2}, {2, 2}};// Java不能这样搞！
    }

    public static void printArr(int[][] arr) {
        for (int[] a : arr) {
            for (int e : a) {
                System.out.print(e);
                System.out.print("\t");
            }
            System.out.println();
        }
    }
}
