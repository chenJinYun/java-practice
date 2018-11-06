package pers.kim.fsm.tcpclient;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class TcpClient {
//    public static void main(String[] args) {
//        Socket socket = null;
//        BufferedReader reader = null;
//        try {
//            socket = new Socket("localhost", 8800);
//            OutputStream outputStream = socket.getOutputStream();
//            InputStream inputStream = socket.getInputStream();
//            reader = new BufferedReader(new InputStreamReader(inputStream));
//            Scanner sc = new Scanner(System.in);
//            String next = sc.nextLine();
//            outputStream.write(next.getBytes());
//            String line = reader.readLine();
//            outputStream.write(line.getBytes());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }finally {
//            try {
//                if(reader != null){
//                    reader.close();
//                    socket.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//        }
//
//    }

    public static void main(String[] args) {
        try (Socket socket = new Socket("127.0.0.1", 8800)) {

            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            Scanner sc = new Scanner(System.in);
            String s = sc.nextLine();

            writer.write(s);
            writer.newLine();
            writer.flush();
            String line = reader.readLine();
            System.out.println(line);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
