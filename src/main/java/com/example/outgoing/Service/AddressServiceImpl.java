package com.example.outgoing.Service;

import com.example.outgoing.Entity.Address;
import com.example.outgoing.Entity.Stammdaten;
import com.example.outgoing.Repository.AddressRepository;
import com.example.outgoing.Repository.StammdatenRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("addressService")
@Transactional
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Address> findAll() {
        return Lists.newArrayList(addressRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Address findById(Integer id) {
        return addressRepository.findOne(id);
    }

    @Override
    @Transactional
    public Address save(Address address) {
        return addressRepository.save(address);
    }


    @Override
    public void destroy(Address address) {
        addressRepository.delete(address);
    }
}
