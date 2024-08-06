package com.mgr.vultorian.ui.resources;

import com.mgr.vultorian.domain.utils.Response;
import com.mgr.vultorian.ui.dtos.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mgr.vultorian.application.services.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerResource {

    @Autowired
    private CustomerService service;

    @GetMapping("/{id}")
    public ResponseEntity<Response<CustomerDto>> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getById(id));
    }
}
