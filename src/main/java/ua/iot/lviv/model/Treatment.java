package ua.iot.lviv.model;

import java.math.BigDecimal;

public interface Treatment extends GeneralModel {
    String getName();

    void setName(String name);

    String getDescription();

    void setDescription(String description);

    BigDecimal getPriceUSD();

    void setPriceUSD(BigDecimal priceUSD);
}
