package tylerstarlink.SatelliteDAO;

import lombok.*;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class PositionsResponse {
    public String satid;
    public String satname;
    public Position[] positions;
}
