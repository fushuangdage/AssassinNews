package com.fushuang.assassinnews.xmpp;


import com.fushuang.assassinnews.Constant;

import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.SASLAuthentication;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.Presence;

import java.io.IOException;

/**
 * Created by sv-004 on 2016/6/15.
 */
public class XmppConnection {


    private static XMPPConnection connection = null;
    private static XmppConnection xmppConnection;


    // TODO 实例化工具类,用于外部调用内部方法
    public static XmppConnection getInstance() {
        if (xmppConnection == null) {
            xmppConnection = new XmppConnection();
        }
        return xmppConnection;
    }


    public void setNull() {
        connection = null;
    }

    public XMPPConnection getConnection() {
        if (connection == null) {
            openConnection();
        }
        return connection;
    }

    /**
     * TODO
     *
     * @return flag 链接开启的标识.
     * @author mashihao
     * @time 2016/6/16 9:52
     */
    public boolean openConnection() {

        try {
            ConnectionConfiguration config = new ConnectionConfiguration(Constant.SERVER_HOST, Constant.SERVER_PORT
                    , Constant.SERVER_NAME);
            //设置可以重新连接
            config.setReconnectionAllowed(true);
            //设置安全模式
            config.setSecurityMode(ConnectionConfiguration.SecurityMode.disabled);
            //连接标示
            config.setSendPresence(true);
            //这一个方法和Asmack的老版本不是太一样.
            SASLAuthentication.supportSASLMechanism("PLAIN", 0);
            connection = new XMPPConnection(config);
            connection.connect();
            return true;
        } catch (XMPPException e1) {
            e1.printStackTrace();
        }
        return false;
    }

    /**
     * @author msh
     * @time 2016/6/16 9:56
     * TODO 登录
     * @param username
     * @param password
     * @return Boolean flag
     */

    public boolean login(String username, String password) {
        try {
            if (getConnection() == null) {
                return false;
            }
            //已连接, 未认证!
            if (!getConnection().isAuthenticated() && getConnection().isConnected()) {
                getConnection().login(username, password);
                //更改在线状态
                Presence presence = new Presence(Presence.Type.available);
                presence.setMode(Presence.Mode.available);
                getConnection().sendPacket(presence);
                return true;
            }


        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }


    // TODO 关闭连接
    public void closeConnection() {

        if (connection != null) {
            try {
                connection.disconnect();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                connection = null;
                xmppConnection = null;
            }
        }
    }
}
