package br.com.exactalabs.bicycleshop.repository;

import br.com.exactalabs.bicycleshop.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Page<Product> findAllByDescriptionContainingIgnoreCaseAndProductCategoryDescription (String productName, String categoryName, Pageable pageRequest);

    Page<Product> findAllByDescriptionContainingIgnoreCase (String productName, Pageable pageRequest);

    Page<Product> findAllProductByProductCategoryDescription(String categoryName, Pageable pageRequest);
}
