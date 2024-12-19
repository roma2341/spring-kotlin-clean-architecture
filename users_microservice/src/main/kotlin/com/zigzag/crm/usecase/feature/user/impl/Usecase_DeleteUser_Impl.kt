package com.zigzag.crm.usecase.feature.user.impl

import com.zigzag.crm.framework.domain.api.features.user.ICrmUserRepository
import com.zigzag.crm.usecase.feature.user.api.Usecase_DeleteUser
import com.zigzag.crm.usecase.feature.user.dto.CrmUserDto
import com.zigzag.crm.usecase.feature.user.mapper.CrmUserMapper
import reactor.core.publisher.Mono
import java.time.Instant

class Usecase_DeleteUser_Impl(private val userRepository: ICrmUserRepository,
                              private val crmUserMapper: CrmUserMapper) : Usecase_DeleteUser {
    override fun execute(id: String): Mono<CrmUserDto.Response.Public> {
        return userRepository.findById(id).map {
            it.deletedAt = Instant.now();
            crmUserMapper.convertEntityToDto(it)
        }
    }
}