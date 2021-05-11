package com.example.fiercepigeon.config.editor;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.beans.PropertyEditorSupport;

/**
 * description <br>
 *
 * @author yanbiao6
 * @create 2018/11/23
 * @since 1.0.0
 */
@Slf4j
public class CustomIntegerEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (StringUtils.isNotBlank(text) && !"null".equalsIgnoreCase(text)) {
            text = text.replaceAll(",", "");
            try {
                super.setValue(Integer.valueOf(text));
                Integer a = 10;
                a.equals(10);
            } catch (Exception e) {
                HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
                log.info("接收参数出错:uri:{}", req.getRequestURI());
                throw e;
            }
        } else {
            super.setValue(null);
        }
    }

    @Override
    public String getAsText() {
        Object obj = super.getValue();
        String text = null;
        if (obj != null && obj instanceof String) {
            text = obj.toString().replaceAll(",", "");
        }
        return text;
    }

}
