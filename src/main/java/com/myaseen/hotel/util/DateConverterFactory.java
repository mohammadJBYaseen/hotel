package com.myaseen.hotel.util;

import com.myaseen.hotel.model.DateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class DateConverterFactory {

    private Map<DateFormat,DateConverter> converters = new HashMap<>();
    private DateConverter defaultCon;

    @Autowired
    public DateConverterFactory(List<DateConverter> converters){
        for(DateConverter dateConverter:converters){
            this.converters.put(dateConverter.getApplicableFormat(),dateConverter);
        }
        defaultCon = this.converters.get(DateFormat.ISO_LOCAL);
        if(defaultCon == null){
            throw  new IllegalStateException("can't find default converter for Date format "+DateFormat.ISO_LOCAL);
        }
    }

    public DateConverter getDateConverter(DateFormat dateFormat){
        if(dateFormat == null){
            return converters.get(DateFormat.ISO_LOCAL);
        }else{
            return converters.getOrDefault(dateFormat,defaultCon);
        }
    }

}
