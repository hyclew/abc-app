package com.kingteller.bs.dao.appointment;

import java.util.List;

import org.springframework.stereotype.Component;

import com.kingteller.bs.dao.mysql.MyBatisDao;
import com.kingteller.bs.domain.appointment.CustomerAppointment;

@Component("CustomerAppointmentDao")
public class CustomerAppointmentDaoImpl extends MyBatisDao implements CustomerAppointmentDao{

	private static final String NAMESPACE = "CustomerAppointment";
	
	@Override
	public CustomerAppointment insertCustomerAppointment(
			CustomerAppointment customerAppointment) throws Exception{
		this.getSqlSession().insert(NAMESPACE + ".insertCustomerAppointment", customerAppointment);
		return customerAppointment;
	}

	@Override
	public List<CustomerAppointment> queryCustomerAppointmentByUserId(
			CustomerAppointment customerAppointment) throws Exception {
		return this.getSqlSession().selectList(NAMESPACE + ".queryCustomerAppointmentByUserId", customerAppointment);
	}

}
