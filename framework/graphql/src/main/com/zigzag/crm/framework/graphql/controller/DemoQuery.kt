package com.zigzag.crm.module.graphql.controller

import com.expediagroup.graphql.server.operations.Query
import org.springframework.stereotype.Controller

@Controller
class DemoQuery: Query {
    fun demo(): String {
        return "Our query works"
    }
}
