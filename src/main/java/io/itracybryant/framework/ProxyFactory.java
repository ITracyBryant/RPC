package io.itracybryant.framework;

import io.itracybryant.protocol.http.HttpClient;
import io.itracybryant.provider.api.RpcService;
import io.itracybryant.register.Register;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName ProxyFactory
 * @Description TODO
 * @Author Administrator
 * @Date 2019/3/23 16:44
 * @Version 1.0
 */
public class ProxyFactory {
    public static <T> T getProxy(final Class interfaceClass) {
        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class[]{interfaceClass}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Protocol protocol = ProtocolFactory.getProtocol();
                Invocation invocation = new Invocation(RpcService.class.getName(), "useRpc", new Object[]{"success"}, new Class[]{String.class});
                URL url = Register.getRandom(interfaceClass.getName());
                return protocol.send(url, invocation);
            }
        });
    }
}
