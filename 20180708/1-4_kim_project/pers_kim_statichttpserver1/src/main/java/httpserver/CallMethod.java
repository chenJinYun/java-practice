package httpserver;

import java.io.*;
import java.net.Socket;
import java.util.Set;

public class CallMethod {
    private Set<RedictSet> redictSet;
    public void getFile(String path, Socket client) {
        String[] pathList = path.split("\\s");
        if (pathList[1].equals("/")) pathList[1] = "index.html";
        File fileToSend = new File("file/" + pathList[1]);

        if (fileToSend.exists() && !fileToSend.isDirectory()) {
            try {
                String contentType=(new GetContentType()).getContentType(pathList[1]);
                PrintStream writer = new PrintStream(client.getOutputStream());
                writer.println("HTTP/1.0 200 OK");// 返回应答消息,并结束应答
                writer.println("Content-Type:"+contentType);//响应头
                writer.println("Content-Length:" + fileToSend.length());// 返回内容字节数
                writer.println();// 根据 HTTP 协议, 空行将结束头信息

                FileInputStream fis = new FileInputStream(fileToSend);
                byte[] buf = new byte[fis.available()];
                fis.read(buf);
                writer.write(buf);
                writer.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            try {
                File errFileToSend = new File("file/" + "404.html");
                PrintStream writer = new PrintStream(client.getOutputStream());
                writer.println("HTTP/1.0 404 OK");// 返回应答消息,并结束应答
                writer.println("Content-Type:text/html");//响应头
                writer.println("Content-Length:" + errFileToSend.length());// 返回内容字节数
                writer.println();// 根据 HTTP 协议, 空行将结束头信息
                FileInputStream fis = new FileInputStream(errFileToSend);
                byte[] buf = new byte[fis.available()];
                fis.read(buf);
                writer.write(buf);
                writer.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
