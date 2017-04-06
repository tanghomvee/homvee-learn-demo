package test.com.homvee.kafka;

import java.io.IOException;
import java.net.Socket;

/**
 * @Package: com.dmall.presale.mail.service
 * @Description: TODO
 * @date:2016/3/9
 * @author: Hongwei.tang
 * @email: Hongwei.Tang@DMall.com
 * @Copyright: Copyright(c) 2016, DMall All Rights Reserved.
 */
public class Test {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("192.168.8.110",9091);
            socket.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
