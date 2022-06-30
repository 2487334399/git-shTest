package com.atgs.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.RandomAccess;

public class MapperBytebufferTest {
    public static void main(String[] args) throws Exception {
          /*
          * 说明MappedByteBuffer 可以让文件直接修改内存操作系统不需要拷贝依次
          **/
         /*堆外内存进行拷贝*/
        RandomAccessFile randomAccessFile = new RandomAccessFile("1.txt","rw");
        //获取对应的通道
        FileChannel channel = randomAccessFile.getChannel();
        /*
        * 参数1:FileChannel.MapMode.READ_WRITE 使用的读写模式
        * 参数2:0，可以直接修改的其实位置
        * 参数3:5:是映射到内存的大小，即将1.txt的多少个字节映射到内存
        * 可以直接修改的内存范围就是0-5;
        * 实际类型DirectByteBuffer
        * */
        MappedByteBuffer mappedByteBuffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, 5);
        mappedByteBuffer.put(0,(byte)'H');
        mappedByteBuffer.put(3,(byte)'9');
        mappedByteBuffer.put(5,(byte)'Y');

        randomAccessFile.close();
        System.out.println("修改成功");
    }
}
