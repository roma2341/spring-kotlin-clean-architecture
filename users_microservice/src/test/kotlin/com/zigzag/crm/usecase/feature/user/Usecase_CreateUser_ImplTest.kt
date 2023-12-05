package com.zigzag.crm.usecase.feature.user

import com.zigzag.crm.framework.domain.api.features.user.CrmUser
import com.zigzag.crm.framework.domain.api.features.user.ICrmUserRepository
import com.zigzag.crm.usecase.feature.user.dto.CrmUserDto
import com.zigzag.crm.usecase.feature.user.impl.Usecase_CreateUser_Impl
import com.zigzag.crm.usecase.feature.user.mapper.CrmUserMapper
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension
import reactor.core.publisher.Mono

@ExtendWith(MockitoExtension::class)
class Usecase_CreateUser_ImplTest {

    @Mock
    private lateinit var userRepository: ICrmUserRepository

    @Mock
    private lateinit var crmUserMapper: CrmUserMapper

    @InjectMocks
    private lateinit var usecaseCreateUser: Usecase_CreateUser_Impl

    @Test
    fun `should create a new user`() {
        // given
        val userDto = CrmUserDto.Request.Create(firstName = "John",lastName = "Smith", email = "john@example.com")
        val userEntity = CrmUser(firstName = "John",lastName = "Smith", email = "john@example.com")
        val persistedEntity = Mono.just(userEntity)
        `when`(crmUserMapper.convertDtoToEntity(userDto)).thenReturn(userEntity)
        `when`(userRepository.createUser(userEntity)).thenReturn(persistedEntity)
        val expectedResponse = CrmUserDto.Response.Public(firstName = "John",lastName = "Smith", email = "john@example.com")
        `when`(crmUserMapper.convertEntityToDto(userEntity)).thenReturn(expectedResponse)

        // when
        val result = usecaseCreateUser.execute(userDto).block()

        // then
        assertThat(result, equalTo(expectedResponse));
    }

    @Test
    fun `should throw an error when userRepository-createUser() returns an error`() {
        // given
        val userDto = CrmUserDto.Request.Create(firstName = "John",lastName = "Smith", email = "john@example.com")
        val userEntity = CrmUser(firstName = "John",lastName = "Smith", email = "john@example.com")
        val error = RuntimeException("Error creating user")
        `when`(crmUserMapper.convertDtoToEntity(userDto)).thenReturn(userEntity)
        `when`(userRepository.createUser(userEntity)).thenReturn(Mono.error(error))

        // when
        val result = assertThrows<Exception> { usecaseCreateUser.execute(userDto).block() }

        // then
        assertThat(result.message, equalTo("Error creating user"))
    }
}
