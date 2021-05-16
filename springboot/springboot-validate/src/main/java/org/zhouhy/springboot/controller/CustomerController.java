package org.zhouhy.springboot.controller;

import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.zhouhy.springboot.dto.CustomerDto;

import javax.validation.constraints.Min;

@Validated
@RestController
@RequestMapping(value="/customer")
public class CustomerController {
    
    
    @PostMapping("/create")
    public String createCustomer(@RequestBody CustomerDto customerDto){
        System.out.println(customerDto);
        return customerDto.toString();
    }

    @GetMapping("/{customerId}")
    public String searchById(@PathVariable("customerId") @Min(18) Integer customerId){
        System.out.println(customerId);
        return "OK";
    }

    @GetMapping("/search")
    public String searchByCustomerName(@RequestParam("customerName") @Length(min = 6, max = 20) Integer customerId){
        System.out.println(customerId);
        return "OK";
    }
}
