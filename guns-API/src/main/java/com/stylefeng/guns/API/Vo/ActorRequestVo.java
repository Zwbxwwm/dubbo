package com.stylefeng.guns.API.Vo;

import com.stylefeng.guns.API.Vo.ActorVo;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @program: guns-parent
 * @description: 展示层的演员表
 * @author: Zwb
 * @create: 2019-05-21 20:10
 **/
@Data
public class ActorRequestVo implements Serializable {

    private static final long serialVersionUID = -6324803429692579028L;

    private ActorVo director;

    private List<ActorVo> actors;
}



