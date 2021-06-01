package br.com.digitalhouse.desafiospring.desafiospring.service;

import br.com.digitalhouse.desafiospring.desafiospring.dtos.SellerDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Repository
public class SellerRepositoryImpl implements SellersRepository{

    @Override
    public SellerDTO findSellerNameBySellerId(Integer sellerId) {
        List<SellerDTO> sellerDTOList = null;
        sellerDTOList = loadSellersDataBase();
        SellerDTO result = null;
        if(sellerDTOList != null) {
            result = sellerDTOList.stream()
                    .filter(element -> element.getUserId().equals(sellerId))
                    .findFirst().orElse(null);
        }
        return result;
    }

    @Override
    public void writeSellersDatabase(SellerDTO sellerDTO) {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:sellers.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(file, sellerDTO);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<SellerDTO> loadSellersDataBase(){
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:sellers.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<SellerDTO>> typeRef = new TypeReference<>() {};
        List<SellerDTO> sellerDTOList = null;
        try {
            sellerDTOList = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sellerDTOList;

    }
}
