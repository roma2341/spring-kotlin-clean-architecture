package com.zigzag.crm.usecase.user

import com.zigzag.crm.usecase.api.IUsecase
import com.zigzag.crm.usecase.api.IUsecaseNoArg
import com.zigzag.crm.usecase.user.converter.CrmUserMapper
import com.zigzag.crm.usecase.user.dto.CrmUserDto
import org.zigzag.repository.api.ICrmUserRepository

class UsecaseCreateUser(private val userRepository: ICrmUserRepository,
                        private val crmUserMapper: CrmUserMapper
):
    IUsecase<CrmUserDto, CrmUserDto> {
    override fun execute(userDto: CrmUserDto): CrmUserDto {
        var user = crmUserMapper.toUser(userDto);
        var persistedUser = userRepository.createUser(user);
        return crmUserMapper.toUserDto(persistedUser);
    }
}
