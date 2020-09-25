package fernando.br.valida;

import fernando.br.Entity;
import fernando.br.EntityVO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

public class ComparableWIthOn2Service {

    private static final Logger LOGGER = Logger.getLogger(ComparableWIthOn2Service.class.getName());

    public static List<EntityVO> compare(
            final List<Entity> entityList,
            final List<EntityVO> entityVOList) {

        List<EntityVO> newEntities = new ArrayList<>();
        for (EntityVO entityVO : entityVOList) {
            boolean found = false;
            for (Entity entity : entityList) {
                if (isEquivalentWithEqualsFields(entity, entityVO)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                newEntities.add(entityVO);
            }
        }
        return newEntities;
    }

    private static boolean isEquivalentWithEqualsFields(Entity entity, EntityVO entityVO) {
        if (entity == null || entityVO == null) {
            return false;
        }

        return isActiveEquals(entity.getActive(), entityVO.getActive())
                && isQuantityEquals(entity.getQuantity(), entityVO.getQuantity())
                && isValueEquals(entity.getValue(), entityVO.getValue())
                && isTransactionCostEquals(entity, entityVO)
                && isDateEquals(entity.getStartDate(), entityVO.getStartDate())
                && isDateEquals(entity.getEndDate(), entityVO.getEndDate());
    }

    private static boolean isDateEquals(final Date dateEntity, final Date dateVo) {
        return dateEntity != null
                ? dateEntity.equals(dateVo)
                : dateVo != null;
    }

    private static boolean isTransactionCostEquals(
            final Entity entity, final EntityVO entityVO) {
        return entity.getType() != null
                ? entity.getType() == entityVO.getType()
                : entityVO.getType() != null;
    }

    private static boolean isValueEquals(
            final BigDecimal entityValue, final BigDecimal entityVOValue) {
        return entityValue != null
                ? entityValue.equals(entityVOValue)
                : entityVOValue != null;
    }

    private static boolean isQuantityEquals(
            final Integer entity, final Integer entityVO) {
        return entity != null
                ? entity.equals(entityVO)
                : entityVO != null;
    }

    private static boolean isActiveEquals(
            final Boolean entity, final Boolean entityVO) {
        return entity!= null
                ? entity.equals(entityVO)
                : entityVO != null;
    }

}
