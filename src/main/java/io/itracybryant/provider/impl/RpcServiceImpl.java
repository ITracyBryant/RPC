package io.itracybryant.provider.impl;

import io.itracybryant.provider.api.RpcService;

/**
 * @ClassName RpcServiceImpl
 * @Description TODO
 * @Author Administrator
 * @Date 2019/3/23 15:04
 * @Version 1.0
 */
public class RpcServiceImpl implements RpcService {
    @Override
    public String useRpc(String name) {
        return "RPC Service: " + name;
    }
}
