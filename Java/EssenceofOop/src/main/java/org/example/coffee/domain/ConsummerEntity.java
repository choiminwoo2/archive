package org.example.coffee.domain;

public class ConsummerEntity {
		private final int id;
		private final String name;
		private final String contactInformation;
		private final String order;

		private ConsummerEntity(Builder builder) {
				this.id = builder.id;
				this.name = builder.name;
				this.contactInformation = builder.contactInformation;
				this.order = builder.order;
		}

		public int getId() {
				return id;
		}

		public String getName() {
				return name;
		}

		public String getContactInformation() {
				return contactInformation;
		}

		public String getOrder() {
				return order;
		}

		public static class Builder {
				private final int id;
				private String name;
				private String contactInformation;
				private String order;

				public Builder(int id) {
						this.id = id;
				}

				public Builder name(String name) {
						this.name = name;
						return this;
				}

				public Builder contactInformation(String contactInformation) {
						this.contactInformation = contactInformation;
						return this;
				}

				public Builder order(String order) {
						this.order = order;
						return this;
				}

				public ConsummerEntity build() {
						return new ConsummerEntity(this);
				}
		}
}
