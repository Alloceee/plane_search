package com.yws.plane.elasticsearch;

import com.yws.plane.entity.Com;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author AlmostLover
 */
public interface CompanyElasticRepository extends ElasticsearchRepository<Com, Integer> {

}
