package com.atgs.nio;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;


public class NIOFileChannel01 {

    public static void main(String[] args) throws Exception {

        String str="hello,汇丰银行";
        //创建一个输出流-》channel
        FileOutputStream fileOutputStream = new FileOutputStream("d:\\file01.txt");
        //通过输出流获取对应的文件FileChannel
        //这个fileChannel真实类型是FileChannelImpl
        FileChannel fileChannel = fileOutputStream.getChannel();
        //创建一个缓冲区ByteBuffer
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        //将str放入到byteBuffer中去
        byteBuffer.put(str.getBytes());
        //对byteBuffer进行flip();
        byteBuffer.flip();
        //将byteBuffer 数据写入到fileChannel
        fileChannel.write(byteBuffer);
        fileChannel.close();

    }

}
