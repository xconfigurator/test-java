package liuyang.algorithms202311;

/**
 * 各种排序算法的工具类
 * 把之前的测试代码汇总一下
 *
 * @author xconf
 * @since 2023/11/15
 */
public class Sorts {

    // 选择类

    public static void selectionSort(int[] array) {
        // 配合循环写多趟
        //for (int i = 0; i < array.length; ++i) {
        for (int i = 0; i < array.length - 1; ++i) {// 优化一下
            // 找最小的
            int minPos = i;
            for (int j = i + 1; j < array.length; ++j) {
                if (array[j] < array[minPos]) {
                    minPos = j;
                }
            }
            // System.out.printf("minPos = %d\n", minPos);

            // 交换
            int tmp = array[i];
            array[i] = array[minPos];
            array[minPos] = tmp;
        }
    }

    public static void heapSort(int[] array) {
        //
    }

    // 插入类

    public static void insertionSort(int[] array) {
        for (int j = 1; j < array.length; j++) {// 没必要从第0个开始
            int tmp = array[j]; // 取出未排序序列中的第一个元素 “摸下一张牌”
            int i = j;
            // 从当前的最后一张牌的位置开始，不断地与前面的已排序列重元素作比较
            // array[i - 1] > tmp: 只要我手里这张牌tmp比现在有序序列中最后一张牌array[i - 1]小，就把当前已排序列最后一张牌向后移动一位。
            for (; i >= 1 && array[i - 1] > tmp; i--) {// 写成i >= 1 更容易看出插入排序和Shell排序的联系
                array[i] = array[i - 1];// 移出空位
            }
            array[i] = tmp;// 新牌落位
        }
    }

    public static void shellSort(int[] array) {
        // TODO
    }

    // 交换类
    public static void bubbleSort(int[] array) {
        for (int j = array.length - 1; j >= 0; j--) {
            boolean hasSwaped = false; // 标记该次循环中是否发生了交换，若无，则说明整个序列有序。
            for (int i = 0; i < j; i++) { // 一趟冒泡
                // 每次循环找出一个最大元素，被交换到最右端。
                if (array[i] > array[i + 1]) {
                    int tmp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = tmp;
                    hasSwaped = true;// 发生了交换
                }
            }
            if (!hasSwaped) {
                break;// 若全程无交换，则跳出循环。
            }
        }
    }

    public static void quickSort(int[] array) {
        // TODO
    }

    public static void mergeSort(int[] array) {
        // TODO
    }
}
