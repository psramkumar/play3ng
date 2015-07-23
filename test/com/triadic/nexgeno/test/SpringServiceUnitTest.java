package com.triadic.nexgeno.test;

import com.triadic.configs.SpringAppConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by psramkumar on 10/5/2014.
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringAppConfig.class)
public class SpringServiceUnitTest {


    @Test
    public void testGeoLocationInfoService(){
        Map<String, String> map = new HashMap<String, String>(){{
            put("street", "7575 Frankford Rd");
            put("street2", "no");
            put("city", "Dallas");
            put("state", "Texas");
            put("zipCode", "75252");
            put("country", "USA");
        }};

    }

    @Test
    public void testMenuPro(){

    }
}
