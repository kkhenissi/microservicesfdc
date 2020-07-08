package com.fidecoin.billingservice.controllers;

import com.fidecoin.billingservice.entities.Bill;
import com.fidecoin.billingservice.repository.BillRepository;
import com.fidecoin.billingservice.repository.CustomerService;
import com.fidecoin.billingservice.repository.InventoryService;
import com.fidecoin.billingservice.repository.ProductItemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillRestController {
    @Autowired
    private BillRepository billRepository;
    @Autowired
    private ProductItemRepository productItemRepository;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private InventoryService inventoryService;
    @GetMapping(value = "/fullBill/{id}",produces={"application/json"})
    public Bill getBill(@PathVariable(name = "id") Long id) {
        Bill bill = billRepository.findById(id).get();
        bill.setCustomer(customerService.findCustomerById(bill.getCustomerId()));
        bill.getProductItems().forEach(prdItm -> {
            prdItm.setProduct(inventoryService.findProductById(prdItm.getProductId()));
        });
      return  bill;
    }
}
