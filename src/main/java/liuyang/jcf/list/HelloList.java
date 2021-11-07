package liuyang.jcf.list;

import java.awt.event.WindowFocusListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author liuyang
 * @date 2021/10/28
 */
public class HelloList {

    private static List<Integer> list = new ArrayList<>();
    // LinkedList, Stack, Vector

    public static void main(String[] args) {
        // 增 add O(1)
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        info(list);
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        // 增 add O(N)
        list.add(4, 99);
        info(list);

        // 删 remove O(N)
        list.remove(3);
        info(list);

        // 改 set O(1)
        list.set(0, 4);
        info(list);
        System.out.println(list.get(0));

        // 查 indexOf O(n)
        int i = list.indexOf(2);
        info(list);
        System.out.println("idx of 2 = " + i);

        // 排序
        Collections.sort(list, Collections.reverseOrder());
        info(list);
    }

    private static void info(List list) {
        System.out.println("####");
        System.out.println("#list size = " + list.size());
        list.stream().forEach(System.out::println);
        System.out.println("####");
    }
}
