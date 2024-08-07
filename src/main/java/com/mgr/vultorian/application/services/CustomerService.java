package com.mgr.vultorian.application.services;

import com.mgr.vultorian.domain.entities.Customer;
import com.mgr.vultorian.domain.utils.Response;
import com.mgr.vultorian.infra.repositories.CustomerRepository;
import com.mgr.vultorian.ui.dtos.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repo;

    public Response<CustomerDto> getById(Integer id) {

        try {
            return repo.findById(id)
                    .map(customer -> new Response<>(true, "success", convertToDto(customer)))
                    .orElse(new Response<>(false, "customer not found", null));

        } catch (Exception e) {
            return new Response<>(false, e.getMessage(), null);
        }
    }

    public Response<CustomerDto> getCustomerByDocument(String document) {

        try {
            return repo.findByDocument(document)
                    .map(customer -> new Response<>(true, "success", convertToDto(customer)))
                    .orElse(new Response<>(false, "customer not found", null));

        } catch (Exception e) {
            return new Response<>(false, e.getMessage(), null);
        }

    }

    private CustomerDto convertToDto(Customer customer) {

        return CustomerDto.builder()
                .id(customer.getId())
                .name(customer.getName())
                .document(customer.getDocument())
                .email(customer.getEmail())
                .address(customer.getAddress())
                .build();
    }
}
