package com.zigzag.crm.usecase.feature.user

import com.zigzag.crm.framework.domain.api.repository.ICrmUserRepository
import com.zigzag.crm.usecase.api.user.IUsecase_FindAllUsers
import com.zigzag.crm.usecase.api.user.dto.CrmUserDto
import com.zigzag.crm.usecase.feature.user.mapper.CrmUserMapper
import reactor.core.publisher.Flux

class Usecase_FindAllUsers(private val userRepository: ICrmUserRepository,
                           private val crmUserMapper: CrmUserMapper
) : IUsecase_FindAllUsers {
    override fun execute(arg: String): Flux<CrmUserDto.Response.Public> {
       return userRepository.findAll().map{usr -> crmUserMapper.convertDomainModeltoResponsePublicDto(usr)};
    }
}
