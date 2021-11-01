package liuyang.jcf.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuyang
 * @date 2021/10/28
 */
public class HelloArrayList {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        System.out.println(list.get(0));
        System.out.println(list.get(1));
    }
}
