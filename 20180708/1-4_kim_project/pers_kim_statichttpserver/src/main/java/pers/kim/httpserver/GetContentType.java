package pers.kim.httpserver;

public class GetContentType {
    public String getContentType(String path){
        //                根据请求资源返回不同的响应头
        String lastName=path.substring(path.indexOf(".")+1);
        String name="";
        if(lastName.equals("html")){
            name="text/html";
        } else if(lastName.equals("js")){
            name="application/javascript";
        } else if(lastName.equals("css")){
            name="text/css";
        } else {
            name="image/"+lastName;
        }
        return name;
    }
}
