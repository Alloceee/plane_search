package com.yws.plane.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.yws.plane.entity.ChinaFight;
import com.baomidou.mybatisplus.service.IService;
import com.yws.plane.entity.FightCompanyPlaneVO;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yewenshu123
 * @since 2019-12-23
 */
public interface ChinaFightService extends IService<ChinaFight> {
    Page<FightCompanyPlaneVO> getChinaFightCompanyPlane(Page<FightCompanyPlaneVO> page, @Param("start_city")String start_city, @Param("end_city")String end_city);
}
