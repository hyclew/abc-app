package com.kingteller.bs.rest;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kingteller.bs.domain.Greeting;
import com.kingteller.bs.service.TopContactService;

@RestController
public class TopContactController {
	
	@Autowired
	TopContactService topContactService;
	
	private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/topcontact")
    public Greeting greeting(@RequestParam(value="name", 
    	required=false, defaultValue="World") String name) {
    	String sessionId="";
    	Long orgMemberId=0L;
    	Long orgId=0L;
    	topContactService.addTopContact(sessionId, orgMemberId, orgId);
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
}
