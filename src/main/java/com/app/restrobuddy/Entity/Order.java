package com.app.restrobuddy.Entity;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
public class Order {

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

    @JoinTable(name = "order_items",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id")
    )
    @ManyToMany(cascade = CascadeType.REFRESH,fetch = FetchType.EAGER)
    private List<MenuItem> items;
}
