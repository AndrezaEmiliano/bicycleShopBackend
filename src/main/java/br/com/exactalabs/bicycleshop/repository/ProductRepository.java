package br.com.exactalabs.bicycleshop.repository;

import br.com.exactalabs.bicycleshop.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Page<Product> findAllProductByDescriptionLikeOrderByDescriptionAsc(String description, Pageable pageRequest);

//    Page<Product> findAllProductByOrderByPriceAsc(Pageable pageRequest);
//
//    Page<Product> findAllProductByOrderByPriceDesc(Pageable pageRequest);
}
