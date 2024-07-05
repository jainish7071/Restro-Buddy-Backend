package com.app.restrobuddy.Entity;

import com.app.restrobuddy.Shared.Enum.OrderStatus;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
@NoArgsConstructor
@Getter
@Setter
public class OrderEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "table_id")
    private String tableId;

    @Column(name = "payment_id")
    private String paymentId;

    @Column(name = "order_time")
    private Date orderTime;

    @Column(name = "delivered_time")
    private Date deliveredTime;

    @Column(name = "estimated_time")
    private int estimatedTime;

    @Column(name="total_price")
    private Long totalPrice;

    @Column(name="discounted_price")
    private Long discountedPrice;

    @Column(name="order_status")
    private OrderStatus orderStatus;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<OrderItemEntity> items;
}
