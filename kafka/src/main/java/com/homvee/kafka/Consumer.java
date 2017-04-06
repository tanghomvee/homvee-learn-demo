package com.homvee.kafka;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.*;

/**
 * @Package: com.dmall.presale.mail.service
 * @Description: TODO
 * @date:2016/3/8
 * @author: Hongwei.tang
 * @email: Hongwei.Tang@DMall.com
 * @Copyright: Copyright(c) 2016, DMall All Rights Reserved.
 */
public class Consumer {
    public static void main(String[] args) {
       final Map<String,Object> props = new HashMap<String, Object>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.8.110:9091,192.168.8.110:9092");
        props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, 30000);
        props.put(ConsumerConfig.GROUP_ID_CONFIG,"homvee");
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG,false);
        props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG,1000L);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);

//        org.apache.kafka.clients.consumer.Consumer<String,String> consumer = new KafkaConsumer<String, String>(props);
//        consume(consumer,"Thread-1");
        new Thread(new Runnable() {
            public void run() {
                org.apache.kafka.clients.consumer.Consumer<String,String> consumer = new KafkaConsumer<String, String>(props);
                consume(consumer,"Thread-1");
            }
        }).start();
        /*new Thread(new Runnable() {
            public void run() {
                org.apache.kafka.clients.consumer.Consumer<String,String> consumer = new KafkaConsumer<String, String>(props);
                consume(consumer,"Thread-2");
            }
        }).start();
        new Thread(new Runnable() {
            public void run() {
                org.apache.kafka.clients.consumer.Consumer<String,String> consumer = new KafkaConsumer<String, String>(props);
                consume(consumer,"Thread-3");
            }
        }).start();*/
    }

    public static void consume(final org.apache.kafka.clients.consumer.Consumer<String,String> consumer,String threadName) {
        List<String> topics = new ArrayList<String>();
        topics.add("my-topic");
        consumer.subscribe(topics);
        try{

            while (true){
                ConsumerRecords consumerRecords = consumer.poll(100L);
                Iterator<ConsumerRecord> iterator=consumerRecords.iterator();
                while (iterator.hasNext()){
                    ConsumerRecord record =  iterator.next();
                    System.out.printf(threadName+"-kafka-data:offset = %d,partition=%d, key = %s, value = %s\n", record.offset(),record.partition(), record.key(), record.value());
                }
            }
        }finally {

            consumer.close();
        }
    }
}
