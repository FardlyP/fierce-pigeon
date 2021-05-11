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
 * @description： 猛鸽球局报名信息
 * @date： 2021/3/13 12:36
 * @version: 1.0
 */
@Data
@Table(name = "play_info")
public class Play {

    private static final long serialVersionUID = 1L;

    @Id
    @KeySql(useGeneratedKeys = true)
    @Column(name = "id", insertable = false)
    private Integer id;
    private Integer gameId;
    private String openId;
    private Integer zanCnt;
    private Integer youCnt;
    private Integer deleted;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

}
