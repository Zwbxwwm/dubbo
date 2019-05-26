package com.stylefeng.guns.rest.cinema;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.API.cinema.ICinemaAPI;
import com.stylefeng.guns.API.from.CinemaFom;
import com.stylefeng.guns.rest.common.response.ServerResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.Serializable;

/**
 * @program: guns-parent
 * @description: 影院controller层
 * @author: Zwb
 * @create: 2019-05-26 05:39
 **/

@RestController
@RequestMapping("/cinema")
public class cinemaController {


    @Reference(interfaceClass = ICinemaAPI.class,check = false)
    private ICinemaAPI iCinemaAPI;


    @GetMapping("/getCinemas")
    public ServerResponse getCinemas(@Valid CinemaFom cinemaFom){
        return null;
    }

    @GetMapping("/getCondition")
    public ServerResponse getCondition(@Valid CinemaFom cinemaFom){
        return null;
    }

    @RequestMapping("/getFields")
    public ServerResponse getFields(Integer cinemaId){
        return null;
    }

    @PostMapping("/getFieldInfo")
    public ServerResponse getFieldInfo(@RequestParam("cinemaId") Integer cinemaId, @RequestParam("fieldId") Integer fieldId){
        return null;
    }
}
