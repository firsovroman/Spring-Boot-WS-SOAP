package com.example.ws.soap;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.example.ws.soap.entity.CountryRepository;
import org.apache.cxf.feature.Features;
import org.springframework.beans.factory.annotation.Autowired;

@WebService
@Features(features="org.apache.cxf.feature.LoggingFeature")
public class CountryWS {

    @Autowired
    private CountryRepository countryRepository;

	@WebMethod
	public GetCountryResponse getCountry(GetCountryRequest getCountryRequest) throws ServiceArgumentException {

		if(getCountryRequest.name == null || getCountryRequest.name.isEmpty()){
			Myfault myfault = new Myfault();
			myfault.setCode("100");
			myfault.setDescription("CountryName must nor be null");
			throw new ServiceArgumentException(myfault);
		}

		GetCountryResponse response = new GetCountryResponse();
		response.setCountry(countryRepository.findCountry(getCountryRequest.name));

		return response;
	}

}
