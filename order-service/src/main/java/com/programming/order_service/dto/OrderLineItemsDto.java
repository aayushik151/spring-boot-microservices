package com.programming.order_service.dto;

import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderLineItemsDto {
    private Long id;
    private String skuCode;
    private Integer price;
    private Integer quantity;
}
