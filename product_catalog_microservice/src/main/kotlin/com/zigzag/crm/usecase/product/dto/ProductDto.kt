package com.zigzag.crm.usecase.lead.dto

enum class ProductDto{;
    private interface Id { var id: String? }
    private interface Name { var name: String? }

    enum class Request{;
        public data class Create( override var name: String? = null): Name;
    }
    enum class Response {;
        data class Public(
            override var id: String? = null,
            override var name: String? = null
        ): Id,
            Name;
    }
}

