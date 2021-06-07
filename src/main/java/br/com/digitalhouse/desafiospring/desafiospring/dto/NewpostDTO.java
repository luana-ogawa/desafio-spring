package br.com.digitalhouse.desafiospring.desafiospring.dto;

import br.com.digitalhouse.desafiospring.desafiospring.domain.Product;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class NewpostDTO {

    private Integer userId;
    private Integer id_post;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date date;
    private Integer category;
    private double price;
    private Product detail;

    public NewpostDTO() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public Product getDetail() {
        return detail;
    }

    public void setDetail(Product detail) {
        this.detail = detail;
    }
}
