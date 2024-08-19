package org.example.coffee.domain;

import org.example.coffee.BaristaResponsibility;

public class hashChahierService implements ChahierService{

		BaristaResponsibility baristaResponsibility;

		//캐시미어는 바리스타에게 음료를 요구한다.
		@Override
		public CoffeeEntity sendCoffee(String name) {
				baristaResponsibility = new JamesBaristaService();
				return baristaResponsibility.madeCoffee();
		}

}
