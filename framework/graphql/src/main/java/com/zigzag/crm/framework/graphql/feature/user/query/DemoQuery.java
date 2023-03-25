package com.zigzag.crm.framework.graphql.feature.user.query;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class DemoQuery {
    @QueryMapping(name = "demo")
    String demo()  {
        return "Our query works";
    }
}
