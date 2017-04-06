package com.homvee.thrift;

import org.apache.thrift.TException;

import java.util.*;

/**
 * @Package: com.dmall.presale.mail.service
 * @Description: TODO
 * @date:2016/3/4
 * @author: Hongwei.tang
 * @email: Hongwei.Tang@DMall.com
 * @Copyright: Copyright(c) 2016, DMall All Rights Reserved.
 */
public class ThriftServiceImpl implements ThriftService.Iface {

    public boolean testBoolean(boolean para) throws TException {
        System.out.println(para);
        return para;
    }

    public byte testByte(byte para) throws TException {
        System.out.println(para);
        return para;
    }

    public short testShort(short para) throws TException {
        System.out.println(para);
        return para;
    }

    public int testInt(int para) throws TException {
        System.out.println(para);
        return para;
    }

    public long testLong(long para) throws TException {
        System.out.println(para);
        return para;
    }

    public double testDouble(double para) throws TException {
        System.out.println(para);
        return para;
    }

    public String testString(String para) throws TException {
        System.out.println(para);
        return para;
    }

    public List<String> testList(List<String> para) throws TException {
        System.out.println(para);
        return para;
    }

    public Map<String, String> testMap(Map<String, String> para) throws TException {
        System.out.println(para);
        return para;
    }

    public Set<String> testSet(Set<String> para) throws TException {
        System.out.println(para);
        return para;
    }

    public ThriftException testException(ThriftException para) throws TException {
        System.out.println(para);
        return para;
    }

    public JavaBean testStruct(JavaBean para) throws TException {
        System.out.println(para);
        return para;
    }
}
