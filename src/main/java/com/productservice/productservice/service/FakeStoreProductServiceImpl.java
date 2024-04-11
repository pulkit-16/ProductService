package com.productservice.productservice.service;

import com.productservice.productservice.dtos.FakeStoreProductDto;
import com.productservice.productservice.dtos.GenericProductDto;
import com.productservice.productservice.exceptions.ProductNotFoundException;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProductServiceImpl")
public class FakeStoreProductServiceImpl implements ProductService{

    private  RestTemplateBuilder restTemplateBuilder ;

    FakeStoreProductServiceImpl(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder = restTemplateBuilder;
    }

    String getSpecificProductUrl = "https://fakestoreapi.com/products/{id}";
    String getGenericProductsUrl = "https://fakestoreapi.com/products";

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

        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> responseEntity =
                restTemplate.getForEntity(getSpecificProductUrl,FakeStoreProductDto.class,id);
        FakeStoreProductDto fakeStoreProductDto = responseEntity.getBody();
        //convert FakeStoreProductDto to GenericProductDto before returning

        if(fakeStoreProductDto ==null){
            //throw exception
            throw  new ProductNotFoundException("product with id "+id +" not found , please check");
        }
        return convertToGenericProductDto(fakeStoreProductDto);
    }



    @Override
    public List<GenericProductDto > getAllProduct() {

        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> responseEntity = restTemplate.getForEntity(getGenericProductsUrl , FakeStoreProductDto[].class);
        List<FakeStoreProductDto> listOfFakeStoreProductDto = List.of( responseEntity.getBody());
        List<GenericProductDto> result = new ArrayList<>();

        for(FakeStoreProductDto fakeStoreProductDto :listOfFakeStoreProductDto){
            result.add(convertToGenericProductDto(fakeStoreProductDto));
        }
        return result;
    }

    @Override
    public GenericProductDto updateProduct(Long id ,GenericProductDto genericProductDto) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<GenericProductDto> requestEntity = new HttpEntity<>(genericProductDto, headers);
        ResponseEntity<FakeStoreProductDto> responseEntity =
                restTemplate.exchange(getSpecificProductUrl, HttpMethod.PUT, requestEntity, FakeStoreProductDto.class, id);
        return convertToGenericProductDto(responseEntity.getBody());

    }
    @Override
    public GenericProductDto createProduct(GenericProductDto genericProductDto) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> responseEntity =
                restTemplate.postForEntity(getGenericProductsUrl , genericProductDto,FakeStoreProductDto.class);
            // genericProductDto inside postForEntity is a  request body from where attributes gets added
        return convertToGenericProductDto(responseEntity.getBody() );
    }


    //in deleteProduct generally we return boolean or void but in fakestore we need to return details of
    //product deleted , inbuilt http call of deleteEntity gives void so we need to make changes in its internals
    @Override
    public GenericProductDto deleteProduct(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();

        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor =
                restTemplate.responseEntityExtractor(FakeStoreProductDto.class);

        ResponseEntity<FakeStoreProductDto>responseEntity =
                restTemplate.execute(getSpecificProductUrl, HttpMethod.DELETE, requestCallback, responseExtractor, id);
        return convertToGenericProductDto(responseEntity.getBody());
     }
}
