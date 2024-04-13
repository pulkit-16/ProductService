package com.productservice.productservice.thirdPartyClients.fakeStoreClients;

import com.productservice.productservice.dtos.FakeStoreProductDto;
import com.productservice.productservice.dtos.GenericProductDto;
import com.productservice.productservice.exceptions.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class FakeStoreClient {
    private RestTemplateBuilder restTemplateBuilder ;


    private String getSpecificProductUrl;
    private String getGenericProductsUrl ;


    FakeStoreClient(RestTemplateBuilder restTemplateBuilder ,
                    @Value("${fakestore.api.url}") String fakeStoreUrl,
                    @Value("${fakestore.api.paths.products}")String pathForProducts ){
        this.restTemplateBuilder = restTemplateBuilder;
        this.getSpecificProductUrl = fakeStoreUrl + pathForProducts + "/{id}";
        this.getGenericProductsUrl = fakeStoreUrl + pathForProducts;
    }




    public FakeStoreProductDto getProductById(Long id) throws ProductNotFoundException {

        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> responseEntity =
                restTemplate.getForEntity(getSpecificProductUrl,FakeStoreProductDto.class,id);
        FakeStoreProductDto fakeStoreProductDto = responseEntity.getBody();


        if(fakeStoreProductDto ==null){
            //throw exception
            throw  new ProductNotFoundException("product with id "+id +" not found , please check");
        }
        return fakeStoreProductDto;
    }


    public List<FakeStoreProductDto> getAllProduct() {

        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> responseEntity = restTemplate.getForEntity(getGenericProductsUrl , FakeStoreProductDto[].class);
        List<FakeStoreProductDto> listOfFakeStoreProductDto = List.of( responseEntity.getBody());

        return listOfFakeStoreProductDto;
    }


    public FakeStoreProductDto updateProduct(Long id ,GenericProductDto genericProductDto) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<GenericProductDto> requestEntity = new HttpEntity<>(genericProductDto, headers);
        ResponseEntity<FakeStoreProductDto> responseEntity =
                restTemplate.exchange(getSpecificProductUrl, HttpMethod.PUT, requestEntity, FakeStoreProductDto.class, id);
        return responseEntity.getBody();

    }

    public FakeStoreProductDto createProduct(GenericProductDto genericProductDto) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> responseEntity =
                restTemplate.postForEntity(getGenericProductsUrl , genericProductDto,FakeStoreProductDto.class);

        return responseEntity.getBody() ;
    }


    //in deleteProduct generally we return boolean or void but in fakestore we need to return details of
    //product deleted , inbuilt http call of deleteEntity gives void so we need to make changes in its internals

    public FakeStoreProductDto deleteProduct(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();

        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor =
                restTemplate.responseEntityExtractor(FakeStoreProductDto.class);

        ResponseEntity<FakeStoreProductDto>responseEntity =
                restTemplate.execute(getSpecificProductUrl, HttpMethod.DELETE, requestCallback, responseExtractor, id);
        return responseEntity.getBody();
    }
}
