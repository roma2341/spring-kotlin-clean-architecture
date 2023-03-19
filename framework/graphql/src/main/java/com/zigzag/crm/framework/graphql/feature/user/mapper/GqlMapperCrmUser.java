package com.zigzag.crm.framework.graphql.feature.user.mapper;

import com.zigzag.crm.framework.graphql.feature.user.dto.DtoGqlCrmUser;
import com.zigzag.crm.usecase.api.user.dto.CrmUserDto;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring"
)
public interface GqlMapperCrmUser {
    CrmUserDto.Request.Create convertToCreateRequestDto(DtoGqlCrmUser var1);

    DtoGqlCrmUser convertToResponseDto( CrmUserDto.Response.Public var1);
}
