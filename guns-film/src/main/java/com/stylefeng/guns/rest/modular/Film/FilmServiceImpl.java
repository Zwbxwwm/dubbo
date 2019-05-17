package com.stylefeng.guns.rest.modular.Film;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.API.Film.IFilmAPI;
import com.stylefeng.guns.API.Vo.*;

import com.stylefeng.guns.rest.common.converter.FilmT2FilmInfo;
import com.stylefeng.guns.rest.common.persistence.dao.*;
import com.stylefeng.guns.rest.common.persistence.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: guns-parent
 * @description: 影院模块service层实现
 * @author: Zwb
 * @create: 2019-05-14 17:12
 **/

@Component
@Service(interfaceClass = IFilmAPI.class)
public class FilmServiceImpl implements  IFilmAPI{

    @Autowired
    private MoocBannerTMapper moocBannerTMapper;

    @Autowired
    private MoocFilmTMapper moocFilmTMapper;

    @Autowired
    private MoocCatDictTMapper moocCatDictTMapper;

    @Autowired
    private  MoocSourceDictTMapper moocSourceDictTMapper;

    @Autowired
    private MoocYearDictTMapper moocYearDictTMapper;

    @Override
    public List<BannerVo> getBanners() {
        List<MoocBannerT> bannerTS = moocBannerTMapper.selectList(null);
        List<BannerVo> bannerVos = new ArrayList<>();
        for(MoocBannerT moocBannerT: bannerTS){
            BannerVo bannerVo = new BannerVo();
            bannerVo.setBannerId(moocBannerT.getUuid()+"");
            bannerVo.setBannerUrl(moocBannerT.getBannerUrl());
            bannerVo.setBannerAddress(moocBannerT.getBannerAddress());
            bannerVos.add(bannerVo);
        }
        return bannerVos;
    }

    @Override
    public FilmsVo getHotFilms(boolean isLimit, int nums) {
        FilmsVo filmsVo = new FilmsVo();
        List<FilmInfo> filmInfos = new ArrayList<>();
        //查找所有热映影片
        EntityWrapper<MoocFilmT> moocFilmTEntityWrapper = new EntityWrapper<>();
        moocFilmTEntityWrapper.eq("film_status","1");
        //是否是首页所需
        if(isLimit){
            Page<MoocFilmT> filmTPage = new Page<>(1,nums);
            List<MoocFilmT> filmTS = moocFilmTMapper.selectPage(filmTPage,moocFilmTEntityWrapper);
            for(MoocFilmT filmT:filmTS){
                FilmInfo filmInfo = new FilmInfo();
                filmInfo = FilmT2FilmInfo.converter(filmT);
                filmInfos.add(filmInfo);
            }
            filmsVo.setFilmNum(filmInfos.size());
            filmsVo.setFilmInfo(filmInfos);

        }else{

        }
        return filmsVo;
    }

    @Override
    public FilmsVo getSoonFilms(boolean isLimit, int nums) {
        FilmsVo filmsVo = new FilmsVo();
        List<FilmInfo> filmInfos = new ArrayList<>();
        //查找所有热映影片
        EntityWrapper<MoocFilmT> moocFilmTEntityWrapper = new EntityWrapper<>();
        moocFilmTEntityWrapper.eq("film_status","2");
        //是否是首页所需
        if(isLimit){
            Page<MoocFilmT> filmTPage = new Page<>(1,nums);
            List<MoocFilmT> filmTS = moocFilmTMapper.selectPage(filmTPage,moocFilmTEntityWrapper);
            for(MoocFilmT filmT:filmTS){
                FilmInfo filmInfo = new FilmInfo();
                filmInfo = FilmT2FilmInfo.converter(filmT);
                filmInfos.add(filmInfo);
            }
            filmsVo.setFilmNum(filmInfos.size());
            filmsVo.setFilmInfo(filmInfos);

        }else{

        }
        return filmsVo;
    }

