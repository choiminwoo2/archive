package org.example.coffee.domain;

import java.time.LocalDateTime;

public class BaristaEntity {
		private Long id;
		private String name;
		private LocalDateTime shift;
		private String experience;
		private String rating;

		public Long getId() {
				return id;
		}

		public String getName() {
				return name;
		}

		public LocalDateTime getShift() {
				return shift;
		}

		public String getExperience() {
				return experience;
		}

		public String getRating() {
				return rating;
		}

		public void setId(Long id) {
				this.id = id;
		}

		public void setName(String name) {
				this.name = name;
		}

		public void setShift(LocalDateTime shift) {
				this.shift = shift;
		}

		public void setExperience(String experience) {
				this.experience = experience;
		}

		public void setRating(String rating) {
				this.rating = rating;
		}
}
