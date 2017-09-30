package org.cute;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by yang on 2017/2/8.
 */
public class SocketServerTest {

    public static void main(String [] args) throws Exception{
        ServerSocket server = new ServerSocket(12980);
        while(true){
            Socket s = server.accept();
            InputStream in = s.getInputStream();
            byte [] bytes = new byte[100];
            in.read(bytes);

            System.out.println("服务端响应，接收到的内容为："+new String(bytes));
        }
    }
}