    @Override
    public List<FilmInfo> getBoxRanKing() {
        //正在上映的电影前十名
        EntityWrapper<MoocFilmT> moocFilmTEntityWrapper = new EntityWrapper<>();
        moocFilmTEntityWrapper.eq("film_status","1");
        //定义Page对象并且按照film_box_office字段进行排序
        Page<MoocFilmT> filmTPage = new Page<>(1,10,"film_box_office");
        List<MoocFilmT> moocFilmTS = moocFilmTMapper.selectPage(filmTPage,moocFilmTEntityWrapper);

        //封装成List<FilmInfo>
        List<FilmInfo> filmInfos = new ArrayList<>();
        for(MoocFilmT filmT: moocFilmTS){
            FilmInfo filmInfo = new FilmInfo();
            filmInfo =FilmT2FilmInfo.converter(filmT);
            filmInfos.add(filmInfo);
        }
        return filmInfos;
    }

    @Override
    public List<FilmInfo> getExpectRanKing() {

        //预售电影前十名
        EntityWrapper<MoocFilmT> moocFilmTEntityWrapper = new EntityWrapper<>();
        moocFilmTEntityWrapper.eq("film_status","2");

        //定义Page对象并且按照film_box_office字段进行排序
        Page<MoocFilmT> filmTPage = new Page<>(1,10,"film_preSaleNum");
        List<MoocFilmT> moocFilmTS = moocFilmTMapper.selectPage(filmTPage,moocFilmTEntityWrapper);

        //封装成List<FilmInfo>
        List<FilmInfo> filmInfos = new ArrayList<>();
        for(MoocFilmT filmT: moocFilmTS){
            FilmInfo filmInfo = new FilmInfo();
            filmInfo =FilmT2FilmInfo.converter(filmT);
            filmInfos.add(filmInfo);
        }

        return filmInfos;
    }

    @Override
    public List<FilmInfo> getTop() {
        //经典电影前一百
        EntityWrapper<MoocFilmT> moocFilmTEntityWrapper = new EntityWrapper<>();
        moocFilmTEntityWrapper.eq("film_status","2");

        //定义Page对象并且按照film_box_office字段进行排序
        Page<MoocFilmT> filmTPage = new Page<>(1,10,"film_score");
        List<MoocFilmT> moocFilmTS = moocFilmTMapper.selectPage(filmTPage,moocFilmTEntityWrapper);

        //封装成List<FilmInfo>
        List<FilmInfo> filmInfos = new ArrayList<>();
        for(MoocFilmT filmT: moocFilmTS){
            FilmInfo filmInfo = new FilmInfo();
            filmInfo =FilmT2FilmInfo.converter(filmT);
            filmInfos.add(filmInfo);
        }

        return filmInfos;
    }

    @Override
    public List<CatVo> gtCats() {
        List<CatVo> catVos = new ArrayList<>();
        List<MoocCatDictT> moocCatDictTS = moocCatDictTMapper.selectList(null);
        for(MoocCatDictT moocCatDictT : moocCatDictTS){
            CatVo catVo = new CatVo();
            catVo.setCatId(moocCatDictT.getUuid()+"");
            catVo.setCatName(moocCatDictT.getShowName());

            catVos.add(catVo);
        }
        return catVos;
    }

    @Override
    public List<SourceVo> getSources() {
        List<SourceVo> sourceVos = new ArrayList<>();
        List<MoocSourceDictT>  moocSourceDictTS = moocSourceDictTMapper.selectList(null);
        for(MoocSourceDictT moocSourceDictT : moocSourceDictTS){
            SourceVo sourceVo = new SourceVo();
            sourceVo.setSourceId(moocSourceDictT.getUuid()+"");
            sourceVo.setSourceName(moocSourceDictT.getShowName());
            sourceVos.add(sourceVo);
        }
        return sourceVos;
    }

    @Override
    public List<YearVo> getYears() {
        List<YearVo> yearVos = new ArrayList<>();
        List<MoocYearDictT> moocYearDictTS = moocYearDictTMapper.selectList(null);
        for(MoocYearDictT moocYearDictT : moocYearDictTS){
            YearVo yearVo = new YearVo();
            yearVo.setYearId(moocYearDictT.getUuid()+"");
            yearVo.setYearName(moocYearDictT.getShowName());
            yearVos.add(yearVo);
        }
        return yearVos;
    }
}
