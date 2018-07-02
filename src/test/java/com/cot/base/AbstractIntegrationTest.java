package com.cot.base;

import ai.grakn.redismock.RedisServer;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public abstract class AbstractIntegrationTest {

    private RedisServer redisServer;
    @Value("${spring.redis.port}")
    private int redisPort;

    @Before
    public void setup() throws IOException {

        this.redisServer = new RedisServer(redisPort);
        this.redisServer.start();
    }

    @After
    public void dedstroy() {
        this.redisServer.stop();
    }
}