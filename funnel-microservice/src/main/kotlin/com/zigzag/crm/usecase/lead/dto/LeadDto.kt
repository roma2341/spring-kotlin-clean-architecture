package com.zigzag.crm.usecase.lead.dto

import com.zigzag.crm.framework.domain.api.features.lead.enums.LeadFunnelStatus

enum class LeadDto{;
    private interface Id { var id: String? }
    private interface FirstName { var firstName: String? }
    private interface LastName { var lastName: String? }
    private interface Email{ var email: String? }
    private interface ILeadFunnelStatus{var leadFunnelStatus: LeadFunnelStatus?}

    enum class Request{;
        public data class Create(
                              override var firstName: String? = null,
                              override var lastName: String? = null,
                              override var email: String? = null): FirstName,
            LastName,
            Email;
        public data class Search(
            override var firstName: String?,
            override var lastName: String?
        ): FirstName,
            LastName
    }
    enum class Response {;
        data class Public(
            override var id: String? = null,
            override var firstName: String? = null,
            override var lastName: String? = null,
            override var email: String? = null,
            override var leadFunnelStatus: LeadFunnelStatus? = null
        ): Id,
            FirstName,
            LastName,
            Email,
            ILeadFunnelStatus
    }
}

