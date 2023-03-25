package com.zigzag.crm.usecase.feature.user

import com.zigzag.crm.framework.domain.api.repository.ICrmUserRepository
import com.zigzag.crm.usecase.api.user.Usecase_FindAllUsers
import com.zigzag.crm.usecase.api.user.dto.CrmUserDto
import com.zigzag.crm.usecase.feature.user.mapper.CrmUserMapper
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux

@Component
class Usecase_FindAllUsers_Impl(private val userRepository: ICrmUserRepository,
                                private val crmUserMapper: CrmUserMapper
) : Usecase_FindAllUsers {
    override fun execute(): Flux<CrmUserDto.Response.Public> {
       return userRepository.findAll().map{usr -> crmUserMapper.convertEntityToDto(usr)};
    }
}
