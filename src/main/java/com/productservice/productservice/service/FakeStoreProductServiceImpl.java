package com.productservice.productservice.service;

import com.productservice.productservice.dtos.FakeStoreProductDto;
import com.productservice.productservice.dtos.GenericProductDto;
import com.productservice.productservice.exceptions.ProductNotFoundException;
import com.productservice.productservice.thirdPartyClients.fakeStoreClients.FakeStoreClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProductServiceImpl")
public class FakeStoreProductServiceImpl implements ProductService{

    FakeStoreClient fakeStoreClient;
    FakeStoreProductServiceImpl(FakeStoreClient fakeStoreClient){
        this.fakeStoreClient = fakeStoreClient;
    }

    private static GenericProductDto convertToGenericProductDto(FakeStoreProductDto fakeStoreProductDto){
        GenericProductDto genericProductDto= new GenericProductDto();
        genericProductDto.setId(fakeStoreProductDto.getId());
        genericProductDto.setTitle(fakeStoreProductDto.getTitle());
        genericProductDto.setPrice(fakeStoreProductDto.getPrice());
        genericProductDto.setCategory(fakeStoreProductDto.getCategory());
        genericProductDto.setDescription(fakeStoreProductDto.getDescription());
        genericProductDto.setImage(fakeStoreProductDto.getImage());

        return genericProductDto;
    }
    @Override
    public GenericProductDto getProductById(Long id) throws ProductNotFoundException {

        FakeStoreProductDto fakeStoreProductDto= fakeStoreClient.getProductById((id));
        return convertToGenericProductDto(fakeStoreProductDto);
    }

    @Override
    public List<GenericProductDto > getAllProduct() {

        List<FakeStoreProductDto> listOfFakeStoreProductDto = fakeStoreClient.getAllProduct();
        List<GenericProductDto> result = new ArrayList<>();

        for(FakeStoreProductDto fakeStoreProductDto :listOfFakeStoreProductDto){
            result.add(convertToGenericProductDto(fakeStoreProductDto));
        }
        return result;
    }

    @Override
    public GenericProductDto updateProduct(Long id ,GenericProductDto genericProductDto) {
        FakeStoreProductDto fakeStoreProductDto= fakeStoreClient.updateProduct(id,genericProductDto);
        return convertToGenericProductDto(fakeStoreProductDto);

    }
    @Override
    public GenericProductDto createProduct(GenericProductDto genericProductDto) {
        FakeStoreProductDto fakeStoreProductDto = fakeStoreClient.createProduct(genericProductDto);
        return convertToGenericProductDto(fakeStoreProductDto );
    }


    @Override
    public GenericProductDto deleteProduct(Long id) {

        FakeStoreProductDto fakeStoreProductDto = fakeStoreClient.deleteProduct(id);

        return convertToGenericProductDto(fakeStoreProductDto);
     }
}
