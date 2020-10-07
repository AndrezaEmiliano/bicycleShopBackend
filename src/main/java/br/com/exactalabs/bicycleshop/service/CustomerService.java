package br.com.exactalabs.bicycleshop.service;

import br.com.exactalabs.bicycleshop.entity.Customer;
import br.com.exactalabs.bicycleshop.repository.CustomerRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    public CustomerService (CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

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
