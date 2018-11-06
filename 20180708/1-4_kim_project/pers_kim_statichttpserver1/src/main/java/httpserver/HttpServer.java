package httpserver;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {
    public static void main(String[] args) throws IOException {
        final ServerSocket server =new ServerSocket(9003);
        while (true) {
            final Socket socket=server.accept();
            new Thread(){
                @Override
                public void run() {
                    try {
                        OutputStream outputStream = socket.getOutputStream();
                        InputStream in=socket.getInputStream();
                        BufferedReader reader=new BufferedReader(new InputStreamReader(in));
                        String line=reader.readLine();
                        System.out.println(line);
                        CallMethod res=new CallMethod();
                        res.getFile(line,socket);
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
