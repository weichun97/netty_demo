package com.chun.netty.util;

import com.chun.netty.var.AttributeVar;
import io.netty.channel.Channel;
import io.netty.channel.group.ChannelGroup;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author chun
 * @Date 2019/9/4 9:59
 */
public class SessionUtils {

    /**
     * 保存登录的用户的 channel 信息
     */
    private static final Map<String, Channel> userNameChannel = new HashMap<>();

    /**
     * 保存群聊的 channelGroup 信息
     */
    private static final Map<String, ChannelGroup> channelGroupMap = new HashMap<>();

    /**
     * 登录，先将用户信息保存到 channel, 然后再将 channel 保存到 userNameChannel 里
     *
     * @param session
     * @param channel
     */
    public static void login(Session session, Channel channel){
        channel.attr(AttributeVar.SESSION).set(session);
        userNameChannel.put(session.getUserName(), channel);
    }

    /**
     * 退出登录
     *
     * @param channel
     */
    public static void logout(Channel channel){
        Session session = getSession(channel);
        if(session != null){
            userNameChannel.remove(session.getUserName());
            channel.attr(AttributeVar.SESSION).set(null);
        }
    }

    /**
     * 是否登录
     *
     * @param channel
     * @return
     */
    public static boolean hasLogin(Channel channel){
        return getSession(channel) != null;
    }

    /**
     * 获取 session
     *
     * @param channel
     * @return
     */
    public static Session getSession(Channel channel){
        return channel.attr(AttributeVar.SESSION).get();
    }

    /**
     * 获取 channel
     *
     * @param userName
     * @return
     */
    public static Channel getChannelByUserName(String userName){
        return userNameChannel.get(userName);
    }

    /**
     * 保存群聊
     *
     * @param groupName 群名
     * @param channels
     */
    public static void addChannelGroup(String groupName, ChannelGroup channels){
        channelGroupMap.put(groupName, channels);
    }

    /**
     * 获取群聊的 channelGroup
     *
     * @param groupName
     * @return
     */
    public static ChannelGroup getChannelGroupByGroupName(String groupName){
        return channelGroupMap.get(groupName);
    }
}
