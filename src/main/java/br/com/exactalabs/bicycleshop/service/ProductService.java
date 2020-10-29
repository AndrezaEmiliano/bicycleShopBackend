package br.com.exactalabs.bicycleshop.service;

import br.com.exactalabs.bicycleshop.entity.Product;
import br.com.exactalabs.bicycleshop.entity.ProductCategory;
import br.com.exactalabs.bicycleshop.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService (ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public Page<Product> findAllProduct (Integer pageNumber, String priceDirection, String categoryName, String productName) {
        var pageRequest = PageRequest.of(
                pageNumber,
                20,
                Sort.by(Sort.Direction.valueOf(priceDirection), "price"));
        if(!productName.isEmpty() && !categoryName.equalsIgnoreCase("")){
            return this.productRepository.
                    findAllByDescriptionContainingIgnoreCaseAndProductCategoryDescription(productName, categoryName, pageRequest);
        }
        if(!productName.isEmpty()) {
            return this.productRepository.
                    findAllByDescriptionContainingIgnoreCase(productName, pageRequest);
        }
        if(!categoryName.equalsIgnoreCase("")) {
            return this.productRepository.
                    findAllProductByProductCategoryDescription(categoryName, pageRequest);
        }
        return this.productRepository.findAll(pageRequest);
    }

    public Product findProductById (Long id){
        return this.productRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Produto não encontrado."));
    }

    @Transactional
    public Product saveProduct (Product product){
        return this.productRepository.save(product);
    }

    @Transactional
    public void deleteProductById (Long id){
        this.productRepository.deleteById(id);
    }

    @Transactional
    public Product updateProduct(Long id, Product updatedProduct) {
        var product = this.findProductById(id);
        product.setDescription(updatedProduct.getDescription());
        product.setProductCategory(updatedProduct.getProductCategory());
        product.setQuantityProduct(updatedProduct.getQuantityProduct());
        product.setPrice(updatedProduct.getPrice());
        return this.saveProduct(product);
    }

}
