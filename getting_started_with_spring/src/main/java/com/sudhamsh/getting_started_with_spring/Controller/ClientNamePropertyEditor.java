package com.sudhamsh.getting_started_with_spring.Controller;

import java.beans.PropertyEditor;
import java.beans.PropertyEditorSupport;

public class ClientNamePropertyEditor extends PropertyEditorSupport {
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
//        System.out.println(text.substring(0,1).toUpperCase()+text.substring(1).toLowerCase());
        setValue( "Name");

    }
}
