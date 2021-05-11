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
public class CustomDoubleEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (StringUtils.isNotBlank(text)) {
            text = text.replaceAll(",", "");
            super.setValue(Double.valueOf(text));
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
