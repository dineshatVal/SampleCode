package org.example;

public class Item {
    public String sku;
    public SiteInfo site_info;

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public SiteInfo getSite_info() {
        return site_info;
    }

    public void setSite_info(SiteInfo site_info) {
        this.site_info = site_info;
    }
}
