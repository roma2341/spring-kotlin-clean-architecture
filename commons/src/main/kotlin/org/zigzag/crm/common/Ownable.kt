package org.zigzag.crm.common

interface Ownable<ID_TYPE> {
    var ownerId: ID_TYPE?
}
