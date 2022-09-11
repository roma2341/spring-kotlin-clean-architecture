package com.zigzag.crm.usecase.feature.user

import com.zigzag.crm.repository.api.ICrmUserRepository
import com.zigzag.crm.usecase.api.dto.user.CrmUserDto
import com.zigzag.crm.usecase.api.feature.user.IUsecase_CreateUser
import com.zigzag.crm.usecase.feature.user.mapper.CrmUserMapper
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

@Component
class Usecase_CreateUser(private val userRepository: ICrmUserRepository,
                         private val crmUserMapper: CrmUserMapper
): IUsecase_CreateUser {
    override fun execute(userDto: CrmUserDto.Request.Create): Mono<CrmUserDto.Response.Public> {
        var user = crmUserMapper.convertRequestCreateToDomainModel(userDto);
        var persistedUser = userRepository.createUser(user);
        return persistedUser.map{usr -> crmUserMapper.convertDomainModeltoResponsePublicDto(usr)};
    }
}
