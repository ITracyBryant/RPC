package io.itracybryant.provider;

import io.itracybryant.framework.Protocol;
import io.itracybryant.framework.ProtocolFactory;
import io.itracybryant.framework.URL;
import io.itracybryant.protocol.http.HttpServer;
import io.itracybryant.provider.api.RpcService;
import io.itracybryant.provider.impl.RpcServiceImpl;
import io.itracybryant.register.Register;

/**
 * @ClassName Provider
 * @Description TODO
 * @Author Administrator
 * @Date 2019/3/23 15:52
 * @Version 1.0
 */
public class Provider {
    public static void main(String[] args) {
        // 向注册中心注册提供的服务
        URL url = new URL("localhost", 8080);
        Register.regist(url, RpcService.class.getName(), RpcServiceImpl.class);

        // 启动Server
        Protocol protocol = ProtocolFactory.getProtocol();
        protocol.start(url);

    }
}
