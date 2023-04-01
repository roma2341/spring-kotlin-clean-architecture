package com.zigzag.crm.usecase.feature.lead.dto

import com.zigzag.crm.framework.domain.api.features.lead.enums.LeadFunnelStatus

enum class LeadDto{;
    private interface Id { val id: String? }
    private interface FirstName { val firstName: String? }
    private interface LastName { val lastName: String? }
    private interface Email{ val email: String? }
    private interface ILeadFunnelStatus{val leadFunnelStatus: LeadFunnelStatus}

    enum class Request{;
        public data class Create(
                              override val firstName: String?,
                              override val lastName: String?,
                              override val email: String?): FirstName, LastName, Email;
    }
    enum class Response {;
        data class Public(
            override val id: String?,
            override val firstName: String?,
            override val lastName: String?,
            override val email: String?,
            override val leadFunnelStatus: LeadFunnelStatus
        ): Id, FirstName, LastName, Email, ILeadFunnelStatus
    }
}

