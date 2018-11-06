package pers.kim.fsm.callmethodbyinstruction;

import pers.kim.fsm.fileoptions.CopyFile;
import pers.kim.fsm.fileoptions.DeleteFile;
import pers.kim.fsm.fileoptions.FileList;

import java.io.IOException;

public class CallMethod {
    public String getMethod(String str) throws IOException {
//		CopyFile cpFile=new CopyFile();
//		DeleteFile deFile=new DeleteFile();
        FileList fileList = new FileList();
        if (str.equals("ls")) {
            StringBuilder sb = new StringBuilder();
            String[] fileString = fileList.showFileList("file");
            for (String s : fileString) {
                sb.append(s).append("\n");
            }
            return sb.toString();
        } else if (str.contains("rm")) {
            String fileName = str.substring(str.indexOf("m") + 2);
            DeleteFile.deleteFile(fileName);
            return "True";
        } else if (str.equals("cp")) {
            CopyFile.copyFile("file", "copyFile");
            return "True";
        } else {
            return "This order id not correct,please input again!";
        }
    }

}
