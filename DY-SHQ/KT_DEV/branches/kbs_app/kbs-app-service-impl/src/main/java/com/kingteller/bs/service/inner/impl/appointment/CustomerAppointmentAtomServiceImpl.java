package com.kingteller.bs.service.inner.impl.appointment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kingteller.bs.dao.appointment.CustomerAppointmentDao;
import com.kingteller.bs.domain.appointment.CustomerAppointment;
import com.kingteller.bs.service.inner.appointment.CustomerAppointmentAtomService;

@Component("customerAppointmentAtomService")
public class CustomerAppointmentAtomServiceImpl implements
		CustomerAppointmentAtomService {

	@Autowired
	private CustomerAppointmentDao customerAppointmentDao;
	
	@Override
	public CustomerAppointment insertCustomerAppointment(
			CustomerAppointment customerAppointment) throws Exception {
		return this.customerAppointmentDao.insertCustomerAppointment(customerAppointment);
	}

	@Override
	public List<CustomerAppointment> queryCustomerAppointmentByUserId(
			CustomerAppointment customerAppointment) throws Exception {
		return this.customerAppointmentDao.queryCustomerAppointmentByUserId(customerAppointment);
	}

}
