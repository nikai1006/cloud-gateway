package cn.net.nikai.cloud.cloudgateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteLocatorConfig {

    @Bean
    public RouteLocator customRouteLocator(ThrottleWebFilterFactory throttle) {
        return Routes.locator()
            .route("test")
            .uri("http://httpbin.org:80")
            .predicate(host("**.abc.org").and(path("/image/png")))
            .addResponseHeader("X-TestHeader", "foobar")
            .and()
            .route("test2")
            .uri("http://httpbin.org:80")
            .predicate(path("/image/webp"))
            .add(addResponseHeader("X-AnotherHeader", "baz"))
            .and()
            .build();
    }

}
