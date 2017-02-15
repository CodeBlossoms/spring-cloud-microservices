package com.ggk.sixt.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;
import com.netflix.loadbalancer.RoundRobinRule;

//@Configuration
public class RibbonClientConfig {
	
	  @Bean
	  public IPing ribbonPing(IClientConfig config) {
	    return new PingUrl();
	  }

	  @Bean
	  public IRule ribbonRule(IClientConfig config) {
	    return new RoundRobinRule();
	  }
}