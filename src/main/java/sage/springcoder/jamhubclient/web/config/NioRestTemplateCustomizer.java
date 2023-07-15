//
package sage.springcoder.jamhubclient.web.config;
//
//import org.apache.hc.client5.http.impl.async.CloseableHttpAsyncClient;
//import org.apache.hc.client5.http.impl.async.HttpAsyncClients;
//import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManager;
//import org.apache.hc.client5.http.nio.AsyncClientConnectionManager;
//import org.apache.hc.core5.reactor.DefaultConnectingIOReactor;
//import org.apache.hc.core5.reactor.IOReactorConfig;
//import org.apache.http.impl.nio.conn.PoolingNHttpClientConnectionManager;
////import org.apache.http.impl.nio.reactor.DefaultConnectingIOReactor;
////import org.apache.http.impl.nio.reactor.IOReactorConfig;
////import org.apache.http.nio.reactor.IOReactorException;
//import org.apache.http.nio.reactor.IOReactorException;
//import org.springframework.boot.web.client.RestTemplateCustomizer;
//import org.springframework.http.client.ClientHttpRequestFactory;
//import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
//import org.springframework.stereotype.Component;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.concurrent.TimeUnit;
//
//
//@Component
//public class NioRestTemplateCustomizer implements RestTemplateCustomizer {
//
//    public ClientHttpRequestFactory clientHttpRequestFactory() throws IOReactorException {
////        final DefaultConnectingIOReactor ioReactor = new DefaultConnectingIOReactor(IOReactorConfig.custom()
////                .setConnectTimeout(3000)
////                .setIoThreadCount(4)
////                .setSoTimeout(3000)
////                .build());
////        IOReactorConfig ioReactorConfig = IOReactorConfig.custom().setIoThreadCount(4)
////                .setSoTimeout(3000, TimeUnit.MILLISECONDS).build();
////
////
//        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
//        connectionManager.setDefaultMaxPerRoute(100);
//        connectionManager.setMaxTotal(1000);
//
//
////        final PoolingNHttpClientConnectionManager connectionManager = new PoolingNHttpClientConnectionManager(ioReactor);
////        connectionManager.setDefaultMaxPerRoute(100);
////        connectionManager.setMaxTotal(1000);
//
//
//        CloseableHttpAsyncClient closeableHttpAsyncClient = HttpAsyncClients.custom()
//                .setConnectionManager(connectionManager)
//                .build();
//
//        return new (closeableHttpAsyncClient);
//    }
//
//    @Override
//    public void customize(RestTemplate restTemplate) {
//        try {
//            restTemplate.setRequestFactory(clientHttpRequestFactory());
//        } catch (IOReactorException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}
//
