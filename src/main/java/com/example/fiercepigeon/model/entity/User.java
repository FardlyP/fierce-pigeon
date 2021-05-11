package com.example.fiercepigeon.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * @author： FardlyP
 * @description： 猛鸽用户信息
 * @date： 2021/3/12 15:59
 * @version: 1.0
 */
@Data
@Table(name = "user_info")
public class User {

    private static final long serialVersionUID = 1L;

    @Id
    @KeySql(useGeneratedKeys = true)
    @Column(name = "id", insertable = false)
    private Integer id;
    private String nickname;
    private String openId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    @Override
    public String toString() {
        return "openId:" + this.getOpenId() + " nickname:" + this.getNickname();
    }
}
