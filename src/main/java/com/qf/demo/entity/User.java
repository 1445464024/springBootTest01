package com.qf.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author YinZhi
 */
public class User {

    @JsonIgnore
    private Long id;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @NotNull(message = "用户名不能为空")
    private String name;
    //@JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date entryDate;

    public User(Long id, String name, Date entryDate) {
        this.id = id;
        this.name = name;
        this.entryDate = entryDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }
}
