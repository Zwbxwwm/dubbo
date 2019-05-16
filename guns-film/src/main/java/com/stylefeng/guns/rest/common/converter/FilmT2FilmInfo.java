package com.stylefeng.guns.rest.common.converter;

import com.stylefeng.guns.API.Vo.FilmInfo;
import com.stylefeng.guns.core.util.DateUtil;
import com.stylefeng.guns.rest.common.persistence.model.MoocFilmT;
import org.springframework.beans.BeanUtils;

/**
 * @program: guns-parent
 * @description: FilmT转换成FilmInfo
 * @author: Zwb
 * @create: 2019-05-14 20:50
 **/
public class FilmT2FilmInfo {

    public static FilmInfo converter(MoocFilmT moocFilmT){
        FilmInfo filmInfo = new FilmInfo();
        BeanUtils.copyProperties(moocFilmT,filmInfo);
        filmInfo.setFilmId(moocFilmT.getUuid()+"");
        filmInfo.setScore(moocFilmT.getFilmScore());
        filmInfo.setBoxNum(moocFilmT.getFilmBoxOffice());
        filmInfo.setExpectNum(moocFilmT.getFilmPresalenum());
        filmInfo.setShowTime(DateUtil.getDay(moocFilmT.getFilmTime()));
        return filmInfo;
    }
}
