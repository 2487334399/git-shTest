package com.atgs.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

/*Scattering：将数据写入buffer时，可以采用buffer数组，依次写入[分散]
* Gathering:从buffer读取数据时，可以采用buffer数组，依次读
* */
public class ScatteringAndGatheringTest {

    public static void main(String[] args) throws Exception {
        //使用ServerSocketChannel 和SocketChannel网络
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        InetSocketAddress inetSocketAddress = new InetSocketAddress(5001);

        //绑定端口到socket,并启动
        serverSocketChannel.socket().bind(inetSocketAddress);
        //创建buffer数组ByteBuffer[]
        ByteBuffer[] byteBuffers = new ByteBuffer[2];
        byteBuffers[0]=ByteBuffer.allocate(5);
        byteBuffers[1]=ByteBuffer.allocate(3);

        //等待客户连接(telnet)
        SocketChannel socketchannel=serverSocketChannel.accept();
        int messageLength=8;

        //循坏读取
        while(true){
            int byteRead=0;
            while(byteRead<messageLength){
                socketchannel.read(byteBuffers);
                byteRead+=1;//累计读取的字节数
                System.out.println("byteRead="+byteRead);
                //使用流进行打印。看看当前的这个buffer和position
                Arrays.asList(byteBuffers).stream().map(buffer->"position"+buffer.position()+",limit="+buffer.limit()).forEach(System.out::println);
            }
            //将所有的buffer进行flip
            Arrays.asList(byteBuffers).forEach(buffer->buffer.flip());
            //将数据读出来显示在客户端
            long byteWrite=0;
            while(byteWrite<messageLength){
                long l = socketchannel.write(byteBuffers);
                byteWrite+=1;
            }
            //将所有的buffer进行clear
            Arrays.asList(byteBuffers).forEach(buffer->buffer.clear());
            System.out.println("byteRead:="+byteRead+"byteWrite="+byteWrite+",messageLength"+messageLength);
        }


    }
}
