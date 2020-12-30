package io.github.ihelin.demo.netty.prc.consumer;

import io.github.ihelin.demo.netty.prc.HelloService;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author iHelin
 * @since 2020/12/29 17:00
 */
public class NettyClient {

    private static final ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    private static NettyClientHandler clientHandler;

    public static void main(String[] args) {
        String providerName = "HelloService#hello#";
        NettyClient consumer = new NettyClient();
        HelloService helloService = consumer.getBean(HelloService.class, providerName);
        String result = helloService.hello("你好，rpc");
        System.out.println(result);
    }

    public <T> T getBean(final Class<T> serviceClass, final String providerName) {
        return (T) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{serviceClass}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (clientHandler == null) {
                    initClient();
                }
                //协议头
                clientHandler.setParam(providerName + args[0]);

                return executor.submit(clientHandler).get();
            }
        });
    }

    private static void initClient() {
        clientHandler = new NettyClientHandler();
        NioEventLoopGroup group = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(group)
                .channel(NioSocketChannel.class)
                .option(ChannelOption.TCP_NODELAY, true)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ChannelPipeline pipeline = ch.pipeline();
                        pipeline.addLast(new StringDecoder());
                        pipeline.addLast(new StringEncoder());
                        pipeline.addLast(clientHandler);
                    }
                });
        try {
            bootstrap.connect("localhost", 8888).sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
