package com.concretepage;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import com.concretepage.wsdl.CountryIntPhoneCode;
import com.concretepage.wsdl.CountryIntPhoneCodeResponse;
import com.concretepage.wsdl.FullCountryInfo;
import com.concretepage.wsdl.FullCountryInfoResponse;

public class CountryInformationClient extends WebServiceGatewaySupport  {
	
	public CountryIntPhoneCodeResponse getPhoneCodeOfCountry(String countryISOCode) {
		
		
		CountryIntPhoneCode countryPhoneCode = new CountryIntPhoneCode();
		countryPhoneCode.setSCountryISOCode(countryISOCode);
		
		CountryIntPhoneCodeResponse cpr = (CountryIntPhoneCodeResponse) getWebServiceTemplate().marshalSendAndReceive(countryPhoneCode);
		return cpr;
	}
	
	public FullCountryInfoResponse getFullCountryInfo(String countryISOCode) {
		
		FullCountryInfo countryInfo = new FullCountryInfo();
		countryInfo.setSCountryISOCode(countryISOCode);
		
		FullCountryInfoResponse countryInfoResponse = (FullCountryInfoResponse) getWebServiceTemplate().marshalSendAndReceive(countryInfo);
		
		return countryInfoResponse;
	}
		
}
