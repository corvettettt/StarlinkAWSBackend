package tylerstarlink.SatelliteDAO;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class N2YOAboveResponse {
    @JsonProperty("above")
    Above[] aboves;

    public AboveResponse extract(){
        return new AboveResponse(aboves);
    }
}

