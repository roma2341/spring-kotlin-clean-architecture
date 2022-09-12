package com.zigzag.crm.usecase.feature.user

import com.zigzag.crm.framework.domain.api.repository.ICrmUserRepository
import com.zigzag.crm.usecase.api.user.IUsecase_FindUserById
import com.zigzag.crm.usecase.api.user.dto.CrmUserDto
import com.zigzag.crm.usecase.feature.user.mapper.CrmUserMapper
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

@Component
class Usecase_FindUserById(
    private val userRepository: ICrmUserRepository,
    private val crmUserMapper: CrmUserMapper
): IUsecase_FindUserById {

    override fun execute(userId: Long): Mono<CrmUserDto.Response.Public> {
        val user = userRepository.findById(userId);
        return user.map{usr -> crmUserMapper.convertDomainModeltoResponsePublicDto(usr)};
    }

}
