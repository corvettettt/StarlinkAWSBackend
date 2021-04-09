package tylerstarlink.SatelliteDAO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class N2YOPositionResponse {
    public Info info;

    public Position[] positions;

    public PositionsResponse extract(){
        return new PositionsResponse(info.getSatid(),info.getSatname(),positions);

    }
}
