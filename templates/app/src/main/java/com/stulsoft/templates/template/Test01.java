package com.stulsoft.templates.template;

import com.stulsoft.templates.data.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.RestTemplate;

public class Test01 {
    public static void main(String[] args) {
        test1();
        test2();
    }

    private static void test1() {
        System.out.println("==>test1");
        test1Runner("http://localhost:8080/user");
        test1Runner("http://localhost:8080/user2");
        test1Runner("http://localhost:8080/userError");
        test1Runner("http://localhost:8080/userError2");
    }

    private static void test1Runner(String url){
        System.out.printf("url: %s%n", url);
        var restTemplate = new RestTemplate();
        try {
            var user = restTemplate.getForObject(url, User.class);
            System.out.println(user);
        } catch (Exception exception) {
            System.out.printf("Error: %s%n", exception.getMessage());
        }

    }

    private static void test2() {
        System.out.println("==>test2");
        test2Runner("http://localhost:8080/user");
        test2Runner("http://localhost:8080/user2");
        test2Runner("http://localhost:8080/userError");
        test2Runner("http://localhost:8080/userError2");
    }

    private static void test2Runner(String url) {
        System.out.printf("url: %s%n", url);
        var restTemplate = new RestTemplate();
        try {
            var responseEntity = restTemplate.getForEntity(url, User.class);
            if (responseEntity.getStatusCode() == HttpStatus.OK){
                var user = responseEntity.getBody();
                System.out.println(user);
            }else {
                System.out.printf("Status code=%s, status: %s%n",
                        responseEntity.getStatusCode(),
                        responseEntity.getStatusCode().getReasonPhrase());
            }
        } catch (Exception exception) {
            System.out.printf("Error: %s%n", exception.getMessage());
        }
    }
}
