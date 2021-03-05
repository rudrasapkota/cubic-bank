package com.rab3tech.vo;

public class FundTransferVO {
	private String sfromAccount;
 	private String stoAccount;
	private String fromAccount;
	private String toAccount;
	private String remarks;
	private double amount;
	private int otp;
	
	public String getSfromAccount() {
 		return sfromAccount;
 	}

 	public void setSfromAccount(String sfromAccount) {
 		this.sfromAccount = sfromAccount;
 	}

 	public String getStoAccount() {
 		return stoAccount;
 	}

 	public void setStoAccount(String stoAccount) {
 		this.stoAccount = stoAccount;
 	}

	public int getOtp() {
		return otp;
	}

	public void setOtp(int otp) {
		this.otp = otp;
	}

	public String getFromAccount() {
		return fromAccount;
	}

	public void setFromAccount(String fromAccount) {
		this.fromAccount = fromAccount;
	}

	public String getToAccount() {
		return toAccount;
	}

	public void setToAccount(String toAccount) {
		this.toAccount = toAccount;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "FundTransferVO [fromAccount=" + fromAccount + ", toAccount=" + toAccount + ", remarks=" + remarks
				+ ", amount=" + amount + "]";
	}

}
