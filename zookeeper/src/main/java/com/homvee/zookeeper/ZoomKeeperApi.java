package com.homvee.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;

import static org.apache.zookeeper.Watcher.Event.*;
import static org.apache.zookeeper.Watcher.Event.EventType.*;

/**
 * @Package: com.dmall.presale.mail.service
 * @Description: TODO
 * @date:2016/3/4
 * @author: Hongwei.tang
 * @email: Hongwei.Tang@DMall.com
 * @Copyright: Copyright(c) 2016, DMall All Rights Reserved.
 */
public class ZoomKeeperApi {
    public static final String zkURL="192.168.8.110:2181,192.168.8.110:2182,192.168.8.110:2183";


    public static void main(String[] args) {
        ZooKeeper zooKeeper = null;
        try {
            zooKeeper = new ZooKeeper(zkURL,20000, null);
            String path ="/home/tanghomvee/zookeeper/data";
            byte[] data = "Hello ZooKeeper".getBytes();
//        deleteNode(zooKeeper,path);
//        createNode(zooKeeper,path,data);


            data ="111111".getBytes();
            setData(zooKeeper,path,data);
            getData(zooKeeper,path);

            data ="ZooKeeper put Data".getBytes();
            setData(zooKeeper,path,data);
            getData(zooKeeper,path);
            getNode(zooKeeper,path);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (zooKeeper != null){
                try {
                    zooKeeper.close();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    public static void  createNode(ZooKeeper zooKeeper,String path,byte[] data) throws KeeperException, InterruptedException {
            zooKeeper.create(path,data, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
    }
    public static void  getNode(ZooKeeper zooKeeper,String path) throws KeeperException, InterruptedException {
        zooKeeper.getChildren(path,new ZkWatcher()).add("sssssssss");
    }

    public static void setData(ZooKeeper zooKeeper,String path,byte[] data) throws KeeperException, InterruptedException {
            Stat stat = zooKeeper.exists(path,false);
            if(stat != null){
                zooKeeper.setData(path,data,stat.getVersion());
            }

    }

    public static void getData(ZooKeeper zooKeeper,String path) throws KeeperException, InterruptedException {
            Stat stat = zooKeeper.exists(path,false);
            if(stat != null){
               byte[] buff = zooKeeper.getData(path,new ZkWatcher(),stat);
                System.out.println(new String (buff));
            }
    }

    public static void deleteNode(ZooKeeper zooKeeper,String path) throws KeeperException, InterruptedException {
            zooKeeper.delete(path,-1);
    }
}

class ZkWatcher implements Watcher{

    public void process(WatchedEvent event) {
        switch (event.getType()){
            case NodeCreated:
                break;
            case NodeDeleted:
                break;
            case NodeDataChanged:
                System.out.println(event.getState().toString());
                break;
            case NodeChildrenChanged:
                break;
            case None:
                break;
        }
    }
}
