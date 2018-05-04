package com.huishu.es.service;

import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.aggregations.bucket.terms.Terms.Bucket;
import org.elasticsearch.search.aggregations.bucket.terms.TermsBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;

import com.huishu.es.conf.EsConstants;

/**
 * 抽象服务类
 * 提供公共公共方法
 */
public abstract class AbstractEsService {
 
	
	private static Logger log = LoggerFactory.getLogger(AbstractEsService.class);
	

	@Autowired
	protected ElasticsearchTemplate template;
	 
	protected NativeSearchQueryBuilder getSearchQueryBuilder() {
		return new NativeSearchQueryBuilder()
				.withIndices(EsConstants.ES_INDEX)
				.withTypes(EsConstants.ES_TYPE);
	}
	
	/**
	 * 根据参数获取聚合数
	 * @param field es属性
	 * @return
	 */
	protected long getCountByField(String field) {

		TermsBuilder aggBuilder = AggregationBuilders
				.terms(field)
				.field(field);
		
		SearchQuery query = getSearchQueryBuilder()
				.addAggregation(aggBuilder)
				.build();
		
		long num = template.query(query, res -> {
			
			Terms t = res.getAggregations().get(field);
			long docCount = 0;
			for (Bucket bucket : t.getBuckets()) {
				docCount += bucket.getDocCount();
			}
			long sumOfOtherDocCount = t.getSumOfOtherDocCounts();
			long docErrorCount = t.getDocCountError();

			if (docErrorCount != 0) {
				log.warn("获取 {} 个错误文档", docErrorCount);
			}
			
			return Math.addExact(docCount, sumOfOtherDocCount);
		});
		
		if (log.isDebugEnabled()) {
			log.debug("获取 {} 聚合量 {} 条", field, num);
		}
		
		return num;
	}
}
