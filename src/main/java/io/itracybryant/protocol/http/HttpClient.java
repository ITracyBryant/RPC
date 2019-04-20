package io.itracybryant.protocol.http;

import io.itracybryant.framework.Invocation;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @ClassName HttpClient
 * @Description TODO
 * @Author Administrator
 * @Date 2019/3/23 16:15
 * @Version 1.0
 */
public class HttpClient {
    public String post(String hostname, Integer port, Invocation invocation){
        try {
            URL url = new URL("http",hostname,port,"/");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);

            OutputStream os = httpURLConnection.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(invocation);
            oos.flush();
            oos.close();

            InputStream is = httpURLConnection.getInputStream();
            return IOUtils.toString(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
