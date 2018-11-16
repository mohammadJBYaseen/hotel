package com.myaseen.hotel.controller;

import com.myaseen.hotel.controller.params.AvailableHotelsReq;
import com.myaseen.hotel.controller.response.AvailableHotelsResponse;
import com.myaseen.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hotels")
public class AvailableHotelController {

    @Autowired
    HotelService hotelService;

    @RequestMapping(value = "/getAvailable",produces = MediaType.APPLICATION_JSON_UTF8_VALUE,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public AvailableHotelsResponse getAvailableHotels(@RequestBody AvailableHotelsReq req){
        return null;
    }

    @RequestMapping(value = "/getAvailable/{providerCode}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE,consumes =
            MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public AvailableHotelsResponse getAvailableHotel(@PathVariable("providerCode") String providerCode,
                                                     @RequestBody AvailableHotelsReq req){
        return null;
    }
}
