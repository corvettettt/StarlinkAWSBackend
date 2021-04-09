package tylerstarlink.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tylerstarlink.SatelliteDAO.AboveResponse;
import tylerstarlink.SatelliteDAO.PositionsResponse;
import tylerstarlink.repository.N2YOClient;

import java.io.IOException;

@Service
public class SatelliteService {

    @Autowired
    N2YOClient client;

    public AboveResponse getAboves(String latitude,
                                     String longitude,
                                     String altitude,
                                     String elevation){
        try {
            return client.getAbove(latitude, longitude, altitude, elevation);
        } catch (IOException e){
            e.printStackTrace();
        }
        return new AboveResponse();
    }

    public PositionsResponse getPositions(String latitude,
                                            String longitude,
                                            String altitude,
                                            String satid,
                                            int duration){
        return client.getPositions(latitude,longitude,altitude,duration,satid);
    }
}
