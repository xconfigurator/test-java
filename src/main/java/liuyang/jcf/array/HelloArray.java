package liuyang.jcf.array;

import java.util.Arrays;
import java.util.Collections;

/**
 * 参考：
 * https://www.bilibili.com/read/cv8568185
 * @author liuyang
 * @date 2021/10/28
 */
public class HelloArray {
    public static void main(String[] args) {
        // Four solutions to create anarray in Java
        // Take [1,2,3] as example
        // Solution 1
        int[] a = {1, 2, 3};
        printArr(a);

        // Solution 2
        int[] b = new int[]{1, 2, 3};
        printArr(b);

        // Solution 3
        int[] c= new int[3];
        for (int i = 0; i < c.length; ++i) {
            c[i] = i + 1;
        }
        printArr(c);

        // 排序
        // 倒序拍一个原生类型数组(new 出一个包装类型的数组 然后再排序)
        System.out.println("倒叙处理一个非对象类型数组（Arrays.sort(T t[], Comparator)只能接收包装类型）");
        Integer[] bIntegers = Arrays.stream(b).boxed().toArray(Integer[]::new);
        Arrays.sort(bIntegers, Collections.reverseOrder());
        Arrays.stream(bIntegers).forEach(System.out::println);
    }

    private static void printArr(int[] arr) {
        System.out.println("length = " + arr.length);
        Arrays.stream(arr).forEach(System.out::println);
    }
}
