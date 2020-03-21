package org.zhouhy.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zhouhy.demo.dao.AddressDao;
import org.zhouhy.demo.entity.Address;
import org.zhouhy.demo.service.AddressService;

import java.util.List;

@Service("addressService")
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressDao addressDao;

    @Override
    public List<Address> getAllAddress() {
        return addressDao.findAll();
    }

    @Override
    public void SaveAddress(Address address) {
        addressDao.save(address);
    }

    @Override
    public Address getOne(Integer id) {
        return addressDao.getOne(id);
    }
}
