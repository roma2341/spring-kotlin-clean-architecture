package com.zigzag.crm.usecase.feature.user

import com.zigzag.crm.framework.domain.api.repository.ICrmUserRepository
import com.zigzag.crm.usecase.api.user.Usecase_CreateUser
import com.zigzag.crm.usecase.api.user.dto.CrmUserDto
import com.zigzag.crm.usecase.feature.user.mapper.CrmUserMapper
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

@Component
class Usecase_CreateUser_Impl(private val userRepository: ICrmUserRepository,
                              private val crmUserMapper: CrmUserMapper
): Usecase_CreateUser {
    override fun execute(userDto: CrmUserDto.Request.Create): Mono<CrmUserDto.Response.Public> {
        var user = crmUserMapper.convertDtoToEntity(userDto);
        var persistedUser = userRepository.createUser(user);
        return persistedUser.map{usr -> crmUserMapper.convertEntityToDto(usr)};
    }
}
