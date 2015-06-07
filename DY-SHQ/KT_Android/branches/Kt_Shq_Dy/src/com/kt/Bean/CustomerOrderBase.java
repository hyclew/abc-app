package com.kt.Bean;

public class CustomerOrderBase {
	public String isInvoice;
	public String isClub;
	public String invoiceTitle;
	public String getIsInvoice() {
		return isInvoice;
	}
	public void setIsInvoice(String isInvoice) {
		this.isInvoice = isInvoice;
	}
	public String getIsClub() {
		return isClub;
	}
	public void setIsClub(String isClub) {
		this.isClub = isClub;
	}
	public String getInvoiceTitle() {
		return invoiceTitle;
	}
	public void setInvoiceTitle(String invoiceTitle) {
		this.invoiceTitle = invoiceTitle;
	}
	@Override
	public String toString() {
		return "CustomerOrderBase [isInvoice=" + isInvoice + ", isClub="
				+ isClub + ", invoiceTitle=" + invoiceTitle
				+ ", getIsInvoice()=" + getIsInvoice() + ", getIsClub()="
				+ getIsClub() + ", getInvoiceTitle()=" + getInvoiceTitle()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
}
