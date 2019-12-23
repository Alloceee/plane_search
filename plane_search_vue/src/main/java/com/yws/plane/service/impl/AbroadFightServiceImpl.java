package com.yws.plane.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yws.plane.entity.AbroadFight;
import com.yws.plane.entity.FightCompanyPlaneVO;
import com.yws.plane.mapper.AbroadFightMapper;
import com.yws.plane.service.AbroadFightService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yewenshu123
 * @since 2019-12-23
 */
@Service
public class AbroadFightServiceImpl extends ServiceImpl<AbroadFightMapper, AbroadFight> implements AbroadFightService {

    @Override
    public Page<FightCompanyPlaneVO> getAbroadFightCompanyPlane(Page<FightCompanyPlaneVO> page, String start_city, String end_city) {
        return page.setRecords(this.baseMapper.getAbroadFightCompanyPlane(page,start_city,end_city));
    }
}
