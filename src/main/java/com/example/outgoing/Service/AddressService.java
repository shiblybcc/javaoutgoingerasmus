package com.example.outgoing.Service;


import com.example.outgoing.Entity.Address;
import com.example.outgoing.Entity.User;

import java.util.List;

public interface AddressService {

    public List<Address> findAll();
    public Address findById(Integer id);
    public Address save(Address address);
    public void destroy(Address address);

}
