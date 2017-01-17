package com.allstate.entities;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "product")
@Data
public class Product {

    private int id ;
    private int version;
    private String name;
    private String stock_number;
    private String description;
    private int rating;
    private int reviews_count;
    private double list_price;
    private double discount ;
    private double actual_price;
    private int quantity;
    private boolean restricted;
    private Date created;
    private Date modified;

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Version
    public int getVersion() {
        return version;
    }
    public void setVersion(int version) {
        this.version = version;
    }

    @Column(nullable = false, unique = true)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getStock_number() {
        return stock_number;
    }
    public void setStock_number(String stock_number) {
        this.stock_number = stock_number;
    }

    @CreationTimestamp
    public Date getCreated() {
        return created;
    }
    public void setCreated(Date created) {
        this.created = created;
    }

    @UpdateTimestamp
    public Date getModified() {
        return modified;
    }
    public void setModified(Date modified) {
        this.modified = modified;
    }
}