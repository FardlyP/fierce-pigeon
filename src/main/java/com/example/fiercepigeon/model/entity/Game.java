package com.example.fiercepigeon.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author： FardlyP
 * @description： 猛鸽球局信息
 * @date： 2021/3/13 12:34
 * @version: 1.0
 */
@Data
@Table(name = "game_info")
public class Game {

    private static final long serialVersionUID = 1L;

    @Id
    @KeySql(useGeneratedKeys = true)
    @Column(name = "id", insertable = false)
    private Integer id;
    private Date date;
    private String time;
    private String gym;
    private Integer siteNo;
    private Integer num;
    private String declaration;
    private Integer done;
    private String creator;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

}
