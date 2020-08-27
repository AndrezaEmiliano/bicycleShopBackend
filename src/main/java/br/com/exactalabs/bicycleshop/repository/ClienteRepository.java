package br.com.exactalabs.bicycleshop.repository;

import br.com.exactalabs.bicycleshop.entity.Cliente;
import br.com.exactalabs.bicycleshop.entity.PessoaFisica;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

public class ClienteRepository {

    private final EntityManager entityManager;

    public ClienteRepository() {
        this.entityManager = Persistence
                .createEntityManagerFactory("br.com.exactalabs.bicycleshop")
                .createEntityManager();
    }

    public Cliente findById(Long id) {
        return this.entityManager.find(Cliente.class, id);
    }

    public List<Cliente> findAll() {
        return this.entityManager.createQuery("SELECT c FROM Cliente c")
                .getResultList();
    }

}
