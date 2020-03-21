package org.zhouhy.demo.service;

import org.zhouhy.demo.entity.Address;

import java.util.List;

public interface AddressService {

    public List<Address> getAllAddress();

    public void SaveAddress(Address address);

    public Address getOne(Integer id);
}
