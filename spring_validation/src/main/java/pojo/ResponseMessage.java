package pojo;

/**
 *
 * Response信息封装
 *
 * @author Burgess Li
 * @version 1.0
 * @date 7/31/2018 10:34 AM
 **/
public class ResponseMessage {

    private Object content;
    private String message;
    private Integer resultCode;

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getResultCode() {
        return resultCode;
    }

    public void setResultCode(Integer resultCode) {
        this.resultCode = resultCode;
    }
}
