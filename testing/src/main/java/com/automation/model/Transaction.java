package com.automation.model;

public class Transaction {
    
	public String locale;
	public String variant;
	public long Amount;
	public String CurrencyCode;
	public String CountryCode;
	public String MerchantCustomerId;
	
	public Transaction(String locale,String variant,long Amount, String CurrencyCode, String CountryCode, String MerchantCustomerId)
	{
		this.locale = locale;
		this.variant = variant;
		this.Amount = Amount;
		this.CurrencyCode = CurrencyCode;
		this.CountryCode = CountryCode;
		this.MerchantCustomerId = MerchantCustomerId;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public String getVariant() {
		return variant;
	}

	public void setVariant(String variant) {
		this.variant = variant;
	}

	public long getAmount() {
		return Amount;
	}

	public void setAmount(long amount) {
		Amount = amount;
	}

	public String getCurrencyCode() {
		return CurrencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		CurrencyCode = currencyCode;
	}

	public String getCountryCode() {
		return CountryCode;
	}

	public void setCountryCode(String countryCode) {
		CountryCode = countryCode;
	}

	public String getMerchantCustomerId() {
		return MerchantCustomerId;
	}

	public void setMerchantCustomerId(String merchantCustomerId) {
		MerchantCustomerId = merchantCustomerId;
	}
	
	
	
}
