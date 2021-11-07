package liuyang.jcf.heap;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class HelloPriorityQueue {

	// 小顶堆
	private static PriorityQueue<Integer> heapMin = new PriorityQueue<>();
	// 大顶堆
	private static PriorityQueue<Integer> heapMax = new PriorityQueue<Integer>(new Comparator<Integer>() {
		@Override
		public int compare(Integer o1, Integer o2) {
			return o2 - o1;
		}
	});
	// 大顶堆(更方便的创建方法)
	private static PriorityQueue<Integer> heapMax2 = new PriorityQueue<>(Collections.reverseOrder());
	// 测试数据
	private static int a[] = { 9, 8, 7, 6, 5, 11, 12, 13, 14, 88, 99 };

	public static void main(String[] args) {
		testHeap(heapMin);

		testHeap(heapMax);

		testHeap(heapMax2);

		// peek		// Retrives, but does not remove, the head of this queue, or returns null if this queue is empty.
		// poll		// Retrives and removes the head of this queue, or returns null if this queue is empty.
		// size		// Returns the number of elements in this collection.
		// isEmpty	// Methods declared in interface java.util.Collection
	}

	public static void testHeap(PriorityQueue<Integer> heap) {
		for (int i : a) {
			heap.add(i);
		}
		while (!heap.isEmpty()) {
			System.out.print(heap.poll() + "\t");
		}
		System.out.println("");
	}

	/*
	private <T> PriorityQueue<T> buildHeapMin(T t) {
		return null;
	}
	*/
}
