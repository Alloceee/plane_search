package com.yws.plane.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yws.plane.entity.ChinaFight;
import com.yws.plane.entity.FightCompanyPlaneVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yewenshu123
 * @since 2019-12-23
 */
public interface ChinaFightMapper extends BaseMapper<ChinaFight> {
    @Select("SELECT tb_plane.*,tb_company.*,tb_china_fight.* FROM tb_plane,tb_company,tb_china_fight" +
            " WHERE tb_china_fight.plane_id=tb_plane.id AND tb_plane.company_id = tb_company.id AND tb_china_fight.start_city=#{start_city}" +
            "AND tb_china_fight.end_city=#{end_city}")
    List<FightCompanyPlaneVO> getChinaFightCompanyPlane(Pagination page, @Param("start_city")String start_city, @Param("end_city")String end_city);
}
