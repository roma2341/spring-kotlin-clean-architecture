package com.zigzag.crm.usecase.lead.dto

import com.zigzag.crm.framework.domain.api.features.lead.enums.LeadStep

enum class LeadDto{;
    private interface Id { var id: String? }
    private interface FirstName { var firstName: String? }
    private interface LastName { var lastName: String? }
    private interface Email{ var email: String? }
    private interface ILeadFunnelStatus{var leadStep: LeadStep?}

    enum class Request{;
        public data class Create(
                              override var firstName: String? = null,
                              override var lastName: String? = null,
                              override var email: String? = null): FirstName,
            LastName,
            Email;
    }
    enum class Response {;
        data class Public(
            override var id: String? = null,
            override var firstName: String? = null,
            override var lastName: String? = null,
            override var email: String? = null,
            override var leadStep: LeadStep? = null
        ): Id,
            FirstName,
            LastName,
            Email,
            ILeadFunnelStatus
    }
}

