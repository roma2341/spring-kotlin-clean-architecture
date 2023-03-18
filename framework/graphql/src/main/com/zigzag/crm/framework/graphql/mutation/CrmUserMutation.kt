package com.zigzag.crm.module.graphql.mutation

import com.zigzag.crm.framework.domain.api.features.user.CrmUser
import com.zigzag.crm.framework.domain.api.repository.ICrmUserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Controller
class CrmUserMutation {
    @Autowired
    private lateinit var userRepository: ICrmUserRepository;

    fun newUser(user: CrmUserDto): Mono<CrmUser> {
        return userRepository.createUser(user);
    }
}
