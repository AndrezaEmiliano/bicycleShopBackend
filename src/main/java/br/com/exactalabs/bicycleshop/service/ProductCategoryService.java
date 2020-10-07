package br.com.exactalabs.bicycleshop.service;

import br.com.exactalabs.bicycleshop.entity.ProductCategory;
import br.com.exactalabs.bicycleshop.repository.ProductCategoryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ProductCategoryService {

    private ProductCategoryRepository productCategoryRepository;

    public ProductCategoryService(ProductCategoryRepository productCategoryRepository) {
        this.productCategoryRepository = productCategoryRepository;
    }

    public ProductCategory findProductByIdProductCategory(Long id) {
        return this.productCategoryRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Categoria não encontrada"));
    }

    public Page<ProductCategory> findAllProductCategory(Integer pageNumber) {
        var pageRequest =
                PageRequest.of(pageNumber, 20);
        return this.productCategoryRepository.findAll(pageRequest);
    }

    public ProductCategory saveProductCategory(ProductCategory productCategory) {
        return this.productCategoryRepository.save(productCategory);
    }

    public void deleteProductCategoryById(Long id) {
        this.productCategoryRepository.deleteById(id);
    }

    public Page<ProductCategory> findProductCategoryByNameAsc (String description, Integer pageNumber){
        var pageRequest =
                PageRequest.of(pageNumber, 20);
        return this.productCategoryRepository.findAllProductCategoryByDescriptionLikeOrderByDescriptionAsc
                (description, pageRequest);
        }
}
