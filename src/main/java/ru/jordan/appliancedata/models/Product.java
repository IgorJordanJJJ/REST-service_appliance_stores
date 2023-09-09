package ru.jordan.appliancedata.models;


import org.hibernate.annotations.Cascade;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Product")
public class Product {
    @Id
    @Column(name = "uuid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uuid;


    @ManyToOne
    @JoinColumn(name = "showcases_id", referencedColumnName = "uuid")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private Showcases showcases;


    @Min(value = 1, message = "Price should be greater than 1")
    @Column(name = "position")
    private int position;

    @Size(min = 1, max = 30, message = "Name should be between 1 and 30 characters")
    @Column(name = "name")
    private String name;

    @Column(name = "type")
    @Size(min = 1, max = 30, message = "Name should be between 1 and 30 characters")
    private String type;

    @Column(name = "price")
    @Min(value = 1, message = "Price should be greater than 1")
    private BigDecimal price;

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
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
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

    public Showcases getShowcases() {
        return showcases;
    }

    public void setShowcases(Showcases showcases) {
        this.showcases = showcases;
    }
}
