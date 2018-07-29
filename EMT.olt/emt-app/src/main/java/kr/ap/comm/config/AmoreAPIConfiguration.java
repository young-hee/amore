package kr.ap.comm.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import kr.ap.comm.api.APIServiceUtils;
import kr.ap.comm.api.AmoreAPIService;

@Configuration
public class AmoreAPIConfiguration {

    @Value("${amore.api.base-url}")
    private String baseUrl;
	
	@Bean
	public AmoreAPIService amoreAPIService() {
	 	AmoreAPIService service = APIServiceUtils.createClientProxy(APIServiceUtils.class.getClassLoader()
			, AmoreAPIService.class, baseUrl, false);
	 	return service;
	}

	
}
