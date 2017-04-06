package com.homvee.zookeeper;

import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.IZkStateListener;
import org.I0Itec.zkclient.ZkClient;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.Watcher;

import java.util.List;

/**
 * @Package: com.dmall.presale.mail.service
 * @Description: TODO
 * @date:2016/3/4
 * @author: Hongwei.tang
 * @email: Hongwei.Tang@DMall.com
 * @Copyright: Copyright(c) 2016, DMall All Rights Reserved.
 */
public class ZKClientTest {
    public static final String zkURL="192.168.8.110:2181,192.168.8.110:2182,192.168.8.110:2183";
    public static void main(String[] args) {
        ZkClient zkClient = new ZkClient(zkURL);
        try {
            String path ="/home/tanghomvee/zookeeper/zkclient";
            zkClient.subscribeChildChanges(path, new IZkChildListener() {
                public void handleChildChange(String s, List<String> list) throws Exception {
                    System.out.println("subscribeChildChanges["+s+" : "+list+"]");
                }
            });
            zkClient.subscribeDataChanges(path, new IZkDataListener() {
                public void handleDataChange(String s, Object o) throws Exception {
                    System.out.println("subscribeDataChanges["+s+" : "+o+"]");
                }

                public void handleDataDeleted(String s) throws Exception {
                    System.out.println("subscribeDataChanges["+s+"]");
                }
            });
            zkClient.subscribeStateChanges(new IZkStateListener() {

                public void handleStateChanged(Watcher.Event.KeeperState keeperState) throws Exception {
                    System.out.println("subscribeStateChanges["+keeperState+"]");
                }

                public void handleNewSession() throws Exception {
                    System.out.println("subscribeStateChanges[NewSession]");
                }

                public void handleSessionEstablishmentError(Throwable throwable) throws Exception {
                    System.out.println("subscribeStateChanges["+throwable+"]");
                }
            });

            zkClient.create(path,"Hello ZKClient", CreateMode.PERSISTENT);
            List<String> children = zkClient.getChildren("/home/tanghomvee/zookeeper");
            int childrenCnt =zkClient.countChildren("/home/tanghomvee/zookeeper");
            System.out.println("children["+children+"]==>"+childrenCnt);
            System.out.println(zkClient.exists(path));
            zkClient.writeData(path,"Hello ZKClient");
            System.out.println(zkClient.readData(path));
            zkClient.writeData(path,"11111111111111111111111");
            System.out.println(zkClient.readData(path));
            zkClient.delete(path);

        }catch (Exception ex){

        }finally {
            if(zkClient != null){
                zkClient.close();
            }
        }
    }
}
