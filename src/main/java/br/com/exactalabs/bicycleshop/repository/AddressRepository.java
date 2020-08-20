package br.com.exactalabs.bicycleshop.repository;

import br.com.exactalabs.bicycleshop.entity.Address;
import br.com.exactalabs.bicycleshop.entity.Page;

import java.util.ArrayList;

public class AddressRepository {

    public Page<Address> findAllPaged() {
        var page = new Page<Address>();
        return page;
    }

}
