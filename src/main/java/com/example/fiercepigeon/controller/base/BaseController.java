package com.example.fiercepigeon.controller.base;

import com.example.fiercepigeon.config.editor.*;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

/**
 * description <br>
 * 〈controller类父类〉
 * <p>
 * 页面请求的数据通过此类将会自动进行参数转化
 * 所有controller都要继承该类
 *
 * @author yanbiao6
 * @create 2018/11/23
 * @since 1.0.0
 */
public class BaseController {

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(MultipartFile.class, new CustomFileEditor());
        binder.registerCustomEditor(Double.class, new CustomDoubleEditor());
        binder.registerCustomEditor(Float.class, new CustomFloatEditor());
        binder.registerCustomEditor(Integer.class, new CustomIntegerEditor());
        binder.registerCustomEditor(Long.class, new CustomLongEditor());
        binder.registerCustomEditor(String.class, new CustomStringEditor());
        binder.registerCustomEditor(BigDecimal.class, new CustomBigDecimalEditor());
    }
}
