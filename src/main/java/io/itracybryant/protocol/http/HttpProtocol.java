package io.itracybryant.protocol.http;

import io.itracybryant.framework.Invocation;
import io.itracybryant.framework.Protocol;
import io.itracybryant.framework.URL;

/**
 * @ClassName HttpProtocol
 * @Description TODO
 * @Author Administrator
 * @Date 2019/3/23 18:15
 * @Version 1.0
 */
public class HttpProtocol implements Protocol {
    @Override
    public void start(URL url) {
        HttpServer httpServer = new HttpServer();
        httpServer.start(url.getHostName(), url.getPort());
    }

    @Override
    public String send(URL url, Invocation invocation) {
        HttpClient httpClient = new HttpClient();
        return httpClient.post(url.getHostName(), url.getPort(), invocation);
    }
}
