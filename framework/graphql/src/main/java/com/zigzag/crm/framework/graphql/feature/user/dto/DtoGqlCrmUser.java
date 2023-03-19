package com.zigzag.crm.framework.graphql.feature.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DtoGqlCrmUser {
    protected String id;
    protected String firstName;
    protected String lastName;
    protected String email;
}
