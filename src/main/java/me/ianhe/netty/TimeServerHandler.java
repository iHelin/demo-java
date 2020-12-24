package me.ianhe.netty;

import io.netty.channel.ChannelHandlerAdapter;

/**
 * @author iHelin
 * @since 2018/5/16 22:53
 */
public class TimeServerHandler extends ChannelHandlerAdapter {

//    @Override
//    public void channelRead(ChannelHandlerContext ctx, Object msg)
//            throws Exception {
//        ByteBuf buf = (ByteBuf) msg;
//        byte[] req = new byte[buf.readableBytes()];
//        buf.readBytes(req);
//        String body = new String(req, StandardCharsets.UTF_8);
//        System.out.println("The time server receive order : " + body);
//        String currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body) ? new java.util.Date(
//                System.currentTimeMillis()).toString() : "BAD ORDER";
//        ByteBuf resp = Unpooled.copiedBuffer(currentTime.getBytes());
//        ctx.write(resp);
//    }
//
//    @Override
//    public void channelReadComplete(ChannelHandlerContext ctx) {
//        ctx.flush();
//    }
//
//    @Override
//    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
//        ctx.close();
//    }

}
