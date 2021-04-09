package tylerstarlink.controller;

import tylerstarlink.SatelliteDAO.AboveResponse;
import tylerstarlink.SatelliteDAO.PositionsResponse;
import tylerstarlink.service.SatelliteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SatelliteController {
    @Autowired
    SatelliteService service;

    @GetMapping("/GetSatellites")
    public AboveResponse getAboveSatellites(@RequestParam String latitude,
                                            @RequestParam String longitude,
                                            @RequestParam String altitude,
                                            @RequestParam String elevation){
        return service.getAboves(latitude,longitude,altitude,elevation);
    }

    @GetMapping("/GetDetails")
    public PositionsResponse getPositionsSatellites(@RequestParam String latitude,
                                                         @RequestParam String longitude,
                                                         @RequestParam String altitude,
                                                         @RequestParam String satid,
                                                         @RequestParam int duration
                                                    ){
        System.out.print(satid);
        return service.getPositions(latitude,longitude,altitude,satid,duration);
    }
}
