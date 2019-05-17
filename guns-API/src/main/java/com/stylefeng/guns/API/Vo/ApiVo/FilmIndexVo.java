package com.stylefeng.guns.API.Vo.ApiVo;

import com.stylefeng.guns.API.Vo.BannerVo;
import com.stylefeng.guns.API.Vo.FilmInfo;
import com.stylefeng.guns.API.Vo.FilmsVo;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @program: guns-parent
 * @description: 影片模块首页Vo
 * @author: Zwb
 * @create: 2019-05-14 16:26
 **/
@Data
public class FilmIndexVo implements Serializable {

    private static final long serialVersionUID = 3475461685353124842L;

    private List<BannerVo> banners;

    private FilmsVo hotFilms;

    private FilmsVo soonFilms ;

    private List<FilmInfo> boxRanking;

    private List<FilmInfo> expectRanking ;

    private List<FilmInfo> top100;
}
