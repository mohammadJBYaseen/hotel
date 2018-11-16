package com.myaseen.hotel.util;

import com.myaseen.hotel.exception.DateConversionException;
import com.myaseen.hotel.model.DateFormat;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
@Component
public class ISOLocalDateConverter implements DateConverter {

    private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");


    @Override
    public Date convertDate(String date) throws DateConversionException {
        try {
            return formatter.parse(date);
        } catch (ParseException e) {
            throw new DateConversionException(date);
        }
    }

    @Override
    public DateFormat getApplicableFormat() {
        return DateFormat.ISO_LOCAL;
    }
}
