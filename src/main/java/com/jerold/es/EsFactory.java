package com.jerold.es;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

/**
 * Created by Jerold on 16/6/17.
 */
public class EsFactory {
    private static Client client;

    static {
        try {
            client = TransportClient.builder().build().addTransportAddress(
                    new InetSocketTransportAddress(
                            new InetSocketAddress(InetAddress.getByName("localhost"), 9300)));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    public static Client getClient() {
        return client;
    }

}
