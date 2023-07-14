package sage.springcoder.jamhubclient.web.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.ConstructorBinding;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import sage.springcoder.jamhubclient.web.model.JamDto;

import java.net.URI;
import java.util.UUID;

@ConfigurationProperties(prefix = "jix.jamhub",ignoreUnknownFields = false)
@Component
public class JamClient {

    private static final String JAM_PATH_V1 = "/api/v1/jam";

    private String apiHost;
    private final RestTemplate restTemplate;

    @Autowired
    public JamClient(RestTemplateBuilder restTemplateBuilder){
        this.restTemplate = restTemplateBuilder.build();
    }

    public JamDto getJamById(UUID uuid){
        return restTemplate.getForObject(apiHost+JAM_PATH_V1+"/"+uuid.toString(),JamDto.class);
    }

    public URI saveNewJam(JamDto jamDto){
        System.out.println(apiHost+JAM_PATH_V1);
        return restTemplate.postForLocation(apiHost+JAM_PATH_V1,jamDto);
    }

    public void updateJam(UUID uuid, JamDto jamDto){
        restTemplate.put(apiHost+JAM_PATH_V1+"/"+uuid.toString(),jamDto);
    }

    public void deleteJam(UUID uuid){
        restTemplate.delete(apiHost+JAM_PATH_V1+"/"+uuid.toString());
    }
    public void setApiHost(String apiHost) {
        this.apiHost = apiHost;
    }

}
