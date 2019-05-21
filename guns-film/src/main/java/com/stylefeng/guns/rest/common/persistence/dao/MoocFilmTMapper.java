package com.stylefeng.guns.rest.common.persistence.dao;

import com.stylefeng.guns.API.Vo.ApiVo.FilmDetailVo;
import com.stylefeng.guns.rest.common.persistence.model.MoocFilmT;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 影片主表 Mapper 接口
 * </p>
 *
 * @author zwb
 * @since 2019-05-14
 */
public interface MoocFilmTMapper extends BaseMapper<MoocFilmT> {
    FilmDetailVo getFilmDetailByName(@Param("filmName") String filmName);

    FilmDetailVo getFilmDetailById(@Param("uuid")String uuid);
}
