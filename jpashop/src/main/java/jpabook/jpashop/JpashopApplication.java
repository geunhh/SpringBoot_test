package jpabook.jpashop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

import java.util.List;


@SpringBootApplication
public class JpashopApplication {


	public static void main(String[] args) {


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
