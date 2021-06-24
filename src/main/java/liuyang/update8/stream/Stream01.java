package liuyang.update8.stream;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 获取流
 * 
 * @author liuyang
 * @since 2021/6/24
 *
 */
@Slf4j
public class Stream01 {

	public static void main(String[] args) {
		List<Integer> lista = Arrays.asList(1, 2, 3, 1, 2, 3);
		List<Double> listDouble = null;

		// transform demo
		List<Double> listDoubleDest = lista.stream().map(i -> Integer.valueOf(i).doubleValue()).collect(Collectors.toList());
		listDoubleDest.forEach(System.out::println);

	}
}
