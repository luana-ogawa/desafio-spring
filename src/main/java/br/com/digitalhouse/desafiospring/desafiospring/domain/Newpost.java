package br.com.digitalhouse.desafiospring.desafiospring.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
public class Newpost implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_post;

    @JsonFormat(pattern="dd-MM-yyyy")
    private Date date;
    private Integer category;
    private double price;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private Product product;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "userId")
    private Seller seller;

    public Newpost(){
    }

    public Newpost(Integer id_post, Date date, Integer category, double price, Product product, Seller seller) {
        this.id_post = id_post;
        this.date = date;
        this.category = category;
        this.price = price;
        this.product = product;
        this.seller = seller;
    }

    public Integer getId_post() {
        return id_post;
    }

    public void setId_post(Integer id_post) {
        this.id_post = id_post;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Newpost newpost = (Newpost) o;
        return Objects.equals(id_post, newpost.id_post);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_post);
    }
}
