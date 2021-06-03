package br.com.digitalhouse.desafiospring.desafiospring.domain;

import br.com.digitalhouse.desafiospring.desafiospring.domain.enums.Category;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
public class Newpost implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_post;

    private Date date;
    private Integer category;
    private double price;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "userId")
    private Seller seller;

    @OneToOne
    @JoinColumn(name = "product_id")
    @MapsId
    private Product detail;

    public Newpost(){
    }

    public Newpost(Integer id_post, Date date, Category category, double price, Seller seller, Product detail) {
        this.id_post = id_post;
        this.date = date;
        this.category = category.getCodigo();
        this.price = price;
        this.seller = seller;
        this.detail = detail;
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

    public Category getCategory() {
        return Category.toEnum(category);
    }

    public void setCategory(Category category) {
        this.category = category.getCodigo();
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

    public Product getDetail() {
        return detail;
    }

    public void setDetail(Product detail) {
        this.detail = detail;
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
