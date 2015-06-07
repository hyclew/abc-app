package com.kingteller.bs.service.inner.appointment;

import java.util.List;

import com.kingteller.bs.domain.appointment.CustomerAppointment;

/**
 * 客户预约原子服务
 * @author wangyafei
 *
 */
public interface CustomerAppointmentAtomService {

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
