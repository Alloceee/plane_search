package com.yws.plane.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.yws.plane.entity.ChinaFight;
import com.yws.plane.entity.FightCompanyPlaneVO;
import com.yws.plane.mapper.ChinaFightMapper;
import com.yws.plane.service.ChinaFightService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.apache.ibatis.annotations.Param;
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
public class ChinaFightServiceImpl extends ServiceImpl<ChinaFightMapper, ChinaFight> implements ChinaFightService {

    @Override
    public Page<FightCompanyPlaneVO> getChinaFightCompanyPlane(Page<FightCompanyPlaneVO> page, @Param("start_city")String start_city, @Param("end_city")String end_city) {
        return page.setRecords(this.baseMapper.getChinaFightCompanyPlane(page,start_city,end_city));
    }
}
