package org.example.coffee.domain;

public class SimpleCustomerService implements CustomerService{


		private ChahierService chahierService;

		// 손님이 주문하여 캐시미어에게 보낸다.
		@Override
		public CoffeeEntity orders(String name) {
				chahierService = new hashChahierService();
				return chahierService.sendCoffee("coffee");
		}
}
