package br.com.digitalhouse.desafiospring.desafiospring.domain;

import br.com.digitalhouse.desafiospring.desafiospring.domain.enums.Category;
import br.com.digitalhouse.desafiospring.desafiospring.dto.NewpostDTO;
import br.com.digitalhouse.desafiospring.desafiospring.dto.NewpostPromoDTO;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class NewpostPromo extends Newpost{

    private boolean hasPromo;
    private double discount;

    public NewpostPromo() {
    }

    public NewpostPromo(Integer id_post, Date date, Category category, double price, Seller seller, Product detail, boolean hasPromo, double discount) {
        super(id_post, date, category, price, seller, detail);
        this.hasPromo = hasPromo;
        this.discount = discount;
    }

    public NewpostPromo(NewpostDTO newpostDTO, boolean hasPromo, double discount) {
        super(newpostDTO);
        this.hasPromo = hasPromo;
        this.discount = discount;
    }

    public NewpostPromo(NewpostPromoDTO newpostPromoDTO) {
        super.setId_post(newpostPromoDTO.getId_post());
        super.setDate(newpostPromoDTO.getDate());
        super.setCategory(newpostPromoDTO.getCategory());
        super.setPrice(newpostPromoDTO.getPrice());
        super.setSeller(new Seller(newpostPromoDTO.getUserId()));
        super.setDetail(newpostPromoDTO.getDetail());

        this.discount = newpostPromoDTO.getDiscount();
        this.hasPromo = newpostPromoDTO.isHasPromo();
    }

    public boolean isHasPromo() {
        return hasPromo;
    }

    public void setHasPromo(boolean hasPromo) {
        this.hasPromo = hasPromo;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }



}
