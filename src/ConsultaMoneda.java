import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class ConsultaMoneda {
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/d301589890d752a5db51c383/latest/";

    private ApiResponse consultaApi(String baseMoneda) throws IOException, InterruptedException {
        URI direccion = URI.create(API_URL + baseMoneda);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(direccion).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        try {
            return new Gson().fromJson(response.body(), ApiResponse.class);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Moneda obtenerTasas(String baseMoneda) throws IOException, InterruptedException {
        ApiResponse apiResponse = consultaApi(baseMoneda);
        if (apiResponse != null && apiResponse.getConversionRates() != null) {
            Map<String, Double> rates = apiResponse.getConversionRates();
            return new Moneda(
                    rates.getOrDefault("USD", 0.0),
                    rates.getOrDefault("MXN", 0.0),
                    rates.getOrDefault("ARS", 0.0),
                    rates.getOrDefault("BRL", 0.0),
                    rates.getOrDefault("COP", 0.0)
            );
        }
        return null;
    }
}
