package com.homvee.kafka;


import org.apache.kafka.clients.producer.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @Package:
 * @Description: TODO
 * @date:2016/3/8
 * @author: Hongwei.tang
 * @email: Hongwei.Tang@DMall.com
 * @Copyright: Copyright(c) 2016, DMall All Rights Reserved.
 */
public class Producer {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "192.168.8.110:9091,192.168.8.110:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put(ProducerConfig.RECONNECT_BACKOFF_MS_CONFIG, "10000");
        org.apache.kafka.clients.producer.Producer<String, String> producer = new KafkaProducer<String, String>(props);
        int pcnt = 11;
        final CountDownLatch countDownLatch = new CountDownLatch(pcnt);
        for(int i = 0; i < pcnt; i++){

            Future<RecordMetadata>  ret =  producer.send(new ProducerRecord<String, String>("my-topic", i+""), new Callback() {
                public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                    countDownLatch.countDown();
                }
            });
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            producer.flush();
            producer.close();
        }
    }
}
