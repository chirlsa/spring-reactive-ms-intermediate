package com.myapp.spring.api;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public record OrderRequest(
		
		
		@NotBlank(message = " product id must be defined") String productId,
		@NotBlank(message = " product name must be defined")String productName,
		
		@NotNull (message = " product quantity must be defined") 
		@Min (value =1, message = " your order must have atleast 1 item")
		@Max (value =5, message = " you cannot order more than 5 items")
		Integer  quantity) {

}
