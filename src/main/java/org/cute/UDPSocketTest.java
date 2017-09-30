package org.cute;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Created by yang on 2017/2/8.
 */
public class UDPSocketTest {

    public static void main(String [] args) throws Exception{
        //UDP Socket 客户端准备
        DatagramSocket client = new DatagramSocket();
        //数据包准备
        byte [] message = "UDP客户端发出来的信息".getBytes();
        DatagramPacket pg = new DatagramPacket(message,message.length, InetAddress.getByName("127.0.0.1"),12890);
        //发送数据包
        client.send(pg);
    }
}
