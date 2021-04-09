package tylerstarlink.SatelliteDAO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)

public class Above {
    @JsonProperty
    public String satid;
    public String satname;
    public String launchDate;
}
