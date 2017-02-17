package com.ggk.sixt.feignClients;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import com.ggk.sixt.configs.FeignClientConfig;
import com.ggk.sixt.domainService.UserService;

@FeignClient(name = "user-service" /*, configuration = FeignClientConfig.class*/)
public interface UserServiceFeignClient extends UserService {

}
