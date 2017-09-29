package org.ce;

import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by yang on 2017/2/8.
 */
public class SocketTest {

    public static void main (String [] args) throws Exception{
        Socket client = new Socket(InetAddress.getByName("127.0.0.1"),12980);
        OutputStream out = client.getOutputStream();
        out.write("客户端发信息来了！".getBytes());
    }

}
