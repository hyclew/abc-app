package com.kingteller.bs.dao.appointment;

import java.util.List;

import com.kingteller.bs.domain.appointment.CustomerAppointment;


/**
 * 客户预约服务DAO
 * @author wangyafei
 *
 */
public interface CustomerAppointmentDao {

	/**
	 * 插入客户预约信息
	 * @param customerAppointment
	 * @return
	 */
	public CustomerAppointment insertCustomerAppointment(CustomerAppointment customerAppointment) throws Exception;
	
	/**
	 * 根据用户ID查询此用户的所有预约信息
	 * @param customerAppointment
	 * @return
	 * @throws Exception
	 */
	public List<CustomerAppointment> queryCustomerAppointmentByUserId(CustomerAppointment customerAppointment) throws Exception;
}
