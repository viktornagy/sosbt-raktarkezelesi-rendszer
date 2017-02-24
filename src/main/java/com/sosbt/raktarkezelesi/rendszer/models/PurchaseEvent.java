package com.sosbt.raktarkezelesi.rendszer.models;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by Viktor on 2017.02.20..
 */
@Entity
@Table(name = "purchase_event")
@Data
public class PurchaseEvent {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    @JoinColumn(name = "id")
    private Item item;
    private String name;
    private String description;
    private long purchasePrice;
    private String seller;


}
