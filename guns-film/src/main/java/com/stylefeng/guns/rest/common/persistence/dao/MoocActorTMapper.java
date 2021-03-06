package com.stylefeng.guns.rest.common.persistence.dao;

import com.stylefeng.guns.API.Vo.ActorVo;
import com.stylefeng.guns.rest.common.persistence.model.MoocActorT;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 演员表 Mapper 接口
 * </p>
 *
 * @author zwb
 * @since 2019-05-14
 */
public interface MoocActorTMapper extends BaseMapper<MoocActorT> {
    List<ActorVo> getActors(@Param("filmId") String filmId);

}
