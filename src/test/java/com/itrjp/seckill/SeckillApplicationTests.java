package com.itrjp.seckill;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SeckillApplicationTests {

    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;

    @Before
    public void setupMck() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void contextLoads() throws Exception {
        System.out.println("start:" + System.currentTimeMillis());
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {

                try {
                    mockMvc
                            .perform(MockMvcRequestBuilders.get("/demo"))
                            .andExpect(MockMvcResultMatchers.status().isOk());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }

        System.out.println("end:" + System.currentTimeMillis());
        Thread.sleep(20000);

    }

}

