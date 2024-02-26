package org.example.coffee.domain;

import org.example.coffee.BaristaResponsibility;

public class JamesBaristaService implements BaristaResponsibility {


		// 커피를 만들어 반환한다.
		// 만들어지면 -> 캐시미어로 가고 -> 손님에게 돌아간다.
		@Override
		public CoffeeEntity madeCoffee() {
				CoffeeEntity coffee = new CoffeeEntity();
				return coffee;
		}
}
