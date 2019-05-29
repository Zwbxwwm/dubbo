package com.stylefeng.guns.rest.modular.cinema;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.API.User.IUserAPI;
import com.stylefeng.guns.API.Vo.*;
import com.stylefeng.guns.API.Vo.ApiVo.CinemaVo;
import com.stylefeng.guns.API.cinema.ICinemaAPI;
import com.stylefeng.guns.API.from.CinemaFom;
import com.stylefeng.guns.rest.common.*;
import com.stylefeng.guns.rest.common.MoocAreaDictTMapper;
import com.stylefeng.guns.rest.common.MoocBrandDictTMapper;
import com.stylefeng.guns.rest.common.MoocCinemaTMapper;
import com.stylefeng.guns.rest.common.MoocFieldTMapper;
import com.stylefeng.guns.rest.common.MoocHallDictTMapper;
import com.stylefeng.guns.rest.common.converter.MoocAreaDictT2CinemaAreaVo;
import com.stylefeng.guns.rest.common.converter.MoocBrandDictT2CinemaBrandVo;
import com.stylefeng.guns.rest.common.converter.MoocCinemaT2CinemaVo;
import com.stylefeng.guns.rest.common.converter.MoocHallDictT2CinemaHallTypeVo;
import com.stylefeng.guns.rest.common.persistence.model.MoocAreaDictT;
import com.stylefeng.guns.rest.common.persistence.model.MoocBrandDictT;
import com.stylefeng.guns.rest.common.persistence.model.MoocCinemaT;
import com.stylefeng.guns.rest.common.persistence.model.MoocHallDictT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.xml.ws.spi.WebServiceFeatureAnnotation;
import java.util.ArrayList;
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

    @Autowired
    private MoocCinemaTMapper moocCinemaTMapper;

    @Autowired
    private MoocBrandDictTMapper moocBrandDictTMapper;

    @Autowired
    private MoocAreaDictTMapper moocAreaDictTMapper;

    @Autowired
    private MoocHallDictTMapper moocHallDictTMapper;

    @Override
    public Page<CinemaVo> getCinemas(CinemaFom cinemaFom) {
        List<CinemaVo> cinemaVoList = new ArrayList<>();

        Page<MoocCinemaT> cinemaTPage = new Page<>(cinemaFom.getNowPage(),cinemaFom.getPageSize());

        //判断id是否显示全部
        EntityWrapper<MoocCinemaT> cinemaTEntityWrapper = new EntityWrapper<>();
        if(cinemaFom.getBrandId() != 99){
            cinemaTEntityWrapper.eq("brand_id",cinemaFom.getBrandId());
        }
        if(cinemaFom.getDistrictId() != 99){
            cinemaTEntityWrapper.eq("area_id",cinemaFom.getDistrictId());
        }
        if(cinemaFom.getHallType() != 99){
            cinemaTEntityWrapper.like("hall_ids","%#"+cinemaFom.getHallType()+"#%");
        }

        //业务对象转变成业务实体
        List<MoocCinemaT> cinemaTS = moocCinemaTMapper.selectPage(cinemaTPage,cinemaTEntityWrapper);

        //业务实体转成展示层实体
        for(MoocCinemaT moocCinemaT: cinemaTS){
            cinemaVoList.add(MoocCinemaT2CinemaVo.converter(moocCinemaT));
        }

        //返回Page对象
        long count = moocCinemaTMapper.selectCount(cinemaTEntityWrapper);
        Page<CinemaVo> result =new Page<>();
        result.setRecords(cinemaVoList);
        result.setSize(cinemaFom.getPageSize());
        result.setTotal(count);

        return result;
    }

    @Override
    public List<CinemaBrandVo> getBrands(int brandId) {

        //创建返回的对象
        List<CinemaBrandVo> cinemaBrandVos = new ArrayList<>();

        //根据在数据库中查找数据，检验该分类在数据库中是否存在
        MoocBrandDictT moocBrandDictT = moocBrandDictTMapper.selectById(brandId);

        List<MoocBrandDictT> brandDictTS = moocBrandDictTMapper.selectList(null);

        boolean flag = true;
        if(brandId == 99 || moocBrandDictT == null ){
            flag = false;
        }

        for(MoocBrandDictT moocBrand : brandDictTS){
            CinemaBrandVo cinemaBrandVo = new CinemaBrandVo();
            cinemaBrandVo = MoocBrandDictT2CinemaBrandVo.converter(moocBrand);
            if(flag){
                if(moocBrandDictT.getUuid() == brandId){
                    cinemaBrandVo.setActive(true);
                }
            }else {
                cinemaBrandVo.setActive(true);
            }
            cinemaBrandVos.add(cinemaBrandVo);
        }
        return cinemaBrandVos;
    }

    @Override
    public List<CinemaAreaVo> getAreas(int areaId) {
        //创建返回的对象
        List<CinemaAreaVo> cinemaAreaVos = new ArrayList<>();

        //根据在数据库中查找数据，检验该分类在数据库中是否存在
        MoocAreaDictT moocAreaDictT =moocAreaDictTMapper.selectById(areaId);

        List<MoocAreaDictT> areaDictTS = moocAreaDictTMapper.selectList(null);

        boolean flag = true;
        if(areaId == 99 || moocAreaDictT == null ){
            flag = false;
        }

        for(MoocAreaDictT moocArea : areaDictTS){
            CinemaAreaVo cinemaAreaVo = new CinemaAreaVo();
            cinemaAreaVo = MoocAreaDictT2CinemaAreaVo.converter(moocArea);
            if(flag){
                if(moocArea.getUuid() == areaId){
                    cinemaAreaVo.setActive(true);
                }
            }else {
                cinemaAreaVo.setActive(true);
            }
            cinemaAreaVos.add(cinemaAreaVo);
        }
        return cinemaAreaVos;
    }

    @Override
    public List<CinemaHallTypeVo> getHallType(int hallTypes) {
        //创建返回的对象
        List<CinemaHallTypeVo> cinemaHallTypeVos = new ArrayList<>();

        //根据在数据库中查找数据，检验该分类在数据库中是否存在
        MoocHallDictT moocHallDictT =moocHallDictTMapper.selectById(hallTypes);

        List<MoocHallDictT> hallDictTS = moocHallDictTMapper.selectList(null);

        boolean flag = true;
        if(hallTypes == 99 || moocHallDictT == null ){
            flag = false;
        }

        for(MoocHallDictT moocHall : hallDictTS){
            CinemaHallTypeVo cinemaHallTypeVo = new CinemaHallTypeVo();
            cinemaHallTypeVo = MoocHallDictT2CinemaHallTypeVo.converter(moocHall);
            if(flag){
                if(moocHall.getUuid() == hallTypes){
                    cinemaHallTypeVo.setActive(true);
                }
            }else {
                cinemaHallTypeVo.setActive(true);
            }
            cinemaHallTypeVos.add(cinemaHallTypeVo);
        }
        return cinemaHallTypeVos;
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
