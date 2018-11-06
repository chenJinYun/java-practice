package pers.kim.httpserver;

import java.io.*;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

public class CallMethod {
    private Set<RedictSet> redictSet;

    public void getFile(String path, Socket client) {
        String[] pathList = path.split("\\s");
        if (pathList[1].equals("/")) pathList[1] = "index.html";
        File fileToSend = new File("file/" + pathList[1]);

        if (fileToSend.exists() && !fileToSend.isDirectory()) {
            try {
                String contentType = (new GetContentType()).getContentType(pathList[1]);
                PrintStream writer = new PrintStream(client.getOutputStream());
                writer.println("HTTP/1.0 200 OK");// 返回应答消息,并结束应答
                writer.println("Content-Type:" + contentType);//响应头
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
        } else {
//            重定向
            RedictSet set = new RedictSet("localhost", 9003);
            redictSet = new HashSet<RedictSet>();
            redictSet.add(set);
            Boolean flag=false;
            RedictSet setUrlAndPort=null;
            for (RedictSet list : redictSet) {
                try {
                    Socket socket = new Socket(list.getUrl(), list.getPort());
                    InputStream inputStream=socket.getInputStream();
                    OutputStream outputStream=socket.getOutputStream();
                    BufferedReader reader=new BufferedReader(new InputStreamReader(inputStream));
                    outputStream.write(path.getBytes());
                    outputStream.write("\n".getBytes());
                    String line=reader.readLine();
                    System.out.println(line);
                    if(line.indexOf("200")!=-1){
                        flag=true;
                        setUrlAndPort=new RedictSet(list.getUrl(),list.getPort());
                        break;
                    }
                    reader.close();
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    try {
                        File errFileToSend = new File("file/" + "500.html");
                        PrintStream writer = new PrintStream(client.getOutputStream());
                        writer.println("HTTP/1.0 404 NOTFOUND");// 返回应答消息,并结束应答
                        writer.println("Content-Type:text/html");//响应头
                        writer.println("Content-Length:" + errFileToSend.length());// 返回内容字节数
                        writer.println();// 根据 HTTP 协议, 空行将结束头信息
                        FileInputStream fis = new FileInputStream(errFileToSend);
                        byte[] buf = new byte[fis.available()];
                        fis.read(buf);
                        writer.write(buf);
                        writer.close();
                        fis.close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
            if(flag){
//                表示找到
                try {
                    PrintStream writer = new PrintStream(client.getOutputStream());
                    writer.println("HTTP/1.0 302 FOUND");// 返回应答消息,并结束应答
                    writer.println("Content-Type:text/html");//响应头
                    writer.println("Server:Redirector 1.1");
                    writer.println("Location:" + "http://"+setUrlAndPort.getUrl()+":"+setUrlAndPort.getPort()+pathList[1]);// 返回内容字节数
                    writer.println();// 根据 HTTP 协议, 空行将结束头信息
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    try {
                        File errFileToSend = new File("file/" + "500.html");
                        PrintStream writer = new PrintStream(client.getOutputStream());
                        writer.println("HTTP/1.0 404 NOTFOUND");// 返回应答消息,并结束应答
                        writer.println("Content-Type:text/html");//响应头
                        writer.println("Content-Length:" + errFileToSend.length());// 返回内容字节数
                        writer.println();// 根据 HTTP 协议, 空行将结束头信息
                        FileInputStream fis = new FileInputStream(errFileToSend);
                        byte[] buf = new byte[fis.available()];
                        fis.read(buf);
                        writer.write(buf);
                        writer.close();
                        fis.close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            } else {
//                表示没找到
                try {
                    File errFileToSend = new File("file/" + "404.html");
                    PrintStream writer = new PrintStream(client.getOutputStream());
                    writer.println("HTTP/1.0 404 NOTFOUND");// 返回应答消息,并结束应答
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
                    try {
                        File errFileToSend = new File("file/" + "500.html");
                        PrintStream writer = new PrintStream(client.getOutputStream());
                        writer.println("HTTP/1.0 500 fail");// 返回应答消息,并结束应答
                        writer.println("Content-Type:text/html");//响应头
                        writer.println("Content-Length:" + errFileToSend.length());// 返回内容字节数
                        writer.println();// 根据 HTTP 协议, 空行将结束头信息
                        FileInputStream fis = new FileInputStream(errFileToSend);
                        byte[] buf = new byte[fis.available()];
                        fis.read(buf);
                        writer.write(buf);
                        writer.close();
                        fis.close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        }
    }
}
