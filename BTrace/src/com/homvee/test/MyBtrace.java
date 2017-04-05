package com.homvee.test;

import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.*;

import java.util.List;
import java.util.Map;

import static com.sun.btrace.BTraceUtils.*;

/**
 * @Package: com.homvee.test
 * @Description: TODO
 * @date:2016/3/22
 * @author: Hongwei.tang
 * @email: Hongwei.Tang@DMall.com
 * @Copyright: Copyright(c) 2016, DMall All Rights Reserved.
 */
@BTrace
public class MyBtrace {

    @OnMethod(clazz = "com.homvee.test.Application", method = "print", location = @Location(Kind.RETURN))
    public static void btraceFun(Map<String, Object> map, @Return String ret) {
        //  jstack();
        println(strcat(str(map), ret));
    }

    @OnMethod(clazz = "com.dmall.ws.service.impl.SmsServiceImpl", method = "sendMsg")
    public static void btraceTomcatFun(Long deltaTime, int maxNum, int pageSize, boolean repeatable, int minNum, List<Object> problemTypes) {
        jstack();
        println(strcat("deltaTime:", deltaTime + ""));
        println(strcat("maxNum:", maxNum + ""));
        println(strcat("pageSize:", pageSize + ""));
        println(strcat("repeatable:", repeatable + ""));
        println(strcat("minNum:", minNum + ""));
        println(strcat("problemTypes:", problemTypes + ""));
    }


    //@OnTimer(4000)
    public static void printMem() {
        println("Heap:");
        println(BTraceUtils.Sys.Memory.heapUsage());
        println("Non-Heap:");
        println(BTraceUtils.Sys.Memory.nonHeapUsage());
    }
}
