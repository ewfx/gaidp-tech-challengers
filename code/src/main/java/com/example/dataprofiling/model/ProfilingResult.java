
package com.example.dataprofiling.model;

public class ProfilingResult {
    private String columnName;
    private String profilingRule;
    private double riskScore;

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getProfilingRule() {
        return profilingRule;
    }

    public void setProfilingRule(String profilingRule) {
        this.profilingRule = profilingRule;
    }

    public double getRiskScore() {
        return riskScore;
    }

    public void setRiskScore(double riskScore) {
        this.riskScore = riskScore;
    }
}
