package com.zigzag.crm.usecase.feature.user

import com.zigzag.crm.framework.domain.api.features.user.ICrmUserRepository
import com.zigzag.crm.usecase.api.user.Usecase_FindUserById
import com.zigzag.crm.usecase.api.user.dto.CrmUserDto
import com.zigzag.crm.usecase.feature.user.mapper.CrmUserMapper
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

@Component
class Usecase_FindUserById_Impl(
    private val userRepository: ICrmUserRepository,
    private val crmUserMapper: CrmUserMapper
): Usecase_FindUserById {

    override fun execute(userId: String): Mono<CrmUserDto.Response.Public> {
        val user = userRepository.findById(userId);
        return user.map{usr -> crmUserMapper.convertEntityToDto(usr)};
    }

}
