package br.com.exactalabs.bicycleshop.service;

import br.com.exactalabs.bicycleshop.entity.Product;
import br.com.exactalabs.bicycleshop.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService (ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public Product


    public Customer findCustomerById (Long id){
        return this.customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado.") );
    }

    public Customer saveCustomer (Customer customer){
        return this.customerRepository.save(customer);
    }

    public Page<Customer> findAllCustomer (Integer pageNumber){
        var pageRequest = PageRequest.of(pageNumber, 20);
        return this.customerRepository.findAll(pageRequest);
    }

    public void deleteCustomerById (Long id){
        this.customerRepository.deleteById(id);
    }
}
