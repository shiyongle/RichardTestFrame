package com.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @Author: Richered
 * @Date: 2020/2/3 16:23
 * @Description: 处理请求类
 */
public class Handler implements Runnable{

    private Socket socket;

    public Handler(Socket socket){
        this.socket = socket;
    }


    @Override
    public void run() {
        try {
            InputStream in = socket.getInputStream();
            int count = 0;
            while (count == 0){
                count = in.available();
            }
            byte[] b = new byte[count];
            in.read(b);
            String message = new String(b);
            System.out.println("receiver request" +socket.getInetAddress() + "~~~");

            try {
                Thread.sleep(200);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

            OutputStream outer = socket.getOutputStream();
            String response = message + "is ok";
            byte[] b_out = response.getBytes();
            outer.write(b_out);
            outer.flush();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                socket.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String []args){
        SocketReceiver receiver = new SocketReceiver();
        receiver.init();
    }
}
