package com.nextbook.requests;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public abstract class ProductBaseRequestDTO {
	@NotBlank(message = "Name is required.")
    @Size(max = 100, message = "Name must be at most 100 characters.")
    private String name;

    @NotNull(message = "Price is required.")
    @DecimalMin(value = "0.01", message = "Price must be greater than zero.")
    @Digits(integer = 3, fraction = 2, message = "Price must have at most 3 digits and 2 decimal places.")
    private BigDecimal price;

    @NotBlank(message = "Description is required.")
    @Size(max = 150, message = "Description must be at most 150 characters.")
    private String description;

    @NotNull(message = "Quantity is required.")
    @Min(value = 1, message = "Quantity must be greater than zero.")
    private Integer quantity;

    @NotBlank(message = "Image is required.")
    private String imageUrl;
	
	public ProductBaseRequestDTO(String name, BigDecimal price, String description, int quantity, String imageUrl) {
		this.name = name;
		this.price = price;
		this.description = description;
		this.quantity = quantity;
		this.imageUrl = imageUrl;
	}
	
	public String getName() {
		return name;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public int getQuantity() {
		return quantity;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public String getDescription() {
		return description;
	}
}
