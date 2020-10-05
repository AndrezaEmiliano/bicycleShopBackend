package br.com.exactalabs.bicycleshop.service;


import br.com.exactalabs.bicycleshop.entity.Product;
import br.com.exactalabs.bicycleshop.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService (ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public Page<Product> findAllProduct (Integer pageNumber){
        var pageRequest =
                PageRequest.of(pageNumber, 20);
        return productRepository.findAll(pageRequest);
    }

    public Product findProductByIdProduct (Long id){
        return this.productRepository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado."));
    }

    public Page<Product> findProductByNameAsc(String description, Integer pageNumber) {
        var pageRequest =
                PageRequest.of(pageNumber, 20);
        return this.productRepository.findAllProductByDescriptionLikeOrderByDescriptionAsc(description, pageRequest);
    }

//    public Page <Product> findProductByPriceAsc (Integer pageNumber) {
//        var pageRequest =
//                PageRequest.of(pageNumber, 20);
//        return this.productRepository.findAllProductByOrderByPriceAsc(pageRequest);
//    }
//
//    public Page <Product> findProductByPriceDesc (Integer pageNumber) {
//        var pageRequest =
//                PageRequest.of(pageNumber, 20);
//        return this.productRepository.findAllProductByOrderByPriceDesc(pageRequest);
//    }

    public Product saveProduct (Product product){
        return this.productRepository.save(product);
    }

    public void deleteProductById (Long id){
        this.productRepository.deleteById(id);
    }
}
