package com.homvee.thrift;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

import java.util.*;

/**
 * @Package: com.dmall.presale.mail.service
 * @Description: TODO
 * @date:2016/3/4
 * @author: Hongwei.tang
 * @email: Hongwei.Tang@DMall.com
 * @Copyright: Copyright(c) 2016, DMall All Rights Reserved.
 */
public class ThriftClient {
    public static void main(String[] args) {
        async(null);
    }
    public static void sync(String[] args) {
        TTransport transport =new TSocket("127.0.0.1",9527);
        try {
            transport.open();
            TProtocol protocol = new TBinaryProtocol(transport);
            ThriftService.Client client = new ThriftService.Client(protocol);
            System.out.println(client.testBoolean(true));
            System.out.println(client.testByte((byte)100));
            System.out.println(client.testShort((short)200));
            System.out.println(client.testInt(300));
            System.out.println(client.testLong(400L));
            System.out.println(client.testDouble(400.655532325522254555141224755D));

            System.out.println(client.testString("String"));
            System.out.println(client.testException(new ThriftException()));
            List<String> list = new ArrayList<String>();
            list.add("List");
            System.out.println(client.testList(list));
            Set<String> set = new HashSet<String>();
            set.add("set");
            System.out.println(client.testSet(set));
            Map<String,String> map = new HashMap<String, String>();
            map.put("key","value");
            System.out.println(client.testMap(map));
            JavaBean javaBean = new JavaBean();
            javaBean.setAge(456);
            javaBean.setName("java_bean");
            System.out.println(javaBean);

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(transport != null){
                transport.close();
            }
        }
    }
    public static void async(String[] args) {
        TTransport transport =null;
        try {
            transport = new TFramedTransport(new TSocket("127.0.0.1",9527));
            TProtocol protocol = new TBinaryProtocol(transport);
            ThriftService.Client client = new ThriftService.Client(protocol);
            transport.open();
            System.out.println(client.testBoolean(true));
            System.out.println(client.testByte((byte)100));
            System.out.println(client.testShort((short)200));
            System.out.println(client.testInt(300));
            System.out.println(client.testLong(400L));
            System.out.println(client.testDouble(400.655532325522254555141224755D));

            System.out.println(client.testString("String"));
            System.out.println(client.testException(new ThriftException()));
            List<String> list = new ArrayList<String>();
            list.add("List");
            System.out.println(client.testList(list));
            Set<String> set = new HashSet<String>();
            set.add("set");
            System.out.println(client.testSet(set));
            Map<String,String> map = new HashMap<String, String>();
            map.put("key","value");
            System.out.println(client.testMap(map));
            JavaBean javaBean = new JavaBean();
            javaBean.setAge(456);
            javaBean.setName("java_bean");
            System.out.println(javaBean);

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(transport != null){
                transport.close();
            }
        }
    }
}
