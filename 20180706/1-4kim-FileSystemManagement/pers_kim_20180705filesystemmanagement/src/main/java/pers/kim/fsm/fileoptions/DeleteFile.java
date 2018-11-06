package pers.kim.fsm.fileoptions;

import java.io.File;

public class DeleteFile {
    //	public static void main(String[] args) {
//		String fileName="a.txt";
//		String path="./file";
//		deleteFile(fileName,path);
//	}
    public static void deleteFile(String path) {
        File originFile = new File(path);
        if(originFile.exists()){
            if(originFile.isFile()){
                originFile.delete();
            }else{
                deleteDirFile(originFile);
                originFile.delete();
            }
        }
    }

    private static void deleteDirFile(File originFile) {
        File[] list = originFile.listFiles();
        if (list != null) {
            for (File file : list) {
                if (file.isDirectory()) {
                    deleteDirFile(file);
                    file.delete();
                } else {
                    file.delete();
                }
            }
        } else {
            originFile.delete();
        }
    }
}
