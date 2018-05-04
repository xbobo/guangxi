package com.huishu.es.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.huishu.es.entity.AmpInfo;

public interface DemoEsRepository extends ElasticsearchRepository<AmpInfo, String>{

}
