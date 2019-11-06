package cn.ibm.com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Value;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


public class SwaggerConfig {

	@Value(value = "${swagger.enabled}")
	Boolean swaggerEnabled;

	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).enable(swaggerEnabled).select()
				.apis(RequestHandlerSelectors.basePackage("cn.ibm.com")).paths(PathSelectors.any()).build()
				.pathMapping("/");
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("SBA Course Management：Swagger2 API Document").description("SBA")
				.contact(new Contact("SBA", "", "")).version("1.0.0").build();
	}
}
