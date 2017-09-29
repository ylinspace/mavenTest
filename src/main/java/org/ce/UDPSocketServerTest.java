package org.ce;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * Created by yang on 2017/2/8.
 */
public class UDPSocketServerTest {

    public static void main(String [] args) throws Exception{
        //定义UDP Socket 服务端
        DatagramSocket server = new DatagramSocket(12890);
        while (true){
            //准备数据包
            byte [] message = new byte[100];
            DatagramPacket pg = new DatagramPacket(message,message.length);
            //接收数据包
            server.receive(pg);
            //获取数据
            //pg.getData();

            System.out.println("UDP服务端从："+pg.getAddress().toString()+":"+pg.getPort()+",信息为："+new String(message).trim());
        }
    }
}
