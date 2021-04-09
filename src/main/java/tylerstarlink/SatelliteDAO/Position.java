package tylerstarlink.SatelliteDAO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Position {
    @JsonProperty("satlatitude")
    public String satlat;

    @JsonProperty("satlongitude")
    public String satlon;
}
