package com.example.simplespring.Services;

import com.example.simplespring.Dtos.FakeStoreProductDTO;
import com.example.simplespring.Dtos.ProductNotFoundExceptionDTO;
import com.example.simplespring.Dtos.ProductUpdateDTO;
import com.example.simplespring.Exceptions.ProductNotFoundException;
import com.example.simplespring.Models.Category;
import com.example.simplespring.Models.Product;
import org.springframework.http.HttpMethod;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
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
        p.setName(dto.getName());
        p.setPrice(dto.getPrice());
        p.setDescription(dto.getDescription());
        p.setImage(dto.getImage());

        Category c = new Category();
        c.setName(dto.getCategory());
        p.setCategory(c);
        return p;
    }
    @Override
    public Product getProductByID(Long id) throws ProductNotFoundException {
        FakeStoreProductDTO fakeStoreProductDTO =
        restTemplate.getForObject("https://fakestoreapi.com/products/"+id, FakeStoreProductDTO.class);
        if(fakeStoreProductDTO==null){
            ProductNotFoundException productNotFoundException = new ProductNotFoundException("FakeStoreProductDTO is null", id);
            throw productNotFoundException;
        }
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
        return productList;
    }
    @Override
    public Product replaceProduct(Long id, Product product){
        FakeStoreProductDTO fakeStoreProductDTO = new FakeStoreProductDTO();
        fakeStoreProductDTO.setName(product.getName());
        fakeStoreProductDTO.setImage(product.getImage());
        fakeStoreProductDTO.setDescription(product.getDescription());

        RequestCallback requestCallback = restTemplate.httpEntityCallback(fakeStoreProductDTO, FakeStoreProductDTO.class);
        HttpMessageConverterExtractor<FakeStoreProductDTO> responseExtractor = new HttpMessageConverterExtractor(FakeStoreProductDTO.class, restTemplate.getMessageConverters());
        FakeStoreProductDTO response = restTemplate.execute("https://fakestoreapi.com/products/"+id, HttpMethod.PUT, requestCallback, responseExtractor);
        return convertFakeStoreDTOtoProduct(response);
    }

    @Override
    public Product updateProduct(Long id, ProductUpdateDTO product) throws ProductNotFoundException {
        FakeStoreProductDTO fakeStoreProductDTO =
                restTemplate.getForObject("https://fakestoreapi.com/products/"+id, FakeStoreProductDTO.class);

        if(fakeStoreProductDTO==null){
            ProductNotFoundException productNotFoundException = new ProductNotFoundException("FakeStoreProductDTO is null", id);
            throw productNotFoundException;
        }
        if (product.getId() != null)
            fakeStoreProductDTO.setId(product.getId());
        if (product.getDescription() != null)
            fakeStoreProductDTO.setDescription(product.getDescription());
        if (product.getImage() != null)
            fakeStoreProductDTO.setImage(product.getImage());
        if (product.getPrice() != null)
            fakeStoreProductDTO.setPrice(product.getPrice());
        if (product.getName() != null)
            fakeStoreProductDTO.setName(product.getName());
        if (product.getCategory() != null) {
            fakeStoreProductDTO.setCategory(product.getCategory());
        }

        RequestCallback requestCallback = restTemplate.httpEntityCallback(fakeStoreProductDTO, FakeStoreProductDTO.class);
        HttpMessageConverterExtractor<FakeStoreProductDTO> responseExtractor = new HttpMessageConverterExtractor(FakeStoreProductDTO.class, restTemplate.getMessageConverters());
        FakeStoreProductDTO response = restTemplate.execute("https://fakestoreapi.com/products/"+id, HttpMethod.PUT, requestCallback, responseExtractor);
        return convertFakeStoreDTOtoProduct(response);
    }

    @Override
    public boolean deleteProduct(Long id) throws ProductNotFoundException {
        FakeStoreProductDTO fakeStoreProductDTO =
                restTemplate.getForObject("https://fakestoreapi.com/products/"+id, FakeStoreProductDTO.class);
        try {
            if (fakeStoreProductDTO==null)
                throw new Exception();
            restTemplate.delete("https://fakestoreapi.com/products/" + id);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }
}