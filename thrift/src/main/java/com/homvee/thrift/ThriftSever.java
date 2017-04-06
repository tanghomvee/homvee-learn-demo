package com.homvee.thrift;

import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

/**
 * @Package: com.dmall.presale.mail.service
 * @Description: TODO
 * @date:2016/3/4
 * @author: Hongwei.tang
 * @email: Hongwei.Tang@DMall.com
 * @Copyright: Copyright(c) 2016, DMall All Rights Reserved.
 */
public class ThriftSever {
    public static void main(String[] args) {
        async(null);
    }
    public static void syncData(String[] args1) {
        TServerSocket serverSocket = null;
        try {
            serverSocket = new TServerSocket(9527);
            TBinaryProtocol.Factory factory = new TBinaryProtocol.Factory();
            TProcessor processor = new ThriftService.Processor<ThriftService.Iface>(new ThriftServiceImpl());
            TThreadPoolServer.Args args = new TThreadPoolServer.Args(serverSocket);
            args.processor(processor);
            args.protocolFactory(factory);
            TServer server = new TThreadPoolServer(args);
            server.serve();
            System.out.println("server start.............");
        } catch (TTransportException e) {
            e.printStackTrace();
        }

    }
    public static void async(String[] args1) {
        TNonblockingServerSocket transport = null;
        try {
            TProcessor processor = new ThriftService.Processor<ThriftService.Iface>(new ThriftServiceImpl());
            transport = new TNonblockingServerSocket(9527);
            TBinaryProtocol.Factory factoryProtocol = new TBinaryProtocol.Factory();
            TFramedTransport.Factory factoryTransport = new TFramedTransport.Factory();
            TNonblockingServer.Args args = new TNonblockingServer.Args(transport);
            args.processor(processor);
            args.protocolFactory(factoryProtocol);
            args.transportFactory(factoryTransport);
            TServer server = new TNonblockingServer(args);
            server.serve();
            System.out.println("server start.............");
        } catch (TTransportException e) {
            e.printStackTrace();
        }

    }
}
