package com.app.restrobuddy.Entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemEntityKey implements Serializable {
    private Long orderId;
    private Long itemId;
}
