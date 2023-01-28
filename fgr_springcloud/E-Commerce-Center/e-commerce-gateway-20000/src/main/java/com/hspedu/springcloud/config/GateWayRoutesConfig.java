//package com.hspedu.springcloud.config;
//
//import org.springframework.cloud.gateway.route.RouteLocator;
//import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * @author: guorui fu
// * @versiion: 1.0
// * GateWayRoutesConfig 配置路由
// */
//@Configuration
//public class GateWayRoutesConfig {
//
//    //配置注入路由
//    /*
//    配置类注入 可以按照application.yml进行配置
//     */
//    @Bean
//    public RouteLocator myRouteLocator04(RouteLocatorBuilder routeLocatorBuilder){
//        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
//        /*
//        指定了id，uri，path，
//        Function<PredicateSpec, AsyncBuilder> fn
//        （1）函数式接口
//        （2）接收的类型是PredicateSpec 返回的类型是AsyncBuilder
//        lambda表达式
//         */
//        return routes.route("member_route04",r -> r.path("/member/get/**")
//                .uri("http://localhost:10000"))
//                .build();
//    }
//
//    @Bean
//    public RouteLocator myRouteLocator05(RouteLocatorBuilder routeLocatorBuilder){
//        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
//        return routes.route("member_route05",r -> r.path("/member/save")
//                .uri("http://localhost:10000"))
//                .build();
//    }
//}
