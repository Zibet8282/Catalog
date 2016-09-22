package com.test.catalog.domain.adapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by OleksiiPa on 21.09.2016.
 */
public class DateAdapter extends XmlAdapter<String, Date> {

    private static final String format = "yyyy-MM-dd";
    public Date unmarshal(String v) throws Exception {
        return new SimpleDateFormat(format).parse(v);
    }

    public String marshal(Date v) throws Exception {
        return new SimpleDateFormat(format).format(v);
    }
}
