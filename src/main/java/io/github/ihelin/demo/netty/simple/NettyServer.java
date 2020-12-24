package io.github.ihelin.demo.netty.simple;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author iHelin
 * @since 2020/12/24 13:54
 */
public class NettyServer {

    public static void main(String[] args) throws InterruptedException {
//        创建BossGroup和WorkerGroup
//        说明
//        1.创建两个线程组bossGroup和workerGroup
//        2.bossGroup只是处理请求，真正和客户端业务处理，交给workerGroup完成
//        3.两个都是无限循环
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {


//      创建服务端的启动对象，配置参数
            ServerBootstrap bootstrap = new ServerBootstrap();
//      使用链式编程方式进行设置
            bootstrap.group(bossGroup, workerGroup) //设置两个线程组
                    .channel(NioServerSocketChannel.class)//使用NioServerSocketChannel，作为服务器的通道实现
                    .option(ChannelOption.SO_BACKLOG, 128)//设置线程队列等待连接个数
                    .childOption(ChannelOption.SO_KEEPALIVE, Boolean.TRUE)//设置保持活动连接状态
                    .childHandler(new ChannelInitializer<SocketChannel>() {//创建通道初始化对象
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new NettyServerHandler());
                        }
                    });//给WorkerGroup的EventLoop对应的管道设置处理器
            System.out.println("server is ready");
//        绑定一个端口并且同步，生成了一个channelFuture
            ChannelFuture channelFuture = bootstrap.bind(8888).sync();
            channelFuture.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
