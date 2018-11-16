package com.myaseen.hotel.util;

import com.myaseen.hotel.exception.DataException;
import com.myaseen.hotel.model.DateFormat;

import java.util.Date;

public interface DateConverter {

    Date convertDate(String date) throws DataException;

    DateFormat getApplicableFormat();

}
