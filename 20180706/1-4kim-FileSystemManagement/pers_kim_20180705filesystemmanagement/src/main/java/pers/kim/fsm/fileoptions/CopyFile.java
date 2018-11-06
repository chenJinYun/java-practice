package pers.kim.fsm.fileoptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyFile {
//	public static void main(String[] args) throws IOException {
//		String oldPath = "./file";
//		String newPath = "./copyFile";
//		copyFile(oldPath, newPath);
//	}

	public static void copyFile(String oldPath, String newPath) throws IOException {
		// 获取文件列表
		File file = new File(oldPath);
		if (!(new File(newPath)).exists()) {
			(new File(newPath)).mkdir();
		}
		if (file.isDirectory()) {
			for (int i = 0; i < file.list().length; i++) {
//				System.out.println(file.list()[i]);
				File fileItem = new File(oldPath + "/" + file.list()[i]);
				if (fileItem.isDirectory()) {
					copyFile(oldPath + "/" + file.list()[i], newPath);
				} else {
					// 是文件则复制到新的文件夹
					File newFileItem = new File(newPath + "/" + file.list()[i]);
					InputStream inputStream = new FileInputStream(fileItem);
					OutputStream outputStream = new FileOutputStream(newFileItem);
					byte[] buf = new byte[inputStream.available()];
					inputStream.read(buf);
					outputStream.write(buf);
					inputStream.close();
					outputStream.close();
				}
			}
		}

	}
}
