package com.zigzag.crm.framework.domain.api.features.common

interface Ownable<ID_TYPE> {
    var ownerId: ID_TYPE?
}
