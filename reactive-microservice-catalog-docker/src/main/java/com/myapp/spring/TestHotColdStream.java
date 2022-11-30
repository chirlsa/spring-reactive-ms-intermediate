package com.myapp.spring;

import reactor.core.publisher.Flux;

public class TestHotColdStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Flux<Integer> fluxInt = Flux.just(1,10,100).log().cache();
		
		fluxInt.reduce(Integer::sum)
		.subscribe(sum -> System.out.printf("Sum is: %d\n", sum));
		
		fluxInt.reduce(Integer::max)
		.subscribe(sum -> System.out.printf("Maximum is: %d\n", sum));
		
		

	}

}
