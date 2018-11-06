package pers.kim.lms.server;


import pers.kim.lms.operatorbooks.ObjectBook;
import pers.kim.lms.operatorbooks.OperatorBooking;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
//    public static List<ObjectBook> bookList = new ArrayList<ObjectBook>();
    public static void main(String[] args) throws IOException {
        final ServerSocket server = new ServerSocket(9002);
        while (true) {
            final Socket socket = server.accept();
            new Thread() {
                @Override
                public void run() {
                    try {
                        OutputStream outputStream = socket.getOutputStream();
                        InputStream in = socket.getInputStream();
                        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                        String line = reader.readLine();
//                        根据增删改查调用不同的方法
                        String method = line.split("\\s")[0];
                        if (method.equals("GET")) {
                            OperatorBooking res = new OperatorBooking();
                            res.getBookList(line, socket);
                        } else if (method.equals("POST")){
//                            如何获取post的参数
                            int length=0;
                            StringBuilder httpBody=new StringBuilder();
                            while (true) {
                                if(line.contains("Content-Length")){
                                    length = Integer.parseInt(line.trim().split(":")[1].trim());
                                }
                                if((line = reader.readLine()).equals("")){
//                                    一个一个字节读取请求体的参数
                                    for (int i=0;i<length;i++){
                                        char c = (char) reader.read();
                                        httpBody.append(c); // 请求体
                                        }
                                    break;
                                }
                            }
                            OperatorBooking res = new OperatorBooking();
                            res.addBook(httpBody.toString(),socket);
                        } else if(method.equals("DELETE")){

                        }
                        outputStream.close();
                        in.close();
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }

    }
}
