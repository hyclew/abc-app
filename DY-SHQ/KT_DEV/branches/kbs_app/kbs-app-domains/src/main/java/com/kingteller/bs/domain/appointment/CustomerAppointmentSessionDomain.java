package com.kingteller.bs.domain.appointment;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class CustomerAppointmentSessionDomain {

	private String sessionId;
	
	private CustomerAppointment customerAppointment;

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public CustomerAppointment getCustomerAppointment() {
		return customerAppointment;
	}

	public void setCustomerAppointment(CustomerAppointment customerAppointment) {
		this.customerAppointment = customerAppointment;
	}

	@Override
	public String toString() {
		return "CustomerAppointmentSessionDomain [sessionId=" + sessionId
				+ ", customerAppointment=" + customerAppointment + "]";
	}
	
}
