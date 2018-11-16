package com.myaseen.hotel;

import com.myaseen.hotel.exception.DataException;
import com.myaseen.hotel.model.DateFormat;
import com.myaseen.hotel.util.DateConverter;
import com.myaseen.hotel.util.DateConverterFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HotelApplicationTests {

    @Autowired
    DateConverterFactory factory;
    @Test
    public void contextLoads() {
    }



    @Test(expected = Test.None.class)
    public void testISOINSTANDate() throws DataException {
        DateConverter dateConverter = factory.getDateConverter(DateFormat.ISO_INSTANT);
        dateConverter.convertDate("2018-11-16T11:24:16.177+0200");
    }

    @Test(expected = Test.None.class)
    public void testISOLOCALDate() throws DataException {
        DateConverter dateConverter = factory.getDateConverter(DateFormat.ISO_LOCAL);
        dateConverter.convertDate("2010-12-27");
    }

}
