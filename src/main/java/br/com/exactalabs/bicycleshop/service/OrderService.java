package br.com.exactalabs.bicycleshop.service;

import br.com.exactalabs.bicycleshop.entity.Order;
import br.com.exactalabs.bicycleshop.repository.OrderRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private OrderRepository orderRepository;

    public OrderService (OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    public Order findOrderById (Long id){
        return this.orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Compra não encontrado.") );
    }

    public Order saveOrder (Order order){
        return this.orderRepository.save(order);
    }

    public Page<Order> findAllOrder (Integer pageNumber){
        var pageRequest = PageRequest.of(pageNumber, 20);
        return this.orderRepository.findAll(pageRequest);
    }

    public void deleteOrderById (Long id){
        this.orderRepository.deleteById(id);
    }
}
