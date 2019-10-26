package cn.ibm.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class SbaGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbaGatewayApplication.class, args);
	}

}
