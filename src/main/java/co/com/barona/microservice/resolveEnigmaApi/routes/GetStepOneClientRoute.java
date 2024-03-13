package co.com.barona.microservice.resolveEnigmaApi.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;
import org.apache.camel.Exchange;

@Component
public class GetStepOneClientRoute extends RouteBuilder{

	@Override
	public void configure()throws Exception{
		from("direct:get-step-one")
		.setHeader(Exchange.HTTP_METHOD, constant("POST"))
		.setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
		.to("freemarker:templates/GetStepTemplate.ftl")
		.log("request microservice step one")
		.to("http://localhost:8081/v1/getOneEnigma/getStep")
		.log("response ${body}");
	}
	
}
