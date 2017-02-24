package com.sosbt.raktarkezelesi.rendszer.models;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by Viktor on 2017.02.20..
 */
@Entity
@Table(name="item")
@Data
public class Item {
    @Id
    @GeneratedValue
    private long id;
    private long barCode;
    @ManyToOne
    @JoinColumn(name = "id")
    private User user;
    private String name;
    private String description;
    private long purchasePrice;
    private String seller;

}
