package com.stylefeng.guns.rest.modular.Film;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.API.Film.IFilmAPI;
import com.stylefeng.guns.API.Vo.*;

import com.stylefeng.guns.API.Vo.ApiVo.FilmDetailVo;
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


    @Autowired
    private MoocFilmInfoTMapper moocFilmInfoTMapper;

    @Autowired
    private MoocActorTMapper moocActorTMapper;

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
    public FilmsVo getHotFilms(boolean isLimit, int nums,int nowPage,int sortId,int sourceId,int yearId,int catId) {
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
            Page<MoocFilmT> filmTPage = null;
            //按照SortId进行排序
            //排序方式，1-按热门搜索，2-按时间搜索，3-按评价搜索
            switch(sortId){
                case 1:
                    filmTPage = new Page<>(nowPage,nums,"film_box_office");
                    break;
                case 2:
                    filmTPage = new Page<>(nowPage,nums,"film_time");
                    break;
                case 3:
                    filmTPage = new Page<>(nowPage,nums,"film_score");
                    break;
                default:
                    filmTPage = new Page<>(nowPage,nums,"film_box_office");
                    break;
            }
            if(sourceId != 99){
                moocFilmTEntityWrapper.eq("film_source",sourceId);
            }
            if(yearId != 99){
                moocFilmTEntityWrapper.eq("film_date",yearId);
            }
            if(catId != 99){
                String caString  = "%#"+catId+"#%";
                moocFilmTEntityWrapper.like("film_cats",caString);
            }
            List<MoocFilmT> filmTS = moocFilmTMapper.selectPage(filmTPage,moocFilmTEntityWrapper);
            for(MoocFilmT filmT:filmTS){
                FilmInfo filmInfo = new FilmInfo();
                filmInfo = FilmT2FilmInfo.converter(filmT);
                filmInfos.add(filmInfo);
            }
            int totalCount = moocFilmTMapper.selectCount(moocFilmTEntityWrapper);
            int totalPage = totalCount/nums +1;
            filmsVo.setTotalPage(totalPage);
            filmsVo.setNowPage(nowPage);
            filmsVo.setFilmInfo(filmInfos);
        }
        return filmsVo;
    }

    @Override
    public FilmsVo getSoonFilms(boolean isLimit, int nums,int nowPage,int sortId,int sourceId,int yearId,int catId) {
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
            Page<MoocFilmT> filmTPage = null;
            //按照SortId进行排序
            //排序方式，1-按热门搜索，2-按时间搜索，3-按评价搜索
            switch(sortId){
                case 1:
                    filmTPage = new Page<>(nowPage,nums,"film_preSaleNum");
                    break;
                case 2:
                    filmTPage = new Page<>(nowPage,nums,"film_time");
                    break;
                case 3:
                    filmTPage = new Page<>(nowPage,nums,"film_preSaleNum");
                    break;
                default:
                    filmTPage = new Page<>(nowPage,nums,"film_preSaleNum");
                    break;
            }

            if(sourceId != 99){
                moocFilmTEntityWrapper.eq("film_source",sourceId);
            }
            if(yearId != 99){
                moocFilmTEntityWrapper.eq("film_date",yearId);
            }
            if(catId != 99){
                String caString  = "%#"+catId+"#%";
                moocFilmTEntityWrapper.like("film_cats",caString);
            }
            List<MoocFilmT> filmTS = moocFilmTMapper.selectPage(filmTPage,moocFilmTEntityWrapper);
            for(MoocFilmT filmT:filmTS){
                FilmInfo filmInfo = new FilmInfo();
                filmInfo = FilmT2FilmInfo.converter(filmT);
                filmInfos.add(filmInfo);
            }
            int totalCount = moocFilmTMapper.selectCount(moocFilmTEntityWrapper);
            int totalPage = totalCount/nums +1;
            filmsVo.setTotalPage(totalPage);
            filmsVo.setNowPage(nowPage);
            filmsVo.setFilmInfo(filmInfos);
        }
        return filmsVo;
    }

    @Override
    public FilmsVo getClassicFilms(int nums, int nowPage, int sortId, int sourceId, int yearId, int catId) {
        FilmsVo filmsVo = new FilmsVo();
        List<FilmInfo> filmInfos = new ArrayList<>();
        //查找所有待上映影片
        EntityWrapper<MoocFilmT> moocFilmTEntityWrapper = new EntityWrapper<>();
        moocFilmTEntityWrapper.eq("film_status","3");
        //是否是首页所需

        Page<MoocFilmT> filmTPage = null;
        //按照SortId进行排序
        //排序方式，1-按热门搜索，2-按时间搜索，3-按评价搜索
        switch(sortId){
            case 1:
                filmTPage = new Page<>(nowPage,nums,"film_box_office");
                break;
            case 2:
                filmTPage = new Page<>(nowPage,nums,"film_time");
                break;
            case 3:
                filmTPage = new Page<>(nowPage,nums,"film_score");
                break;
            default:
                filmTPage = new Page<>(nowPage,nums,"film_box_office");
                break;
        }

        if(sourceId != 99){
            moocFilmTEntityWrapper.eq("film_source",sourceId);
        }
        if(yearId != 99){
            moocFilmTEntityWrapper.eq("film_date",yearId);
        }
        if(catId != 99){
            String caString  = "%#"+catId+"#%";
            moocFilmTEntityWrapper.like("film_cats",caString);
        }
        List<MoocFilmT> filmTS = moocFilmTMapper.selectPage(filmTPage,moocFilmTEntityWrapper);
        for(MoocFilmT filmT:filmTS){
            FilmInfo filmInfo = new FilmInfo();
            filmInfo = FilmT2FilmInfo.converter(filmT);
            filmInfos.add(filmInfo);
        }
        int totalCount = moocFilmTMapper.selectCount(moocFilmTEntityWrapper);
        int totalPage = totalCount/nums +1;
        filmsVo.setTotalPage(totalPage);
        filmsVo.setNowPage(nowPage);
        filmsVo.setFilmInfo(filmInfos);

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

    public FilmDetailVo getFilmDetail(int searchType, String searchParam){
        //searchType 1->按照名称查找， 2->按照ID查找
        if(searchType == 1){
            searchParam = "%"+searchParam+"%";
            FilmDetailVo filmDetailVo = moocFilmTMapper.getFilmDetailByName(searchParam);
            if(filmDetailVo != null){
                return filmDetailVo;
            }else {
                throw new NullPointerException("未找到影片");
            }
        }else {
            FilmDetailVo filmDetailVo = moocFilmTMapper.getFilmDetailById(searchParam);
            return filmDetailVo;
        }
    }

    private MoocFilmInfoT getFilmInfo(String filmId){
        MoocFilmInfoT moocFilmInfoT = new MoocFilmInfoT();
        moocFilmInfoT.setFilmId(filmId);
        moocFilmInfoT = moocFilmInfoTMapper.selectOne(moocFilmInfoT);
        return moocFilmInfoT;
    }

    @Override
    public FilmDesVo getFilmDesc(String filmId) {
        FilmDesVo filmDesVo = new FilmDesVo();
        MoocFilmInfoT moocFilmInfoT =  getFilmInfo(filmId);

        filmDesVo.setBiography(moocFilmInfoT.getBiography());
        filmDesVo.setFilmId(filmId);

        return filmDesVo;
    }

    @Override
    public ImgVo getImg(String filmId) {
        ImgVo imgVo = new ImgVo();
        MoocFilmInfoT moocFilmInfoT =  getFilmInfo(filmId);
        String filmImgsStr = moocFilmInfoT.getFilmImgs();
        String[] filmImgs = filmImgsStr.split(",");

        //组装
        imgVo.setMainImg(filmImgs[0]);
        imgVo.setImg01(filmImgs[1]);
        imgVo.setImg02(filmImgs[2]);
        imgVo.setImg03(filmImgs[3]);
        imgVo.setImg04(filmImgs[4]);

        return imgVo;
    }

    @Override
    public ActorVo getDectInfo(String filmId) {
        ActorVo actorVo = new ActorVo();
        MoocFilmInfoT moocFilmInfoT =  getFilmInfo(filmId);
        Integer directorId =moocFilmInfoT.getDirectorId();

        MoocActorT moocActorT = moocActorTMapper.selectById(directorId);

        actorVo.setImgAddress(moocActorT.getActorImg());
        actorVo.setDirectorName(moocActorT.getActorName());

        return actorVo;
    }

    @Override
    public List<ActorVo> getActors(String filmId) {
        List<ActorVo> actorVos = moocActorTMapper.getActors(filmId);
        return actorVos;
    }
}
