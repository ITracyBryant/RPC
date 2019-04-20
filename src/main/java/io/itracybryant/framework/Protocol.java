package io.itracybryant.framework;

/**
 * @InterfaceName Protocol
 * @Description TODO
 * @Author Administrator
 * @Date 2019/3/23 18:12
 * @Version 1.0
 */
public interface Protocol {
    void start(URL url);

    String send(URL url, Invocation invocation);
}
