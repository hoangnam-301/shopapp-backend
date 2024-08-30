package com.example.shopapp.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import lombok.*;

@Data//toString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDetailDTO {
    @JsonProperty("order_id")
    @Min(value=1, message = "Order's ID must be > 0")
    private Long orderId;

    @JsonProperty("product_id")
    @Min(value=1, message = "Product's ID must be > 0")
    private Long productId;

    @JsonProperty("number_of_products")
    @Min(value=0, message = "Number of products must be >= 0")
    private int numberOfProducts;


    @Min(value=0, message = "Total money must be >= 0")
    @JsonProperty("total_money")
    private int totalMoney;

    @JsonProperty("color_money")
    @Min(value=1, message = "Order's ID must be > 0")
    private String color;
}
