package io.itracybryant.protocol.http;

import io.itracybryant.framework.Invocation;
import io.itracybryant.framework.URL;
import io.itracybryant.register.Register;
import org.apache.commons.io.IOUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @ClassName HttpServerHandler
 * @Description TODO
 * @Author Administrator
 * @Date 2019/3/23 15:28
 * @Version 1.0
 */
public class HttpServerHandler {
    public void handler(HttpServletRequest req, HttpServletResponse resp) {
        try {
            InputStream inputStream = req.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(inputStream);
            Invocation invocation = (Invocation) ois.readObject();

            // 去注册中心获取服务接口的实现类
            String interfaceName = invocation.getInterfaceName();
            URL url = new URL("localhost", 8080);
            Class implClass = Register.get(url, interfaceName);

            // 反射获取执行方法
            Method method = implClass.getMethod(invocation.getMethodName(), invocation.getParamsType());
            String result = (String) method.invoke(implClass.newInstance(), invocation.getParams());

            OutputStream os = resp.getOutputStream();
            IOUtils.write("Tomcat---> " + result, os);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
