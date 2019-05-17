package com.stylefeng.guns.API.Vo.ApiVo;

import com.stylefeng.guns.API.Vo.CatVo;
import com.stylefeng.guns.API.Vo.SourceVo;
import com.stylefeng.guns.API.Vo.YearVo;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @program: guns-parent
 * @description: condition接口Vo
 * @author: Zwb
 * @create: 2019-05-16 20:12
 **/
@Data
public class FilmConditionVo implements Serializable {

    private static final long serialVersionUID = 3333585649111062164L;

    private List<CatVo> catInfo;

    private List<SourceVo> sourceInfo;

    private List<YearVo> yearInfo;

}
