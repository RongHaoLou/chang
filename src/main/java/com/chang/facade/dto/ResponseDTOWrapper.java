package com.chang.facade.dto;

/**
 * @author 常培兵
 * @Description: 全局返回json格式
 * @date 2018/3/22 10:06
 */
public class ResponseDTOWrapper {
    private boolean success;        //是否成功
    private Object data;            //返回数据
    private String message;         //返回信息

    public ResponseDTOWrapper(boolean success, Object data, String message) {
        this.success = success;
        this.data = data;
        this.message = message;
    }

    public ResponseDTOWrapper() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ResponseDTOWrapper that = (ResponseDTOWrapper) o;

        if (success != that.success) return false;
        if (data != null ? !data.equals(that.data) : that.data != null) return false;
        return message != null ? message.equals(that.message) : that.message == null;
    }

    @Override
    public int hashCode() {
        int result = (success ? 1 : 0);
        result = 31 * result + (data != null ? data.hashCode() : 0);
        result = 31 * result + (message != null ? message.hashCode() : 0);
        return result;
    }


    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
