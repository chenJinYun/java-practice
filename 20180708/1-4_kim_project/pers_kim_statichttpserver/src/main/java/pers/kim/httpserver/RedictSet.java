package pers.kim.httpserver;

public class RedictSet {
    private String url;
    private int port;

    public RedictSet(String url, int port) {
        this.url = url;
        this.port = port;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
