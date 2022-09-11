package com.zigzag.crm.usecase.feature.user

import com.zigzag.crm.usecase.api.dto.user.CrmUserDto
import com.zigzag.crm.usecase.api.feature.user.IUsecaseCreateUser
import com.zigzag.crm.usecase.feature.user.mapper.CrmUserMapper
import org.springframework.stereotype.Component
import org.zigzag.repository.api.ICrmUserRepository

@Component
class UsecaseCreateUser(private val userRepository: ICrmUserRepository,
                        private val crmUserMapper: CrmUserMapper
): IUsecaseCreateUser {
    override fun execute(userDto: CrmUserDto.Request.Create): CrmUserDto.Response.Public {
        var user = crmUserMapper.convertRequestCreateToDomainModel(userDto);
        var persistedUser = userRepository.createUser(user);
        return crmUserMapper.convertDomainModeltoResponsePublicDto(persistedUser);
    }
}
