package com.example.fiercepigeon.model.vo;

import com.example.fiercepigeon.model.entity.User;
import lombok.Data;

/**
 * @author： FardlyP
 * @description： TODO
 * @date： 2021/3/25 16:17
 * @version: 1.0
 */
@Data
public class UserData extends User {

    private Integer playedCnt;
    private Integer gedCnt;
    private Integer totalCnt;
    private Double geRate;
}
