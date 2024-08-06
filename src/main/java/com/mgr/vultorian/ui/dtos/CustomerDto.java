package com.mgr.vultorian.ui.dtos;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CustomerDto {
    private Integer id;
    private String name;
    private String document;
    private String address;
    private String email;
}