package lupici.ofa;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import static lupici.ofa.Main.productMap;

public class Bazaar {

    public static final double TAX = 1.125; // REMEMBER TO USE / 100
    public static final String apiKey = System.getenv("API_KEY");

    // Fetch and parse data :)
    private static final String urlString = "https://api.hypixel.net/skyblock/bazaar?key=" + apiKey;
    public static Map<String, Product> fetchProducts() {
        try {
            // Fetch data
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Reed response
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            connection.disconnect();

            // Parse into Bazaar response class
            Gson gson = new Gson();
            BazaarResponse bazaarResponse = gson.fromJson(content.toString(), BazaarResponse.class);

            if (bazaarResponse.getSuccess()) { ;
                return bazaarResponse.getProducts(); // Return products (String product_id, Quickstatus quickstatus)
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

    public static double profitt(String item_id) {
        if (productMap != null ) {
            Product algo = productMap.get(item_id);
            if (algo != null) {
                Quickstatus quick = algo.getQuickstatus();
                return quick.getBuyPrice() - quick.getSellPrice() - (TAX * quick.getSellPrice() / 100);
            } else {
                System.out.println("Product not found");
            }
        }
        return 0;
    }
}
