package com.hendisantika.thymeleafangularjs.report;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : thymeleaf-angularjs
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 10/05/18
 * Time: 06.10
 * To change this template use File | Settings | File Templates.
 */
public class CustomJRDataSource<T> implements JRDataSource {

    Iterator<T> it;
    Object currentElement;

    @Override
    public boolean next() {
        if (it.hasNext()) {
            currentElement = it.next();
            return true;
        } else {
            return false;
        }

    }

    @Override
    public Object getFieldValue(JRField jrField) throws JRException {

        BeanInfo info;
        try {
            info = Introspector.getBeanInfo(currentElement.getClass());
            for (PropertyDescriptor pd : info.getPropertyDescriptors()) {
                if (pd.getName().equals(jrField.getName())) {
                    Method reader = pd.getReadMethod();
                    return reader.invoke(currentElement);
                }
            }
        } catch (Exception e) {
            throw new JRException(e);
        }

        throw new JRException("Field " + jrField.getName() + " error");
    }

    public CustomJRDataSource<T> initBy(List<T> list) {
        this.it = list.iterator();
        return this;
    }
}