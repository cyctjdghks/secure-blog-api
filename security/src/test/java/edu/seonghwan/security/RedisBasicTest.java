package edu.seonghwan.security;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class RedisBasicTest {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    private static final String TEST_KEY = "myKey";

    @Test
    void redis연결_및_값_저장_조회_테스트() {
        // 저장
        redisTemplate.opsForValue().set(TEST_KEY, "hello-redis");

        // 조회
        String value = redisTemplate.opsForValue().get(TEST_KEY);
        System.out.println("Redis에서 읽은 값 = " + value);

        // 검증
        assertThat(value).isEqualTo("hello-redis");
    }

    @AfterEach
    void tearDown() {
        redisTemplate.delete(TEST_KEY);
    }
}