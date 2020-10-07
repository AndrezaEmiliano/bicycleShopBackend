package br.com.exactalabs.bicycleshop.repository;

import br.com.exactalabs.bicycleshop.entity.ProductCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductCategoryRepository extends JpaRepository <ProductCategory, Long>{

    Page<ProductCategory> findAllProductCategoryByDescriptionLikeOrderByDescriptionAsc
            (String description, Pageable pageRequest);
}
