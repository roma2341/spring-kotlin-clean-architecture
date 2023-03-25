package com.zigzag.crm.usecase.api.product.dto

import com.zigzag.crm.usecase.api.user.dto.CrmUserDto

enum class CrmProductDto {;
    private interface Id { val id: String? }
    private interface Description { val description: String? }
    private interface Name { val name: String? }

    enum class Request {;
        public data class Create(
            override val description: String?,
            override val name: String?): Description, Name;
    }
}
