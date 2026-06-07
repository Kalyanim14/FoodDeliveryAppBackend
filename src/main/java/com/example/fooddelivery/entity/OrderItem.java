package com.example.fooddelivery.entity;

import jakarta.persistence.*;

@Entity
@Table(name="order_items")
public class OrderItem {

    @Id
    @GeneratedValue(strategy =
            GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="order_id")
    private FoodOrder foodOrder;

    @ManyToOne
    @JoinColumn(name="food_item_id")
    private FoodItem foodItem;

    /**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the foodOrder
	 */
	public FoodOrder getFoodOrder() {
		return foodOrder;
	}

	/**
	 * @param foodOrder the foodOrder to set
	 */
	public void setFoodOrder(FoodOrder foodOrder) {
		this.foodOrder = foodOrder;
	}

	/**
	 * @return the foodItem
	 */
	public FoodItem getFoodItem() {
		return foodItem;
	}

	/**
	 * @param foodItem the foodItem to set
	 */
	public void setFoodItem(FoodItem foodItem) {
		this.foodItem = foodItem;
	}

	/**
	 * @return the quantity
	 */
	public Integer getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
	}

	private Integer quantity;

    private Double price;

    // getters setters
}