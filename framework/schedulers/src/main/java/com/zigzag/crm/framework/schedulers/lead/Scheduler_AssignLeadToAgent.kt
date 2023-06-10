package com.zigzag.crm.framework.schedulers.lead

import com.zigzag.crm.usecase.feature.lead.api.Usecase_AssignLeadToAgent
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class Scheduler_AssignLeadToAgent(val usecase_AssignLeadToAgent: Usecase_AssignLeadToAgent) {

    /*@Scheduled(fixedDelay = 1000)
    fun trigger(): Void {

    }*/
}
