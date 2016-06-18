package com.jerold.es;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;

/**
 * Created by Jerold on 16/6/17.
 */
public class EsFactory {

    public static void main(String[] args) {
        Client client = TransportClient.builder().build();
    }
}
