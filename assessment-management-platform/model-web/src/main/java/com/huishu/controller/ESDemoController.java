package com.huishu.controller;

import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.huishu.base.BaseController;

@Controller
@RequestMapping(value="esquery")
public class ESDemoController extends BaseController{
	
	@RequestMapping(value="esDemo.do")
	public void demo(){
		SearchRequestBuilder searchRequestBuilder = getSearchRequestBuilder();
		QueryBuilder queryBuilder=new BoolQueryBuilder();
		AggregationBuilder aggregation =AggregationBuilders.terms("").field("");
		searchRequestBuilder.setQuery(queryBuilder).addAggregation(aggregation).execute().actionGet();
		
	}
}
