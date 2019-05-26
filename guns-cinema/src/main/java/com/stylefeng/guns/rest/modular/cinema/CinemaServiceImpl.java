package com.stylefeng.guns.rest.modular.cinema;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.API.User.IUserAPI;
import com.stylefeng.guns.API.Vo.*;
import com.stylefeng.guns.API.Vo.ApiVo.CinemaVo;
import com.stylefeng.guns.API.cinema.ICinemaAPI;
import com.stylefeng.guns.API.from.CinemaFom;
import com.stylefeng.guns.rest.common.MoocFieldTMapper;
import com.stylefeng.guns.rest.common.persistence.model.MoocCinemaT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @program: guns-parent
 * @description: 影院模块service层实现
 * @author: Zwb
 * @create: 2019-05-26 17:38
 **/

@Component
@Service(interfaceClass = ICinemaAPI.class)

public class CinemaServiceImpl implements ICinemaAPI {

    @Autowired
    private MoocFieldTMapper moocFieldTMapper;

    @Override
    public Page<CinemaVo> getCinemas(CinemaFom cinemaFom) {
        EntityWrapper<MoocCinemaT> cinemaTEntityWrapper = new EntityWrapper<>();
        if(cinemaFom.getBrandId() != 99){
            cinemaTEntityWrapper.eq("brand_id",cinemaFom.getBrandId());
        }
        if(cinemaFom.getDistrictId() != 99){
            cinemaTEntityWrapper.eq("area_id",cinemaFom.getDistrictId());
        }
        if(cinemaFom.getHallType() != 99){
            cinemaTEntityWrapper.like("hall_ids","%"+cinemaFom.getHallType()+"%");
        }
        return null;
    }

    @Override
    public List<CinemaBrandVo> getBrands(int brandId) {
        return null;
    }

    @Override
    public List<CinemaAreaVo> getAreas(int areaId) {
        return null;
    }

    @Override
    public List<CinemaHallTypeVo> getHallType(int hallTypes) {
        return null;
    }

    @Override
    public CinemaInfoVo getCinemaInfoById(int cinemaId) {
        return null;
    }

    @Override
    public CinemaFilmInfoVo getCinemaFilmInfo(int cinemaId) {
        return null;
    }

    @Override
    public CinemaFilmFieldVo getFilmField(int fieldId) {
        return null;
    }

    @Override
    public CinemaFilmInfoVo getFilmInfoByFieldId(int fieldId) {
        return null;
    }
}
