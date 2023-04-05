package DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@Setter
@Getter
//统一返回结果
public class Result implements Serializable {
    private String msg;
    private Boolean success;
    private Object data;
    private List list;
    private Integer total;


    public static @NotNull Result success(){
        return new Result("success", true, null, null, null);
    }

    public static @NotNull Result success(Object data) {
        return new Result("success", true, data, null, null);
    }

    public static @NotNull Result success(Object data, List list, Integer total) {
        return new Result("success", true, data, list, total);
    }

    public static @NotNull Result fail(String msg) {
        return new Result(msg, false, null, null, null);
    }




}
