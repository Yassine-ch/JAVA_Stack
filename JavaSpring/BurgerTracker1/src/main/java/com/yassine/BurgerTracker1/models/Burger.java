package com.yassine.BurgerTracker1.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="burgers")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class Burger {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//Member_varibals
	 Long id;
	@NotBlank(message="Burger name must not be blank")
	private String name;
	@NotBlank(message="Restaurant name must not be blank")
	private String restaurantName;
	@NotNull(message="Rating is required")
	@Min(value=1, message="Rating must be greater than 0")
	@Max(value=5, message="Rating cannot be larger than 5")
	private String rating;
	@NotBlank(message="Notes cannot be blank")
	private String notes;
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
	 @DateTimeFormat(pattern="yyyy-MM-dd")
	    private Date updatedAt;
		@PrePersist
	    protected void onCreate(){
	        this.createdAt = new Date();
	    }
	    @PreUpdate
	    protected void onUpdate(){
	        this.updatedAt = new Date();
	    }
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getRestaurantName() {
			return restaurantName;
		}
		public void setRestaurantName(String restaurantName) {
			this.restaurantName = restaurantName;
		}
		public String getRating() {
			return rating;
		}
		public void setRating(String rating) {
			this.rating = rating;
		}
		public String getNotes() {
			return notes;
		}
		public void setNotes(String notes) {
			this.notes = notes;
		}
		public Date getCreatedAt() {
			return createdAt;
		}
		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}
		public Date getUpdatedAt() {
			return updatedAt;
		}
		public void setUpdatedAt(Date updatedAt) {
			this.updatedAt = updatedAt;
		}
		public Burger(Long id, @NotBlank(message = "Burger name must not be blank") String name,
				@NotBlank(message = "Restaurant name must not be blank") String restaurantName,
				@NotNull(message = "Rating is required") @Min(value = 1, message = "Rating must be greater than 0") @Max(value = 5, message = "Rating cannot be larger than 5") String rating,
				@NotBlank(message = "Notes cannot be blank") String notes, Date createdAt, Date updatedAt) {
			super();
			this.id = id;
			this.name = name;
			this.restaurantName = restaurantName;
			this.rating = rating;
			this.notes = notes;
			this.createdAt = createdAt;
			this.updatedAt = updatedAt;
		}
		public Burger() {
			
		}
	     
	    

}
