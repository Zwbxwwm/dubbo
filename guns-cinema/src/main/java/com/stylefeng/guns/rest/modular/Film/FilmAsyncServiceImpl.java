package com.stylefeng.guns.rest.modular.Film;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.API.Film.IFilmAPI;
import com.stylefeng.guns.API.Film.IFilmAsyncAPI;
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
@Service(interfaceClass = IFilmAsyncAPI.class)
public class FilmAsyncServiceImpl implements IFilmAsyncAPI {


    @Autowired
    private MoocFilmInfoTMapper moocFilmInfoTMapper;

    @Autowired
    private MoocActorTMapper moocActorTMapper;


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
