package pers.kim.lms.operatorbooks;

import com.fasterxml.jackson.databind.ObjectMapper;
import pers.kim.lms.server.Server;

import java.io.*;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OperatorBooking extends Server implements Serializable {
    private ObjectMapper mapper = new ObjectMapper();

    //    获取书列表
    public void getBookList(String par, Socket socket) throws MalformedURLException {
        String[] pathList = par.split("\\s");
        URL url = new URL("http://localhost:9002" + pathList[1]);
        String query = url.getQuery();
        String[] queryList = query.split("&");
        if (queryList.length == 3) {
//            获取单个
//            String uid = queryList[1].split("=")[1];
//            System.out.println(uid);
//            List<ObjectBook> resBook = null;
//            for (ObjectBook oneBook : bookList) {
//                if ((oneBook.getUid()).equals(uid)) {
//                    resBook = new ArrayList<ObjectBook>();
//                    resBook.add(oneBook);
//                }
//            }
            try {
                String uid = queryList[1].split("=")[1];
                File file = new File("bookListFile");
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line;
                List<ObjectBook> resBook = new ArrayList<>();
                while ((line = br.readLine()) != null) {
                    String[] tempStr = line.split(",");
                    if (uid.equals(tempStr[0])) {
                        ObjectBook book = new ObjectBook(tempStr[0], tempStr[1], tempStr[2], tempStr[3]);
                        resBook.add(book);
                        break;
                    }
                }
                String jsonArray = mapper.writeValueAsString(resBook);
                PrintStream writer = new PrintStream(socket.getOutputStream());
                writer.println("HTTP/1.0 200 OK");// 返回应答消息,并结束应答
                writer.println("Content-Type:text/json;charset=utf-8");//响应头
                writer.println("Content-Length:" + ("onBack1(" + jsonArray + ")").getBytes().length);// 返回内容字节数
                writer.println("hreader:Access-Control-Allow-Origin: *");// 返回内容字节数
                writer.println("hreader:Access-Control-Allow-Methods:GET");// 返回内容字节数
                writer.println("Access-Control-Allow-Headers:x-requested-with,content-type*");// 返回内容字节数
                writer.println();// 根据 HTTP 协议, 空行将结束头信息
                writer.write(("onBack1(" + jsonArray + ")").getBytes());
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
//            获取全部
            try {
                File file = new File("bookListFile");
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line;
                List<ObjectBook> resBook = new ArrayList<>();
                while ((line = br.readLine()) != null) {
                    String[] tempStr = line.split(",");
                    ObjectBook book = new ObjectBook(tempStr[0], tempStr[1], tempStr[2], tempStr[3]);
                    resBook.add(book);
                }
                String jsonArray = mapper.writeValueAsString(resBook);
                PrintStream writer = new PrintStream(socket.getOutputStream());
                writer.println("HTTP/1.0 200 OK");// 返回应答消息,并结束应答
                writer.println("Content-Type:text/json;charset=utf-8");//响应头
                writer.println("Content-Length:" + ("onBack(" + jsonArray + ")").getBytes().length);// 返回内容字节数
                writer.println("setHeader:Access-Control-Allow-Origin: *");// 返回内容字节数
                writer.println("hreader:Access-Control-Allow-Methods:GET");// 返回内容字节数
                writer.println("Access-Control-Allow-Headers:x-requested-with,content-type*");// 返回内容字节数
                writer.println();// 根据 HTTP 协议, 空行将结束头信息
                writer.write(("onBack(" + jsonArray + ")").getBytes("UTF-8"));
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //    添加书籍
    public void addBook(String bookInfo, Socket socket) {
//        把参数转换成objectbook对象
        String[] paraList = bookInfo.split("&");
        String book_name = paraList[0].split("=")[1];
        book_name = URLDecoder.decode(book_name);
        String price = paraList[1].split("=")[1];
        String author = paraList[2].split("=")[1];
        author = URLDecoder.decode(author);
        ObjectBook book = new ObjectBook(getUUID(), book_name, price, author);
        try {
            //..............
            File file = new File("bookListFile");
            BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
            bw.write(book.getUid() + "," + book.getBook_name() + "," + book.getPrice() + "," + book.getAuthor());
            bw.newLine();
            bw.flush();
            //............
//            bookList.add(book);
            PrintStream writer = new PrintStream(socket.getOutputStream());
            writer.println("HTTP/1.0 200 OK");// 返回应答消息,并结束应答
            writer.println("Content-Type:text/json;charset=utf-8");//响应头
            writer.println("Content-Length:" + ("true").getBytes().length);// 返回内容字节数
            writer.println("hreader:Access-Control-Allow-Origin: *");// 返回内容字节数
            writer.println("hreader:Access-Control-Allow-Methods:GET");// 返回内容字节数
            writer.println("Access-Control-Allow-Headers:x-requested-with,content-type*");// 返回内容字节数
            writer.println();// 根据 HTTP 协议, 空行将结束头信息
            writer.write(("true").getBytes());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            try {
                PrintStream writer = new PrintStream(socket.getOutputStream());
                writer.println("HTTP/1.0 200 OK");// 返回应答消息,并结束应答
                writer.println("Content-Type:text/json;charset=utf-8");//响应头
                writer.println("Content-Length:" + ("false").getBytes().length);// 返回内容字节数
                writer.println("hreader:Access-Control-Allow-Origin: *");// 返回内容字节数
                writer.println("hreader:Access-Control-Allow-Methods:GET");// 返回内容字节数
                writer.println("Access-Control-Allow-Headers:x-requested-with,content-type*");// 返回内容字节数
                writer.println();// 根据 HTTP 协议, 空行将结束头信息
                writer.write(("false").getBytes());
                writer.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    //    删除书籍
    public void deleteBook(String uid, Socket socket) {
        System.out.println();
    }

    //    生成uid
    private static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "").toLowerCase();
    }

}
