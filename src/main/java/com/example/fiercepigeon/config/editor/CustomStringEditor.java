package com.example.fiercepigeon.config.editor;

import org.apache.commons.lang3.StringUtils;

import java.beans.PropertyEditorSupport;

/**
 * description <br>
 *
 * @author yanbiao6
 * @create 2018/11/23
 * @since 1.0.0
 */
public class CustomStringEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) {
        if (StringUtils.isNotEmpty(text)) {
            String value = text;
            setValue(value);
        }
    }

    @Override
    public String getAsText() {
        Object value = getValue();
        return value != null ? value.toString() : null;
    }
}
