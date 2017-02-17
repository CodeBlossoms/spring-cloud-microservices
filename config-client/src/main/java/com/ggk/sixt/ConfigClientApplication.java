package com.ggk.sixt;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
public class ConfigClientApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ConfigClientApplication.class, args);
	}
}


@RefreshScope
@RestController
@Component
class Greeter {


    @Value("${server.port}")
    int port = 1000;

    @Value("${configuration.projectName}")
    String projectName = "default";

    @RequestMapping(value = "/", produces = "application/json")
    public List<String> index(){
        List<String> env = Arrays.asList(
                "server.port is: " + port,
                "configuration.projectName is: " + projectName
        );
        return env;
    }
}