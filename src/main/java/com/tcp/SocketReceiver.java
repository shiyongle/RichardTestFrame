package com.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Richered
 * @Date: 2020/2/3 16:10
 * @Description: tcp server
 */

public class SocketReceiver {
    //定义初始
    public static final int corePoolSize = 5;
    //定义最大线程池
    public static final int maximumPoolSize = 5;
    //定义socket队列长度
    public static final int blockingQueue = 50;


    /**
     * 初始化并启动服务
     */
    public void init() {
        //定义线程池
        ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, 0L,
                TimeUnit.MILLISECONDS, new ArrayBlockingQueue(blockingQueue));
        //定义serverSocket
        ServerSocket serverSocket = null;
        try {
            //启动serverSocket
//            serverSocket = new ServerSocket(Constants.PORT);
            //输出服务启动地址
            System.out.println("服务已启动:" + serverSocket.getLocalSocketAddress().toString());
            //接收信息并传递给线程池
            while (true) {
                Socket socket = serverSocket.accept();
                executor.submit(new Handler(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close(); //释放serverSocket
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //处理请求类
    class Handler implements Runnable {

        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                // 接收客户端的信息
                InputStream in = socket.getInputStream();
                int count = 0;
                while (count == 0) {
                    count = in.available();
                }
                byte[] b = new byte[count];
                in.read(b);
                String message = new String(b);
                System.out.println(" receive request: " + socket.getInetAddress() + " " + message);

                // 睡2秒模拟思考时间，这里是为了模拟服务器端的业务处理时间
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // 向客户端发送确认消息
                //定义输出流outer
                OutputStream outer = socket.getOutputStream();
                //将客户端发送的信息加上确认信息ok
                String response = message + " is OK";
                //将输入信息保存到b_out中
                byte[] b_out = response.getBytes();
                //写入输入流
                outer.write(b_out);
                //推送输入流到客户端
                outer.flush();

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                // 关闭socket
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //程序入口
    public static void main(String[] args) {
        //定义服务端
        SocketReceiver receiver = new SocketReceiver();
        //启动服务端
        receiver.init();
    }
}