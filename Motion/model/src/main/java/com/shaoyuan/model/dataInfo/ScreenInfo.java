package com.shaoyuan.model.dataInfo;

import java.io.Serializable;

/**
 * Created by small-ho on 2019/7/29 9:48
 * title：健康体检列表
 */
public class ScreenInfo implements Serializable {

    private String title;
    private String context;
    private String price;
    private String prices;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPrices() {
        return prices;
    }

    public void setPrices(String prices) {
        this.prices = prices;
    }
}
