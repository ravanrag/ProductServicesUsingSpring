package com.example.simplespring.Services;

import ch.qos.logback.core.joran.sanity.Pair;
import com.example.simplespring.Dtos.FakeStoreProductDTO;
import com.example.simplespring.Models.Category;
import com.example.simplespring.Models.Product;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import java.security.KeyPair;
import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{
    private RestTemplate restTemplate=null;
     FakeStoreProductService(RestTemplate restTemplate){
        this.restTemplate=restTemplate;
    }

    private Product convertFakeStoreDTOtoProduct(FakeStoreProductDTO dto){
        Product p = new Product();
        p.setId(dto.getId());
        p.setTitle(dto.getTitle());
        p.setPrice(dto.getPrice());
        p.setDescription(dto.getDescription());
        p.setImage(dto.getImage());

        Category c = new Category();
        c.setName(dto.getCategory());
        p.setCategory(c);
        return p;
    }
    @Override
    public Product getProductByID(Long id) {
        FakeStoreProductDTO fakeStoreProductDTO =
        restTemplate.getForObject("https://fakestoreapi.com/products/"+id, FakeStoreProductDTO.class);
        if(fakeStoreProductDTO==null)
            throw new NullPointerException("FakeStoreProductDTO is null");
        return convertFakeStoreDTOtoProduct(fakeStoreProductDTO);
    }

    @Override
    public List<Product> getAllProducts() {
        FakeStoreProductDTO[] fakeStoreProductDTO = restTemplate.getForObject("https://fakestoreapi.com/products/", FakeStoreProductDTO[].class);
        List<Product> productList = new ArrayList<Product>();
        if(fakeStoreProductDTO==null)
            return null;
        for(FakeStoreProductDTO i : fakeStoreProductDTO){
            productList.add(convertFakeStoreDTOtoProduct(i));
        }
        Pair<String,String> r ;
        return productList;
    }
    @Override
    public Product replaceProduct(Long id, Product product){
        FakeStoreProductDTO fakeStoreProductDTO = new FakeStoreProductDTO();
        fakeStoreProductDTO.setTitle(product.getTitle());
        fakeStoreProductDTO.setImage(product.getImage());
        fakeStoreProductDTO.setDescription(product.getDescription());

        RequestCallback requestCallback = restTemplate.httpEntityCallback(fakeStoreProductDTO, FakeStoreProductDTO.class);
        HttpMessageConverterExtractor<FakeStoreProductDTO> responseExtractor = new HttpMessageConverterExtractor(FakeStoreProductDTO.class, restTemplate.getMessageConverters());
        FakeStoreProductDTO response = restTemplate.execute("https://fakestoreapi.com/products/"+id, HttpMethod.PUT, requestCallback, responseExtractor);
        return convertFakeStoreDTOtoProduct(response);
    }
}