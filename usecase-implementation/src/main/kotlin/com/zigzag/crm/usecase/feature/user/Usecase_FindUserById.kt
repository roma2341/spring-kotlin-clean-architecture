package com.zigzag.crm.usecase.feature.user

import com.zigzag.crm.repository.api.ICrmUserRepository
import com.zigzag.crm.usecase.api.dto.user.CrmUserDto
import com.zigzag.crm.usecase.api.feature.user.IUsecase_CreateUser
import com.zigzag.crm.usecase.api.feature.user.IUsecase_FindUserById
import com.zigzag.crm.usecase.feature.user.mapper.CrmUserMapper

class Usecase_FindUserById(
    private val userRepository: ICrmUserRepository,
    private val crmUserMapper: CrmUserMapper
):IUsecase_FindUserById {

    override fun execute(userId: Long): CrmUserDto.Response.Public {
        val user = userRepository.findById(userId);
        return crmUserMapper.convertDomainModeltoResponsePublicDto(user);
    }

}
