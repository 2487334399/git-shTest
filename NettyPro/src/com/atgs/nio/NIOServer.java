package com.atgs.nio;


import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

public class NIOServer {

    public static void main(String[] args) throws Exception {
        //创建ServerSocketChannel
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //得到一个Seletor的对象
        Selector selector = Selector.open();

        //绑定一个端口6666，在服务器端监听

        serverSocketChannel.socket().bind(new InetSocketAddress(7890));
        //设置为非阻塞
        serverSocketChannel.configureBlocking(false);
        //把serverSocketChannel注册到Selector，关联事件为OP_ACCEPT
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        while(true){
            //这里我们等待一秒，如果没有事件发生，返回
            if(selector.select(1000)==0){//没有时间发生
                System.out.println("服务器等待了一秒，无连接");
                continue;
            }
            //如果返回的不是大于0，就获取相关的selectionKey集合，
            //如果返回的>0,表示已经获得相关的事件
            //通过selectKeys反向获取通道
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            //遍历Set<SelectionKey>,使用迭代器遍历
            Iterator<SelectionKey> keyIterator = selectionKeys.iterator();
            while(keyIterator.hasNext()){
                //获取到SelectKey
                SelectionKey key = keyIterator.next();
                //根据key 对应的通道发生的事件做相应的处理
                if(key.isAcceptable()){//如果是OP_ACCEPT,有新的客户端连接
                    //该了客户端生成一个SocketChannel
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    System.out.println("======================");
                    //将socketChannel设置为非阻塞
                    socketChannel.configureBlocking(false);
                    //将socketChannel注册到selector,关注事件为OP_READ,同时给SocketChannel
                    //关联一个buffer
                    socketChannel.register(selector,SelectionKey.OP_READ, ByteBuffer.allocate(1024));

                }
                if(key.isReadable()){
                    //发生OP_READ
                    //通过key反向获取到对应的channel
                    SocketChannel channel = (SocketChannel)key.channel();
                    //获取到读channel关联的buffer
                    ByteBuffer buffer = (ByteBuffer)key.attachment();
                    channel.read(buffer);
                    System.out.println("form客户端"+new String(buffer.array()));

                }
                //手动从集合中移动当前的selectionKey,防止重复操作。
                keyIterator.remove();
            }

        }
    }
}
