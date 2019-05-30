package com.stylefeng.guns.rest.common.persistence.dao;

import com.stylefeng.guns.API.Vo.CinemaFilmInfoVo;
import com.stylefeng.guns.API.Vo.CinemaHallInfoVo;
import com.stylefeng.guns.API.Vo.CinemaHallTypeVo;
import com.stylefeng.guns.rest.common.persistence.model.MoocFieldT;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 放映场次表 Mapper 接口
 * </p>
 *
 * @author zwb
 * @since 2019-05-26
 */
public interface MoocFieldTMapper extends BaseMapper<MoocFieldT> {
    List<CinemaFilmInfoVo> getFilmInfos(@Param("cinemaId") int cinemaId);

    CinemaHallInfoVo getHallInfo(@Param("fieldId") int fieldId);

    CinemaFilmInfoVo getFilmInfoById(@Param("fieldId") int fieldId);
}
