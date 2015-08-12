//package com.existmaster.test;
//
//import com.existmaster.spring.Application;
//import com.existmaster.spring.model.User;
//import com.existmaster.spring.repository.UserRepository;
//import com.jayway.restassured.RestAssured;
//import com.jayway.restassured.http.ContentType;
//import org.apache.http.HttpStatus;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.test.IntegrationTest;
//import org.springframework.boot.test.SpringApplicationConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//
//import java.util.Arrays;
//
//import static com.jayway.restassured.RestAssured.when;
//import static org.hamcrest.Matchers.equalTo;
//
///**
// * Created by existmaster on 2015. 6. 18..
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = Application.class)
//@WebAppConfiguration
////For server port Integration
//@IntegrationTest("server.port:0")
//public class JUnitTest {
//
//    @Autowired
//    UserRepository userRepository;
//
//    User user1;
//    User user2;
//    User user3;
//
//    @Value("${local.server.port}")
//    int port;
//
//    @Before
//    public void setUp() {
//        user1 = new User("existmaster", "1234", "남", "성열", "existmaster@pineone.com");
//        user2 = new User("existmaster2", "1234", "여", "안열", "existmaster2@pineone.com");
//        user3 = new User("abc", "3355", "중성", "바부", "eleiiw@pineone.com");
//
//        userRepository.deleteAll();
//        userRepository.save(Arrays.asList(user1, user2, user3));
//
//        RestAssured.port = port;
//    }
//
//    @Test
//    public void canSaveUser() {
//        User user4 = new User("test", "1111", "중성", "바부", "1234@pineone.com");
//
//        when().
//                get("user/add?userId={userId}&password={password}&sex={sex}&nickname={nickname}&email={email}",
//                        user4.getUserId(), user4.getPassword(), user4.getSex(), user4.getNickname(), user4.getEmail()).
//                then().
//                contentType(ContentType.JSON).
//                statusCode(HttpStatus.SC_OK).
//                body("userId", equalTo(user4.getUserId()));
//    }
//
//    @Test
//    public void canFetchUser1() {
//        String user1Id = user1.getUserId();
//
//        when().
//                get("user/search/{userId}", user1Id).
//                then().
//                contentType(ContentType.JSON).
//                statusCode(HttpStatus.SC_OK).
//                body("userId", equalTo(user1Id));
//    }
//
//
//}
