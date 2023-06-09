package com.zigzag.crm.framework.schedulers.lead

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class Scheduler_AssignLeadToAgent {
    @Autowired
    val Usecase_AssignLeadToAgent usecase_AssignLeadToAgent;
    @Scheduled(fixedDelay = 1000)
    fun trigger(): Void {

    }
}
