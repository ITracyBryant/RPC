package io.itracybryant.register;

import io.itracybryant.framework.URL;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Register
 * @Description TODO
 * @Author Administrator
 * @Date 2019/3/23 15:07
 * @Version 1.0
 */
public class Register {
    private static Map<String, Map<URL, Class>> register = new HashMap<>();

    public static void regist(URL url, String interfaceName, Class implClass) {
        Map<URL, Class> map = new HashMap<>();
        map.put(url, implClass);
        register.put(interfaceName, map);

        saveFile();
    }

    private static void saveFile() {
        try {
            FileOutputStream fos = new FileOutputStream("G:\\RPC\\src\\main\\resources\\temp.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(register);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Class get(URL url, String interfaceName) {
        register = getFile();
        return register.get(interfaceName).get(url);
    }

    private static Map<String, Map<URL, Class>> getFile() {
        try {
            FileInputStream fis = new FileInputStream("G:\\RPC\\src\\main\\resources\\temp.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            return (Map<String, Map<URL, Class>>) ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取随机的URL地址(注册中心的处理提供服务的地址，负载均衡的实现)
     * @param interfaceName
     * @return
     */
    public static URL getRandom(String interfaceName) {
        register = getFile();
        return register.get(interfaceName).keySet().iterator().next();
    }
}
