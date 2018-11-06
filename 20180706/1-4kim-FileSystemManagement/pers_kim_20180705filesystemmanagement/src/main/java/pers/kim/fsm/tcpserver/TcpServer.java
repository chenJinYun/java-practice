package pers.kim.fsm.tcpserver;

import pers.kim.fsm.callmethodbyinstruction.CallMethod;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
//	public static void main(String[] args) throws IOException {
//		ServerSocket serverSocket = new ServerSocket(8800);// 端口号
//		Socket socket = serverSocket.accept();
//		InputStream inputStream = socket.getInputStream();
//		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
//		OutputStream outputStream = socket.getOutputStream();
////		outputStream.write("please input your order\n".getBytes());
//		String line = reader.readLine();
//		CallMethod method=new CallMethod();
//		String res= method.getMethod(line);
//		outputStream.write(res.getBytes());
////		System.out.println(res);
//		outputStream.close();
//		socket.close();
//		serverSocket.close();
//	}

	public static void main(String[] args) {
		try (ServerSocket serverSocket = new ServerSocket(8800)) {

			Socket accept = serverSocket.accept();
			BufferedReader reader = new BufferedReader(new InputStreamReader(accept.getInputStream()));
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(accept.getOutputStream()));
//			byte[] bytes = new byte[1024];
//			int len = inputStream.read(bytes);
//			System.out.println("客户端说：" + new String(bytes,0,len));
			String line = reader.readLine();
			CallMethod method=new CallMethod();
		    String res= method.getMethod(line);
			writer.write(res);
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
