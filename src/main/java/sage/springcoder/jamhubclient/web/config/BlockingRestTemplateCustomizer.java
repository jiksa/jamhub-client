package sage.springcoder.jamhubclient.web.config;

//import org.apache.http.client.config.RequestConfig;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
//import org.apache.http.impl.client.HttpClients;
//import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
//import org.springframework.http.client.ClientHttpRequestFactory;
//import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;

import org.apache.hc.client5.http.config.RequestConfig;
import org.apache.hc.client5.http.impl.DefaultConnectionKeepAliveStrategy;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


import java.util.concurrent.TimeUnit;

@Component
public class BlockingRestTemplateCustomizer implements RestTemplateCustomizer {

    private final Integer maxTotalConections;
    private final Integer defaultMaxPerRoute;
    private final Long connectionRequestTimeout;

    public BlockingRestTemplateCustomizer(@Value("${jamhub.maxTotalConections}") Integer maxTotalConections,
                                          @Value("${jamhub.defaultMaxPerRoute}") Integer defaultMaxPerRoute,
                                          @Value("${jamhub.connectionRequestTimeout}") Long connectionRequestTimeout) {
        this.maxTotalConections = maxTotalConections;
        this.defaultMaxPerRoute = defaultMaxPerRoute;
        this.connectionRequestTimeout= connectionRequestTimeout;
    }

    public ClientHttpRequestFactory clientHttpRequestFactory() {
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
        connectionManager.setMaxTotal(maxTotalConections);
        connectionManager.setDefaultMaxPerRoute(defaultMaxPerRoute);

        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectionRequestTimeout(connectionRequestTimeout, TimeUnit.MILLISECONDS)
                // .setSocketTimeout(3000)
                .build();

        CloseableHttpClient httpClient = HttpClients.custom()
                .setConnectionManager(connectionManager)
                .setKeepAliveStrategy(new DefaultConnectionKeepAliveStrategy())
                .setDefaultRequestConfig(requestConfig)
                .build();

        return new HttpComponentsClientHttpRequestFactory(httpClient);

    }

    @Override
    public void customize(RestTemplate restTemplate) {
        restTemplate.setRequestFactory(this.clientHttpRequestFactory());
    }
}
