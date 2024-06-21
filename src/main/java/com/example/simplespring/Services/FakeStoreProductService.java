package com.example.simplespring.Services;

import com.example.simplespring.Dtos.FakeStoreProductDTO;
import com.example.simplespring.Models.Category;
import com.example.simplespring.Models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
            return null;

        return convertFakeStoreDTOtoProduct(fakeStoreProductDTO);

    }

    @Override
    public List<Product> getAllProducts() {
        return new ArrayList<Product>();
    }
}