package com.triadic.nexgeno.test;

import com.triadic.configs.Global;
import com.triadic.nexgeno.services.GeoLocationFinderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by psramkumar on 10/5/2014.
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Global.SpringAppConfig.class)
public class SpringServiceUnitTest {

    @Autowired
    private GeoLocationFinderService geoLocationFinderService;

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
        try {
            System.out.println("geoLocationFinderService = " + geoLocationFinderService.getLocationForGivenAddress(map));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testMenuPro(){

    }
}
