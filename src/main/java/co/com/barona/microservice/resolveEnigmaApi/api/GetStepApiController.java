package co.com.barona.microservice.resolveEnigmaApi.api;

import co.com.barona.microservice.resolveEnigmaApi.model.GetEnigmaRequest;
import co.com.barona.microservice.resolveEnigmaApi.model.GetEnigmaStepResponse;
import co.com.barona.microservice.resolveEnigmaApi.model.Header;
import co.com.barona.microservice.resolveEnigmaApi.model.JsonApiBodyRequest;
import co.com.barona.microservice.resolveEnigmaApi.model.JsonApiBodyResponseSuccess;
import io.swagger.annotations.*;

import org.apache.camel.EndpointInject;
import org.apache.camel.FluentProducerTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;



import javax.validation.Valid;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-02-27T21:16:02.967-05:00[America/Bogota]")
@Controller
public class GetStepApiController implements GetStepApi {
	
	//@EndpointInject(uri = "direct:get-step-one")
	//private FluentProducerTemplate fluentProducerTemplate;

public ResponseEntity<JsonApiBodyResponseSuccess> getStep(@ApiParam(value = "request body get enigma Step", required = true) @Valid @RequestBody JsonApiBodyRequest body) {
    	
    	
    	/*String accept = request.getHeader("Accept");
    	enigma.setAnswer("Step1: Open the regrigerator");
    	enigmas.add(enigma);
    	
    	response.setData(enigmas);
    	listResponse.add(response);
    	
    	return new ResponseEntity<>(listResponse, HttpStatus.NOT_IMPLEMENTED);*/
    	
	//fluentProducerTemplate.request();
    	GetEnigmaRequest enigmaRequest = body.getData().get(0);
        Header header = enigmaRequest.getHeader();
        String id = header.getId();
        String type = header.getType();
        String enigma = enigmaRequest.getEnigma();

        String solution = "Step1: Put the giraffe in .)";

        GetEnigmaStepResponse response = new GetEnigmaStepResponse();
        response.setId(id);
        response.setType(type);
        response.setSolution(solution);

        JsonApiBodyResponseSuccess responseBody = new JsonApiBodyResponseSuccess();
        responseBody.addDataItem(response);

        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    	
    }

		@GetMapping("/get")
			public ResponseEntity<String> answerEnigma(String enigmaQuestion) {
			return new ResponseEntity<String>("Step1: Open the regrigerator ", HttpStatus.OK);
		}


}
