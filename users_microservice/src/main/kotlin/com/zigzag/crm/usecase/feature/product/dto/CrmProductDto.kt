package com.zigzag.crm.usecase.feature.product.dto

enum class CrmProductDto {;
    private interface Id { val id: String? }
    private interface Description { val description: String? }
    private interface Name { val name: String? }

    enum class Request {;
        public data class Create(
            override val description: String?,
            override val name: String?): com.zigzag.crm.usecase.feature.product.dto.CrmProductDto.Description,
            com.zigzag.crm.usecase.feature.product.dto.CrmProductDto.Name;
    }
}
