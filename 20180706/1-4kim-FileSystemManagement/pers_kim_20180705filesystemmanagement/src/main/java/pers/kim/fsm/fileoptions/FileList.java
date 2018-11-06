package pers.kim.fsm.fileoptions;

import java.io.File;

public class FileList {
//	public void main(String[] args) {
//		String[] strings=showFileList("./file");
//		for (int i = 0; i < strings.length; i++) {
//			System.out.println(strings[i]);
//		}
//	}
	public String[] showFileList(String path) {
		File file=new File(path);
		return file.list();
	}
}
