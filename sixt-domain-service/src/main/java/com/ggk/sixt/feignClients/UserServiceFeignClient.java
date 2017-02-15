package com.ggk.sixt.feignClients;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import com.ggk.sixt.configs.RibbonClientConfig;
import com.ggk.sixt.domainService.UserService;

@FeignClient(name = "user-service"/*, configuration = RibbonClientConfig.class*/)
public interface UserServiceFeignClient extends UserService {

}
