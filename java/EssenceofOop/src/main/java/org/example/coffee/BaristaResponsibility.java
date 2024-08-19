package org.example.coffee;

import org.example.coffee.domain.CoffeeEntity;

public interface BaristaResponsibility {
		// 어떤 바리스타던 반드시 가져야할 책임
		CoffeeEntity madeCoffee();
}
