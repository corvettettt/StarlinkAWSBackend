package tylerstarlink.repository;
import com.fasterxml.jackson.databind.ObjectMapper;
import tylerstarlink.SatelliteDAO.AboveResponse;
import tylerstarlink.SatelliteDAO.N2YOAboveResponse;
import tylerstarlink.SatelliteDAO.N2YOPositionResponse;
import tylerstarlink.SatelliteDAO.PositionsResponse;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Future;


@Repository
public class N2YOClient {
    static final String baseURL = "https://api.n2yo.com/rest/v1/satellite/";
    static final String position = "positions/%s/%s/%s/%s/%d&apiKey=%s";
    static final String above = "above/%s/%s/%s/%s/52&apiKey=%s";
    static final String APIKey = "8LBHPL-K4DR9H-3WYN6U-4LWC";

    private ObjectMapper mapper = new ObjectMapper();
    private CloseableHttpClient client = HttpClients.createDefault();
    HttpGet request;

    public AboveResponse getAbove(String latitude,
                                    String longitude,
                                    String altitude,
                                    String elevation) throws IOException {
        String url = baseURL + String.format(above,latitude,longitude,altitude,elevation,APIKey);

        request = new HttpGet(url);
        request.setHeader("Content-type","application/json");

        ResponseHandler<AboveResponse> handler =  new ResponseHandler<AboveResponse>() {
            @Override
            public AboveResponse handleResponse(HttpResponse res) throws ClientProtocolException, IOException {
                if (res.getStatusLine().getStatusCode() != 200) {
                    return new AboveResponse();
                }

                HttpEntity entity = res.getEntity();

                if (entity == null) {
                    return new AboveResponse();
                }

                N2YOAboveResponse results = mapper.readValue(entity.getContent(), N2YOAboveResponse.class);

                return results.extract();
            }
        };

        try {
            return client.execute(request,handler);
        } catch (IOException e){
            e.printStackTrace();
        }

        return new AboveResponse();
    }

    public PositionsResponse getPositions(String latitude,
                                            String longitude,
                                            String altitude,
                                            int duration,
                                            String satid){
        String url = baseURL + String.format(position,satid, latitude, longitude, altitude, duration * 60, APIKey);
        request = new HttpGet(url);
        request.setHeader("Content-type", "application/json");

        ResponseHandler<PositionsResponse> handler =  new ResponseHandler<PositionsResponse>() {
            @Override
            public PositionsResponse handleResponse(HttpResponse res) throws ClientProtocolException, IOException {
                if (res.getStatusLine().getStatusCode() != 200) {
                    return new PositionsResponse();
                }

                HttpEntity entity = res.getEntity();

                if (entity == null) {
                    return new PositionsResponse();
                }

                N2YOPositionResponse results = mapper.readValue(entity.getContent(), N2YOPositionResponse.class);

                return results.extract();
            }
        };

        try{
            return client.execute(request,handler);
        } catch (IOException e){
            e.printStackTrace();
        }

        return new PositionsResponse();

    }
}
