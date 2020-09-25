package fernando.br.valida;

import fernando.br.Entity;
import fernando.br.EntityType;
import fernando.br.EntityVO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.lang.String.format;

public class ComparableServiceTest {

    Date dateStart = new Date(15000000);
    Date dateEnd = new Date(15000002);
    List<Entity> currentList;
    List<EntityVO> newItens;

    @BeforeEach
    public void setUp() {
        currentList = new ArrayList<>();
        newItens = new ArrayList<>();
    }

    @ParameterizedTest
    @ValueSource(ints = { 1, 100, 500, 1000, 10000 })
    public void testTime_with100(int size) {
        fillLists(size);

        for (int i = 0; i < 5; i++) {
            long start = System.nanoTime();
            ComparableWIthOn2Service.compare(currentList, newItens);
            long end = System.nanoTime();

            long time = end - start;
            System.out.println(format("(size: %s) Atual O(n)2 levou: %s", size, time));

            long start2 = System.nanoTime();
            ComparableWIthMapService.compare(currentList, newItens);
            long end2 = System.nanoTime();

            long time2 = end2 - start2;
            System.out.println(format("(size: %s) Novo Map    levou: %s", size, time2));
        }
    }

    @Order(1)
    @RepeatedTest(value = 5)
    public void testTimeOn2_with100(TestInfo testInfo) {
        fillLists(100);

        long start = System.currentTimeMillis();
        ComparableWIthOn2Service.compare(currentList, newItens);
        long end = System.currentTimeMillis();

        System.out.println(format("(%s)[%s] Atual O(n)2 levou: %s", testInfo.getDisplayName(), 100, (end-start)));
    }

    @Order(2)
    @RepeatedTest(value = 5)
    public void testTimeSemOn2_with100(TestInfo testInfo) {
        fillLists(100);

        long start = System.currentTimeMillis();
        ComparableWIthMapService.compare(currentList, newItens);
        long end = System.currentTimeMillis();

        System.out.println(format("(%s)[%s] Novo sem O(n)2 levou: %s", testInfo.getDisplayName(), 100, (end-start)));
    }

    @Order(3)
    @RepeatedTest(value = 5)
    public void testTimeOn2_with500(TestInfo testInfo) {
        fillLists(500);

        long start = System.currentTimeMillis();
        ComparableWIthOn2Service.compare(currentList, newItens);
        long end = System.currentTimeMillis();

        System.out.println(format("(%s)[%s] Atual O(n)2 levou: %s", testInfo.getDisplayName(), 500, (end-start)));
    }

    @Order(4)
    @RepeatedTest(value = 5)
    public void testTimeSemOn2_with500(TestInfo testInfo) {
        fillLists(500);

        long start = System.currentTimeMillis();
        ComparableWIthMapService.compare(currentList, newItens);
        long end = System.currentTimeMillis();

        System.out.println(format("(%s)[%s] Novo sem O(n)2 levou: %s", testInfo.getDisplayName(), 500, (end-start)));
    }

    @Order(3)
    @RepeatedTest(value = 5)
    public void testTimeOn2_with1000(TestInfo testInfo) {
        fillLists(1000);

        long start = System.currentTimeMillis();
        ComparableWIthOn2Service.compare(currentList, newItens);
        long end = System.currentTimeMillis();

        System.out.println(format("(%s)[%s] Atual O(n)2 levou: %s", testInfo.getDisplayName(), 1000, (end-start)));
    }

    @Order(4)
    @RepeatedTest(value = 5)
    public void testTimeSemOn2_with1000(TestInfo testInfo) {
        fillLists(1000);

        long start = System.currentTimeMillis();
        ComparableWIthMapService.compare(currentList, newItens);
        long end = System.currentTimeMillis();

        System.out.println(format("(%s)[%s] Novo sem O(n)2 levou: %s", testInfo.getDisplayName(), 1000, (end-start)));
    }

    private void fillLists(int size) {
        for (int i = 0; i < size; i++) {
            currentList.add(new Entity(EntityType.TYPE1, i, BigDecimal.ONE, dateStart, dateEnd, true));
            newItens.add(new EntityVO(EntityType.TYPE2, i, BigDecimal.ONE, dateStart, dateEnd, true));
        }
    }
}