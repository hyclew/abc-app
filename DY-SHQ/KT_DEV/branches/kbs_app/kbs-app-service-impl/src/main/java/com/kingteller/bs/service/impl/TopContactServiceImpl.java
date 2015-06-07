package com.kingteller.bs.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kingteller.bs.domain.TopContact;
import com.kingteller.bs.service.TopContactService;
import com.kingteller.bs.service.inner.contact.TopContactAtomService;

@Component("topContactService")
public class TopContactServiceImpl implements TopContactService {
	
	@SuppressWarnings("unused")
	private static final Logger log = Logger.getLogger(TopContactServiceImpl.class);
	@Autowired
	TopContactAtomService topContactAtomService;

	@Override
	public void addTopContact(String sessionId, Long orgMemberId,
			Long orgId) {
		topContactAtomService.addTopContact(sessionId,orgMemberId, orgId);	
	}

	@Override
	public void deleteTopContact(String sessionId, Long orgMemberId,
			Long orgId) {
		topContactAtomService.deleteTopContact(sessionId,orgMemberId, orgId);
	}

	@Override
	public List<TopContact> queryTopContactList(String sessionId) {
		return topContactAtomService.queryTopContactList(sessionId);
	}

	@Override
	public void submitTopContactList(String sessionId,
			List<String> mobileList) {
		
	}
	
}
