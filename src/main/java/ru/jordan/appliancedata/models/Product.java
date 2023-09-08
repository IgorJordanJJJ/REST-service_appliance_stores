package ru.jordan.appliancedata.models;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "Product")
public class Product {
    @Id
    @Column(name = "uuid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uuid;


    @Min(value = 1, message = "Price should be greater than 1")
    @Column(name = "showcases_id")
    private int showcases_id;


    @Min(value = 1, message = "Price should be greater than 1")
    @Column(name = "position")
    private int position;

    @Size(min = 1, max = 30, message = "Name should be between 1 and 30 characters")
    @Column(name = "name")
    private String name;

    @Column(name = "type")
    @Size(min = 1, max = 30, message = "Name should be between 1 and 30 characters")
    private String Type;

    @Column(name = "price")
    @Min(value = 1, message = "Price should be greater than 1")
    private int price;

    @Column(name = "datecreate")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date datecreate;

    @Column(name = "datechange")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datechange;


    public Product() {
    }

    public Product(int uuid) {
        this.uuid = uuid;
    }

    public void setId(int uuid) {
        this.uuid = uuid;
    }

    public int getId() {
        return uuid;
    }

    public int getUuid() {
        return uuid;
    }

    public void setUuid(int uuid) {
        this.uuid = uuid;
    }

    public int getShowcases_id() {
        return showcases_id;
    }

    public void setShowcases_id(int showcases_id) {
        this.showcases_id = showcases_id;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getDatecreate() {
        return datecreate;
    }

    public void setDatecreate(Date datecreate) {
        this.datecreate = datecreate;
    }

    public Date getDatechange() {
        return datechange;
    }

    public void setDatechange(Date datechange) {
        this.datechange = datechange;
    }
}
