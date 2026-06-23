package com.erp_ecom.Erp.dto;

import com.erp_ecom.Erp.enums.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

//import javax.management.relation.Role;


@Getter
@Setter
@Builder
public class UserResponseDto{

    private Long id;

    private String fullName;

    private String email;

    private String phone;

    private Role role;

    private Boolean active;
}
