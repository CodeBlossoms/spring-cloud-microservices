package com.ggk.sixt.feignClients;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.ggk.sixt.domainService.UserService;

@FeignClient("user-service")
public interface UserServiceFeignClient extends UserService {

}
