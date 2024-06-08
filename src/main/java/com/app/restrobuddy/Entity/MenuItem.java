package com.app.restrobuddy.Entity;


import com.app.restrobuddy.Shared.Enum.ItemType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "items")
@Entity
@NoArgsConstructor
@Getter
@Setter
public class MenuItem {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @Column(name="price")
    private Double price;

    @Column(name="discount")
    private int discount;

    @Column(name="image_url")
    private String imageUrl;

    @Column(name="is_recommended")
    private boolean isRecommended;

    @Column(name="time_to_prepare")
    private int timeToPrepare;

    @Column(name="is_available")
    private boolean isAvailable;

    @Column(name="is_active")
    private boolean isActive;

    @Column(name="item_type")
    private ItemType itemType;
}
