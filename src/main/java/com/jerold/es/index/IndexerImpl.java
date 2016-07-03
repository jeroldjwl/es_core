package com.jerold.es.index;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jerold.es.EsFactory;
import com.jerold.es.meta.SearchAttribute;
import com.jerold.es.meta.SearchableObject;
import org.elasticsearch.client.Client;

/**
 * Created by Jerold on 16/7/2.
 */
public class IndexerImpl {
    private Client client;

    public IndexerImpl() {
        init();
    }

    private void init() {
        client = EsFactory.getClient();
    }

    public void index() {
        ObjectMapper mapper = new ObjectMapper();
        SearchableObject so = new SearchableObject();
        SearchAttribute sa = new SearchAttribute();
        sa.setName("EmpNo");
        sa.setValue("10001");
        sa.setName("EmpName");
        sa.setValue("TestEmp");
        so.setUrl("http://www.test.com/");
        so.setKeywords("you know for search");
        so.setSvoName("testSvo");
        so.setTitle("test tilte");
        so.setContent("test content, maybe a lot of strings");
        so.setSearchAttribute(sa);
        try {
            String str = mapper.writeValueAsString(so);
            System.out.println(str);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        IndexerImpl indexer = new IndexerImpl();
        indexer.index();
    }
}
