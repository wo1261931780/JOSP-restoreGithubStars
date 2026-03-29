package wo1261931780.JOSP_restoreGithubStars.config;

import lombok.Data;

/**
 * 统一返回结果封装
 * @param <T> 返回数据类型
 */
@Data
public class ShowResult<T> {
    /**
     * 状态码 (20000=成功, 0=失败)
     */
    private Integer code;
    
    /**
     * 返回消息
     */
    private String msg;
    
    /**
     * 返回数据
     */
    private T data;

    /**
     * 成功返回
     */
    public static <T> ShowResult<T> sendSuccess(T data) {
        ShowResult<T> result = new ShowResult<>();
        result.setCode(20000);
        result.setData(data);
        return result;
    }

    /**
     * 成功返回(带消息)
     */
    public static <T> ShowResult<T> sendSuccess(T data, String msg) {
        ShowResult<T> result = new ShowResult<>();
        result.setCode(20000);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

    /**
     * 失败返回
     */
    public static <T> ShowResult<T> sendError(String msg) {
        ShowResult<T> result = new ShowResult<>();
        result.setCode(0);
        result.setMsg(msg);
        return result;
    }

    /**
     * 失败返回(带状态码)
     */
    public static <T> ShowResult<T> sendError(Integer code, String msg) {
        ShowResult<T> result = new ShowResult<>();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
