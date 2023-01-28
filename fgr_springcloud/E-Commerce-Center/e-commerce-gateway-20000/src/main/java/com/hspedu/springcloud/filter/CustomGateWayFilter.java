//package com.hspedu.springcloud.filter;
//
//import org.springframework.boot.web.servlet.filter.OrderedFilter;
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.cloud.gateway.filter.GlobalFilter;
//import org.springframework.core.Ordered;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Component;
//import org.springframework.util.MultiValueMap;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;
//
///**
// * @author: guorui fu
// * @versiion: 1.0
// */
//@Component
//public class CustomGateWayFilter implements GlobalFilter, Ordered {
//
//    //filter是核心的方法，将我们的过滤业务，写在该方法中
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        System.out.println("CustomGateWayFilter被执行");
//        //先获取到对应的所有的参数值  getFirst()得到参数集合的第一个值
//        String user = exchange.getRequest().getQueryParams().getFirst("user");
//        String pwd = exchange.getRequest().getQueryParams().getFirst("pwd");
//        if (!("fgr".equals(user) && "123456".equals(pwd))){//如果不满足
//            System.out.println("非法用户==");
//            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);//回应不接受4
//            return exchange.getResponse().setComplete();
//        }
//        System.out.println("验证通过==");
//        return chain.filter(exchange);
//    }
//
//    //order 表示过滤器执行顺序，小的优先
//    @Override
//    public int getOrder() {
//        return 1;
//    }
//}
