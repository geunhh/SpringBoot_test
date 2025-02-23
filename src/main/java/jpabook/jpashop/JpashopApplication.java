package jpabook.jpashop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@SpringBootApplication
public class JpashopApplication {

	public static int add (int a ,int b) {
		return a+ b;
	}

	public static void main(String[] args) {

//		Hello hello = new Hello();
//		hello.setData("hello");
//		String data = hello.getData();
//		System.out.println("dataa = " + data);
//		int numb = 10;
//		String message = "Hello, Java";
//		System.out.println(numb + message);
//		System.out.println(add(3,5));

//		for (int i =0; i<5; i++) {
//			System.out.println(i);
//			if (i % 2 ==1) {
//				System.out.println("홀수 :"+ i);
//			} else {
//				System.out.println("짝수");
//			}
//		}

//		List<Integer> rangeList = IntStream.range(0, 5)
//				.boxed()  // int → Integer 변환
//				.collect(Collectors.toList());
//		System.out.println(rangeList);
//		ㄱㄱ

		// 배열 선언 및 초기화
//		int[] numbers = new int[5];
//		numbers[0]=5;
//		numbers[1]=7;
//		System.out.println(numbers[0]);
//		System.out.println(Arrays.toString(numbers));

		List<Integer> numbers = new ArrayList<>(); // 크기 제한 없음

		numbers.add(10);
		numbers.add(7);
		System.out.println(numbers);
		//
		Person p = new Person("geunhh");
				p.greet();

		SpringApplication.run(JpashopApplication.class, args);
	}

}
