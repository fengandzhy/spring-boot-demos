package org.zhouhy.springboot.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zhouhy.springboot.dto.CustomerDto;

@RestController
@RequestMapping(value="/customer")
public class CustomerController {
    
    
    @PostMapping("/create")
    public String createCustomer(@RequestBody CustomerDto customerDto){
        System.out.println(customerDto);
        return customerDto.toString();
    }
}
