package br.com.digitalhouse.desafiospring.desafiospring.service;

import br.com.digitalhouse.desafiospring.desafiospring.dtos.SellerDTO;

public interface SellersRepository {

    SellerDTO findSellerNameBySellerId(Integer sellerId);
    public void writeSellersDatabase(SellerDTO sellerDTO);

}
