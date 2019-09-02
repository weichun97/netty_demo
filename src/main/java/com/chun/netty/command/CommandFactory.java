package com.chun.netty.command;

import com.chun.netty.command.var.CommandVar;

/**
 * @Author chun
 * @Date 2019/8/28 16:39
 */
public class CommandFactory {

    /**
     * 登录命令
     */
    private static LoginCommand loginCommand = new LoginCommand();


    /**
     * 根据指令获取对应的命令
     *
     * @param command   指令码
     * @return
     */
    public static Command getCommand(byte command){
        switch (command){
            case CommandVar.LOGIN_COMMAND:
                return loginCommand;
            default:
                break;
        }
        return null;
    }
}
