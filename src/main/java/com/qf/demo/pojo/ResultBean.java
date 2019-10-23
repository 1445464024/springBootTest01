package com.qf.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author YinZhi
 * 用来封装统一的访问结果信息
 */
@Data
@AllArgsConstructor
public class ResultBean<T> {

    private String status;
    private T data;
}
