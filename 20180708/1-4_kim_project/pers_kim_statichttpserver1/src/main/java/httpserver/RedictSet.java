package httpserver;

public class RedictSet {
    private String url;
    private String port;

    public RedictSet(String url, String port) {
        this.url = url;
        this.port = port;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
