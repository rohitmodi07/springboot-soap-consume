package com.concretepage;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.concretepage.wsdl.CountryIntPhoneCodeResponse;
import com.concretepage.wsdl.FullCountryInfoResponse;
import com.concretepage.wsdl.TCountryInfo;

@SpringBootApplication
public class MySpringApplicationClient {  
	public static void main(String[] args) {
		SpringApplication.run(MySpringApplicationClient.class, args);
    }       
	@Bean
	CommandLineRunner lookup(CountryInformationClient countryInfoClient) {
		return args -> {
			System.out.println("--- Get Country Code by ISOCode ---");
			CountryIntPhoneCodeResponse countryPhoneCodeResponse = countryInfoClient.getPhoneCodeOfCountry("IN");
			System.out.println("Response is :::::: "+countryPhoneCodeResponse.getCountryIntPhoneCodeResult());
			
			System.out.println("--- Get Country information by ISOCode ---");
			FullCountryInfoResponse fullCountryResponse = countryInfoClient.getFullCountryInfo("IN");
			TCountryInfo countryInfo = fullCountryResponse.getFullCountryInfoResult();
			System.out.println("---The country info is-----");
			System.out.println("---country ISO Code   ----- "+countryInfo.getSCurrencyISOCode());
			System.out.println("---country capital    ----- "+countryInfo.getSCapitalCity());
			System.out.println("---country continent  ----- "+countryInfo.getSContinentCode());
			System.out.println("---country name       ----- "+countryInfo.getSName());
			System.out.println("---country phone code ----- "+countryInfo.getSPhoneCode());
			
		};
	}	
}            