package br.com.exactalabs.bicycleshop;

import br.com.exactalabs.bicycleshop.entity.PessoaFisica;
import br.com.exactalabs.bicycleshop.repository.ClienteRepository;

public class BicycleShopApplication {

    public static void main(String[] args) {

        var clienteRepository = new ClienteRepository();

        var cliente = clienteRepository.findById(1L);

        var clientes = clienteRepository.findAll();

        PessoaFisica pf = new PessoaFisica();


        System.out.println(cliente);
        System.out.println(clientes);

    }

}
