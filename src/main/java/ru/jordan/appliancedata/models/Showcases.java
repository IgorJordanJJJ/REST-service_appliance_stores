package ru.jordan.appliancedata.models;


import org.hibernate.annotations.Cascade;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Showcases")
public class Showcases {
    @Id
    @Column(name = "uuid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String Adress;

    @Column(name = "type")
    private String Type;

    @Column(name = "datecreate")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date datecreate;

    @Column(name = "datechange")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datechange;


    @OneToMany(mappedBy = "showcases_id")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private List<Product> products;


    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Showcases() {
    }

    public Showcases(Long id) {
        this.id = id;
    }

    public String getAdress() {
        return Adress;
    }

    public void setAdress(String adress) {
        Adress = adress;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public Date getDatecreate() {
        return datecreate;
    }

    public void setDatecreate(Date datecreate) {
        datecreate = datecreate;
    }

    public Date getDatechange() {
        return datechange;
    }

    public void setDatechange(Date datechange) {
        datechange = datechange;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }


}
