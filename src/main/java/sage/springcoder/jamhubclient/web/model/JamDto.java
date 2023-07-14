package sage.springcoder.jamhubclient.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JamDto {
    private UUID jamId;
    private String jamName;
    private String jamFlavor;
    private Long upc;
}
