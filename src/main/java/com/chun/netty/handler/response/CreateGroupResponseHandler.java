package com.chun.netty.handler.response;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.chun.netty.packet.response.CreateGroupResponsePacket;
import com.chun.netty.packet.response.LoginResponsePacket;
import com.chun.netty.util.Session;
import com.chun.netty.util.SessionUtils;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @Author chun
 * @Date 2019/9/3 11:11
 */
@ChannelHandler.Sharable
public class CreateGroupResponseHandler extends SimpleChannelInboundHandler<CreateGroupResponsePacket> {

    // 单例
    public static final CreateGroupResponseHandler INSTANCE = new CreateGroupResponseHandler();

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, CreateGroupResponsePacket createGroupResponsePacket) throws Exception {
        System.out.println(createGroupResponsePacket.getMsg());
    }
}
