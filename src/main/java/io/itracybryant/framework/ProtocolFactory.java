package io.itracybryant.framework;

import io.itracybryant.protocol.http.HttpProtocol;

/**
 * @ClassName ProtocolFactory
 * @Description TODO
 * @Author Administrator
 * @Date 2019/3/23 18:18
 * @Version 1.0
 */
public class ProtocolFactory {
    public static Protocol getProtocol() {
        String name = System.getProperty("protocolName");
        if (name == null || name.equals("")) {
            name = "http";
        }
        switch (name) {
            case "http":
                return new HttpProtocol();
            case "dubbo":
                //TODO
                return null;
            default:
                break;
        }
        return new HttpProtocol();
    }
}
