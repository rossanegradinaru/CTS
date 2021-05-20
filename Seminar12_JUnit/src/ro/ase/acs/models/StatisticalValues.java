package ro.ase.acs.models;

import ro.ase.acs.exceptions.StatisticalException;

import java.util.ArrayList;
import java.util.List;

public class StatisticalValues {
    private List<Long> values = new ArrayList<>();

    public void setValues(List<Long> values) {
        this.values = values;
    }

    public long getMinim(){
        long min = Long.MAX_VALUE;
        for(int i=0; i < values.size(); i++){
            if(values.get(i) < min)
                min=values.get(i);
        }
        return min;
    }

    public double getAverage() throws StatisticalException {
        if(values == null ){
            throw new StatisticalException("Null values list");
        }

        if(values.isEmpty()){
            throw new StatisticalException("Empty values list");
        }

        if(values.contains(null)){
            throw  new StatisticalException("Null element");
        }
        double sum = 0;
        for(int i = 0; i < values.size(); i++) {
            sum += values.get(i);
        }
        return sum/values.size();
    };
}
