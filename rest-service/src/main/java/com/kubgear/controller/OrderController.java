package com.kubgear.controller;

import com.kubgear.service.order.OrderService;
import com.kubgear.time.GetTimeCalendar;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;
import com.kubgear.service.product.ProductDescriptionService;
import time.TimeConfiguration;

import javax.xml.datatype.XMLGregorianCalendar;

/**
 * todo Document type OrderController
 */
@RestController
@AllArgsConstructor
@Log
@RequestMapping("/order")
public class OrderController {

    private ProductDescriptionService productDescriptionService;

    @GetMapping("/save")
    public void save(){
        productDescriptionService.save();
    }

    @PutMapping("/update")
    public void updateFileProduct(){
        productDescriptionService.save();
    }

    @GetMapping("/time")
    public XMLGregorianCalendar getTime(){
       return GetTimeCalendar.getCalendar();
    }
}
