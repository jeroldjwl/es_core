package com.jerold.es;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermsQueryBuilder;
import org.elasticsearch.search.SearchHit;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jerold on 16/6/16.
 */
public class ESTest {
    public void search() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("index", "ecsf_security_crm");
        map.put("type", "secattrval_cache");
        map.put("id", "jerold_runtime.emp");
        map.put("path", "acl.sec_attr1");
        Client client = EsFactory.getClient();
        BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();
        queryBuilder.must(QueryBuilders.termQuery("all-english", "jerold"));
        queryBuilder.filter(QueryBuilders.termQuery("EmpName-en", "jerold"));
        BoolQueryBuilder secFilter = QueryBuilders.boolQuery();
        secFilter.must(QueryBuilders.termQuery("ECSF_SO_NAME", "runtime.emp"));
        secFilter.must(QueryBuilders.termsQuery("sec_attr1", map));
        TermsQueryBuilder builder = QueryBuilders.termsQuery("sec_attr1", map);

        TermsQueryBuilder builder1 = new TermsQueryBuilder("sec_attr1", map);

        QueryBuilder secQuery = QueryBuilders.matchQuery("_id", map.get("id"));

        System.out.println(secQuery.toString());
        System.out.println("+++++++++++++++++++");
        SearchResponse response = client.prepareSearch(map.get("index"))
                .setTypes(map.get("type"))
                .setQuery(secQuery)
                .execute().actionGet();

        SearchHit[] hits = response.getHits().hits();
        SearchHit hit = hits[0];
        Map m = hit.getSource();
        Object o = m.get("acl");
        Map m2 = (Map) o;
        Object o1 = m2.get("sec_attr1");
        System.out.println(o1.getClass().getName());
        System.out.println(o.toString());
        System.out.println("+++++++++++++++++++++");
        System.out.println(response.toString());

        /*queryBuilder.filter(QueryBuilders.boolQuery().should(secFilter));
        System.out.println(queryBuilder.toString());
        System.out.println("++++++++++++++++++++++++++");
        System.out.println(builder.toString());
        System.out.println("++++++++++++++++++++++++++");
        System.out.println(builder1.toString());*/
    }

    public static void main(String[] args) {
        ESTest searcher = new ESTest();
        searcher.search();
    }

}
