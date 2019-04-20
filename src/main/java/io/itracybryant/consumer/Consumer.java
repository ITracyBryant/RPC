package io.itracybryant.consumer;

import io.itracybryant.framework.Invocation;
import io.itracybryant.framework.ProxyFactory;
import io.itracybryant.protocol.http.HttpClient;
import io.itracybryant.provider.api.RpcService;

/**
 * @ClassName Consumer
 * @Description TODO
 * @Author Administrator
 * @Date 2019/3/23 16:29
 * @Version 1.0
 */
public class Consumer {
    public static void main(String[] args) {
       RpcService rpcService = ProxyFactory.getProxy(RpcService.class);
        String result = rpcService.useRpc("123456");
        System.out.println(result);
    }
}
