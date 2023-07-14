package sage.springcoder.jamhubclient.web.client;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sage.springcoder.jamhubclient.web.model.JamDto;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class JamClientTest {

    @Autowired
    JamClient jamClient;

    @Test
    void getJamById() {
        JamDto jamDto = jamClient.getJamById(UUID.randomUUID());
        assertNotNull(jamDto);
    }

    @Test
    void saveNewJam(){
        //given
        JamDto jamDto = JamDto.builder()
                .jamName("Strawberry Delight").build();

        URI uri = jamClient.saveNewJam(jamDto);
        System.out.println(uri.toString());
        assertNotNull(uri);
    }

    @Test
    void updateJam() {

        JamDto jamDto = JamDto.builder()
                .jamName("Strawberry Delight new").build();
        jamClient.updateJam(UUID.randomUUID(),jamDto);
    }

    @Test
    void deleteJam() {
        jamClient.deleteJam(UUID.randomUUID());
    }
}