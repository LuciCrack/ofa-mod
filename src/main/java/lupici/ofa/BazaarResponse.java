package lupici.ofa;

import java.util.Map;

import static lupici.ofa.Bazaar.TAX;

public class BazaarResponse {
    private Boolean success;
    private long lastUpdated;
    private Map<String, Product> products;

    public Boolean getSuccess() {
        return success;
    }

    public long getLastUpdated() {
        return lastUpdated;
    }

    public Map<String, Product> getProducts() {
        return products;
    }

}

class Product {
    private String product_id;
    private Quickstatus quick_status;

    public String getProduct_id() {
        return product_id;
    }

    public Quickstatus getQuickstatus() {
        return quick_status;
    }

}

class Quickstatus {
    private double buyPrice;
    private double sellPrice;
    private int buyVolume;
    private int sellVolume;

    public double getBuyPrice() {
        return buyPrice;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public int getBuyVolume() {
        return buyVolume;
    }

    public int getSellVolume() {
        return sellVolume;
    }

}

