package com.hspedu.springcloud;

import java.time.ZonedDateTime;
import java.util.function.Function;

/**
 * @author: guorui fu
 * @versiion: 1.0
 */
public class T1 {
    public static void main(String[] args) {
        //第一种形式
//        Dog dog = hi("小猫", (String str) -> {
//            Cat cat = new Cat();
//            cat.setName(str);
//            return cat;
//        });
//        //第二种形式
//        Dog dog = hi("小猫", str -> {
//            Cat cat = new Cat();
//            cat.setName(str);
//            return cat;
//        });
        //第三种形式 简写
//        Dog dog = hi("小猫", str -> {
//            return new Cat(str);
//        });

        //第四种形式 简写
        Dog dog = hi("小白猫", str ->
             new Cat(str)
        );
        System.out.println(dog);

        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now);
    }

    /*
    public RouteLocator myRouteLocator04(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
    routes.route("member_route04",r -> r.path("/member/get/**")
    .uri("http://localhost:10000"))
    .build();
    route(String id, Function<PredicateSpec, AsyncBuilder> fn)
     */
    //模拟把Cat -> Dog
    public static Dog hi(String str, Function<String,Cat> fn){
        Cat cat = fn.apply(str);
        Dog dog = new Dog();

        dog.setName(cat.getName() + "~变化了小狗的名");
        return dog;
    }
}

class Dog{
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Cat{
    private String name;

    public Cat() {
    }

    public Cat(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Fgr{
}
