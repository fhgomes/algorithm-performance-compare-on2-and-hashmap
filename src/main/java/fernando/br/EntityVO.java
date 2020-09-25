package fernando.br;

import java.math.BigDecimal;
import java.util.Date;

public class EntityVO extends ABSEntity{

    public EntityVO(EntityType type, Integer quantity, BigDecimal value, Date startDate, Date endDate, Boolean isActive) {
        super(type, quantity, value, startDate, endDate, isActive);
    }
}
