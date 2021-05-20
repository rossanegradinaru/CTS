package ro.ase.acs.tests;

import org.junit.Test;
import static org.junit.Assert.*;

import ro.ase.acs.exceptions.StatisticalException;
import ro.ase.acs.models.StatisticalValues;

import java.util.ArrayList;
import java.util.List;

public class StatisticalValuesTests {
    @Test
    public void testMin(){
        List<Long> values = new ArrayList<>();
        values.add(1L);
        values.add(2L);
        values.add(3L);

        StatisticalValues statistics = new StatisticalValues();
        statistics.setValues(values);

        long result = statistics.getMinim();
        assertEquals("Incorrect min",1,result);
    }

    @Test
    public void testGetAverageForThreeValues() {
        List<Long> values = new ArrayList<>();
        values.add(1L);
        values.add(2L);
        values.add(3L);

        StatisticalValues statistics = new StatisticalValues();
        statistics.setValues(values);

        double result = 0;
        try {
            result = statistics.getAverage();
        } catch (StatisticalException e) {
            fail(e.getMessage());
        }
        assertEquals("Average is not correct",2,result,0.01);

    }

    @Test(expected = StatisticalException.class)
    public void testGetAverageForEmptyList() throws StatisticalException {
        List<Long> values = new ArrayList<>();

        StatisticalValues statistics = new StatisticalValues();
        statistics.setValues(values);
        statistics.getAverage();
    }

    @Test(expected = StatisticalException.class)
    public void testGetAverageNullList() throws StatisticalException {
        List<Long> values = null;

        StatisticalValues statistics = new StatisticalValues();
        statistics.setValues(values);
        statistics.getAverage();
    }

    @Test
    public void testGetAverageSingleValue() throws StatisticalException {
        List<Long> values = new ArrayList<>();
        values.add(1L);

        StatisticalValues statistics = new StatisticalValues();
        statistics.setValues(values);
        double result = 0;
        result = statistics.getAverage();

        assertEquals("Incorrect average",1,result,0.01);
    }

    @Test(expected = StatisticalException.class)
    public void testGetAverageNullElement() throws StatisticalException {
        List<Long> values = new ArrayList<>();
        values.add(null);

        StatisticalValues statistics = new StatisticalValues();
        statistics.setValues(values);
        statistics.getAverage();
    }

    @Test
    public void testGetAverageFloatForValues() throws StatisticalException{
        List<Long> values = new ArrayList<>();
        values.add(2L);
        values.add(2L);
        values.add(3L);

        StatisticalValues statistics = new StatisticalValues();
        statistics.setValues(values);

        double result = statistics.getAverage();
        assertEquals("Average is not correct",2.33,result,0.01);
    }

}
