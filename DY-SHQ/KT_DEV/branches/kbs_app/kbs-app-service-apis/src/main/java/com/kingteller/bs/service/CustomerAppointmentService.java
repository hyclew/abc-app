package com.kingteller.bs.service;

import com.kingteller.bs.domain.appointment.CustomerAppointmentSessionDomain;
import com.kingteller.bs.domain.order.UserOrderAddress;
import com.kingteller.bs.framework.rest.RestResponse;

/**
 * 客户预约服务
 * @author wangyafei
 *
 */
public interface CustomerAppointmentService {

	/**
	 * 提交 
	 * @param customerAppointmentSessionDomain
	 * @return
	 */
	public RestResponse insertAppointment(
			CustomerAppointmentSessionDomain customerAppointmentSessionDomain);
	
	/**
	 * 插入一条收货人信息
	 * @param userOrderAddress
	 * @return
	 * @throws Exception
	 */
	public RestResponse insertUserAppointmentAddress(String sessionId, UserOrderAddress userOrderAddress) throws Exception;
	
	/**
	 * 查询用户预约地址信息
	 * @param sessionId
	 * @return
	 * @throws Exception
	 */
	public RestResponse getUserAppointmentAddresses(String sessionId) throws Exception;
	
	/**
	 * 查询用户预约信息
	 * @param sessionId
	 * @return
	 * @throws Exception
	 */
	public RestResponse getCustomerAppointments(String sessionId) throws Exception;
	
}
