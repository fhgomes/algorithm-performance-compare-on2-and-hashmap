package fernando.br;

import java.math.BigDecimal;
import java.util.Date;

public abstract class ABSEntity {
    private EntityType type;
    private Integer quantity;
    private BigDecimal value;
    private Date startDate;
    private Date endDate;
    private Boolean isActive;

    public ABSEntity(EntityType type, Integer quantity, BigDecimal value, Date startDate, Date endDate, Boolean isActive) {
        this.type = type;
        this.quantity = quantity;
        this.value = value;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isActive = isActive;
    }

    public EntityType getType() {
        return type;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public BigDecimal getValue() {
        return value;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Boolean getActive() {
        return isActive;
    }

    public String mapComparableHash() {
        return new StringBuilder()
                .append(type)
                .append(quantity)
                .append(value)
                .append(startDate)
                .append(endDate)
                .append(isActive)
                .toString();
    }
}
