package fernando.br.valida;

import fernando.br.Entity;
import fernando.br.EntityVO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import static java.util.stream.Collectors.toList;

public class ComparableWIthMapService {

    private static final Logger LOGGER = Logger.getLogger(ComparableWIthMapService.class.getName());

    public static List<EntityVO> compare(
            final List<Entity> entityList,
            final List<EntityVO> entityVOList) {

        Map<String, EntityVO> mapVos = new HashMap<>();
        for (EntityVO entityVO : entityVOList) {
            mapVos.put(entityVO.mapComparableHash(), entityVO);
        }
        Map<String, Entity> mapEntities = new HashMap<>();
        for (Entity entity : entityList) {
            mapEntities.put(entity.mapComparableHash(), entity);
        }
        mapVos.keySet().removeAll(mapEntities.keySet());
        return mapVos.values().stream().collect(toList());
    }
}
