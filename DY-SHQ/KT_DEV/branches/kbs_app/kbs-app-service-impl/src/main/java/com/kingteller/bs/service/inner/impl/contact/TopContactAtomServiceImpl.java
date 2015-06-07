package com.kingteller.bs.service.inner.impl.contact;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kingteller.bs.dao.TopContactDao;
import com.kingteller.bs.domain.TopContact;
import com.kingteller.bs.service.inner.contact.TopContactAtomService;

@Component("topContactAtomService")
public class TopContactAtomServiceImpl implements TopContactAtomService {
	@Autowired
	TopContactDao topContactsDao;

	@Override
	public void addTopContact(String sessionId, Long orgMemberId,
			Long orgId) {
		TopContact topContact=topContactsDao.queryByOrgIdMemberIdOwnerUserId(1240L,
				462986L, 176061L);	
	}

	@Override
	public void deleteTopContact(String sessionId, Long orgMemberId,
			Long orgId) {
		TopContact topContact=topContactsDao.queryByOrgIdMemberIdOwnerUserId(1240L,
				462986L, 176061L);
	}

	@Override
	public List<TopContact> queryTopContactList(String sessionId) {
		TopContact topContact=topContactsDao.queryByOrgIdMemberIdOwnerUserId(1240L,
				462986L, 176061L);
		return null;
	}
}
