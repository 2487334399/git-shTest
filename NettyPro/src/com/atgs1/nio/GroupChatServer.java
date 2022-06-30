package com.atgs1.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

public class GroupChatServer {

    private Selector selector;
    private ServerSocketChannel listenChannel;
    private static final int PORT=6669;

    //构造器
    //初始化工作
    public GroupChatServer(){
        try{
            selector = Selector.open();
            //ServerSocketChannel
            listenChannel=ServerSocketChannel.open();
            //绑定端口
            listenChannel.socket().bind(new InetSocketAddress(PORT));
            //设置非阻塞模式
            listenChannel.configureBlocking(false);
            //将该listenChannel注册到Selector
            listenChannel.register(selector, SelectionKey.OP_ACCEPT);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    //监听
    public void listen(){
        try{
            //循环处理
            while(true){
                int count=selector.select();
                if(count>0){
                    //有事件处理
                    //遍历得到selectionKey的集合
                    Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                    while(iterator.hasNext()){
                        //取出selectionkey
                        SelectionKey key = iterator.next();
                        //监听到accept
                        if(key.isAcceptable()){
                            SocketChannel sc = listenChannel.accept();
                            sc.configureBlocking(false);
                            //将该sc注册到selector
                            sc.register(selector,SelectionKey.OP_ACCEPT);
                            //提示
                            System.out.println(sc.getRemoteAddress()+"上线");
                        }
                        if(key.isReadable()){
                            //通道发送read事件，即通道是可读的状态
                            //处理读（专门写的方法）

                        }
                        //当前key的删除，防止重复处理
                        iterator.remove();
                    }
                }else{
                    System.out.println("等待...");

                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            //发生异常处理
        }
    }
    //读取客户端消息
    private void readData(SelectionKey key){
        //定义一个SocketChannel
        SocketChannel channel=null;
        try{
            channel=(SocketChannel) key.channel();
            //创建buffer
            ByteBuffer buffer= ByteBuffer.allocate(1024);
            int count = channel.read(buffer);
            if(count>0){
                //把缓存区的数据转换成字符串
                String msg = new String(buffer.array());
                //输出该消息
                System.out.println("form客户端:"+msg);
                //向其他的客户端转发消息(去掉自己)，专门写一个方法来处理
                sendInfoToOtherClients(msg,channel);

            }
        }catch(Exception e){
            try{
                System.out.println(channel.getRemoteAddress()+"离线。。。");
                //取消注册
                key.channel();
                //关闭通道
                channel.close();
            }catch(IOException b){
                b.printStackTrace();
            }

        }
    }
    //转发消息给其他客户端(通道）
    private void sendInfoToOtherClients(String msg,SocketChannel  self) throws IOException {
        System.out.println("服务器转发消息");
        //遍历所有注册到selector上的SocketChannel,并派出self
        for(SelectionKey key:selector.keys()){
            //通过key取出对应的SocketChannel
            Channel targetChannel = key.channel();
            //排除自己
            if(targetChannel instanceof SocketChannel&& targetChannel!=self){
                //转型
                SocketChannel dest= (SocketChannel) targetChannel;
                //将msg存储到buffer
                ByteBuffer buffer=ByteBuffer.wrap(msg.getBytes());
                //将buffer数据写入到通道
                dest.write(buffer);
            }
        }
    }
    public static void main(String[] args) {
           //创建一个服务器对象
        GroupChatServer groupChatServer = new GroupChatServer();
        groupChatServer.listen();
    }
}
