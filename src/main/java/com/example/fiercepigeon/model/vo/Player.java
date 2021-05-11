package com.example.fiercepigeon.model.vo;

import com.example.fiercepigeon.model.entity.Play;
import lombok.Data;

/**
 * @author： FardlyP
 * @description： TODO
 * @date： 2021/4/1 14:16
 * @version: 1.0
 */
@Data
public class Player extends Play {

    private String nickname;

    private String zanImg;

    private String youImg;

}
