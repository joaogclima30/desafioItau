package com.desafioItau.joaogclima30.desafioItau.dto;

import jakarta.validation.constraints.NotNull;

import java.util.DoubleSummaryStatistics;

public class EstatisticasResponse {


    private Long count;
    private double sum;
    private double avg;
    private double min;
    private double max;

    public EstatisticasResponse(DoubleSummaryStatistics stats) {
        this.count = stats.getCount();
        this.sum = stats.getSum();
        this.avg = stats.getAverage();
        this.min = (this.count == 0) ? 0.0 : stats.getMin();
        this.max = (this.count == 0) ? 0.0 : stats.getMax();
    }

    public Long getCount() {
        return count;
    }

    public double getSum() {
        return sum;
    }

    public double getAvg() {
        return avg;
    }

    public double getMax() {
        return max;
    }

    public double getMin() {
        return min;
    }
}
