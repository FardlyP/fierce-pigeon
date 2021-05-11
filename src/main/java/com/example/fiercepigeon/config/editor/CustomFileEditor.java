package com.example.fiercepigeon.config.editor;

import java.beans.PropertyEditorSupport;

/**
 * description <br>
 *
 * @author yanbiao6
 * @create 2018/11/23
 * @since 1.0.0
 */
public class CustomFileEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {

    }

    @Override
    public void setValue(Object value) {
        if (value == null || value instanceof String) {
            super.setValue(null);
        } else {
            super.setValue(value);
        }
    }

}
