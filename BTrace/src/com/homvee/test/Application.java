package com.homvee.test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Package: PACKAGE_NAME
 * @Description: TODO
 * @date:2016/3/22
 * @author: Hongwei.tang
 * @email: Hongwei.Tang@DMall.com
 * @Copyright: Copyright(c) 2016, DMall All Rights Reserved.
 */
public class Application {
    public static void main(String[] args) throws InterruptedException {

        while (true) {
            Map<String, Object> map = new HashMap<>();
            Application application = new Application();
            map.put("asasasas", 90783487343478L);
            map.put("Application", application);
            application.print(map);
            Thread.sleep(2000);
        }
    }

    public String print(Map<String, Object> map) {
        return map.toString();
    }
}
