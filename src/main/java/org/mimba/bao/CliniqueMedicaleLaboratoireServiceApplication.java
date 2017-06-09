package org.mimba.bao;

import org.mimba.bao.dao.IImagerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.EndpointMBeanExportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableDiscoveryClient
@EnableEurekaClient
@SpringBootApplication(exclude = EndpointMBeanExportAutoConfiguration.class)
public class CliniqueMedicaleLaboratoireServiceApplication implements CommandLineRunner {
	@Autowired 
	private IImagerieRepository iImagerieRepository; 
	public static void main(String[] args) {
		SpringApplication.run(CliniqueMedicaleLaboratoireServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
