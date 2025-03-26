
package com.example.dataprofiling.service;

import com.example.dataprofiling.model.ProfilingResult;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProfilingService {

    public List<ProfilingResult> generateProfilingRules(List<String[]> data) {
        List<ProfilingResult> results = new ArrayList<>();
        String[] headers = data.get(0);

        for (int i = 1; i < data.size(); i++) {
            String[] row = data.get(i);

            for (int j = 0; j < headers.length; j++) {
                String columnName = headers[j];
                String value = row[j];
                ProfilingResult result = new ProfilingResult();

                result.setColumnName(columnName);
                result.setProfilingRule(validateRule(columnName, value, row));
                result.setRiskScore(calculateRiskScore(columnName, value));
                results.add(result);
            }
        }

        return results;
    }

    private String validateRule(String column, String value, String[] row) {
        switch (column) {
            case "AccountNumber":
                if (value == null || value.length() < 10 || value.length() > 12) {
                    return "Invalid account number format (should be 10-12 characters)";
                }
                break;
            case "TransactionDate":
                if (!value.matches("\\d{4}-\\d{2}-\\d{2}")) {
                    return "Invalid date format (should be YYYY-MM-DD)";
                }
                break;
            case "Amount":
                try {
                    double amount = Double.parseDouble(value);
                    double balance = Double.parseDouble(row[10]);
                    if (amount <= 0 || amount > balance) {
                        return "Invalid amount (should be > 0 and within account balance)";
                    }
                } catch (Exception e) {
                    return "Amount should be numeric";
                }
                break;
            case "Currency":
                if (!value.matches("USD|EUR|GBP")) {
                    return "Invalid currency (should be USD, EUR, or GBP)";
                }
                break;
            case "Age":
                try {
                    int age = Integer.parseInt(value);
                    if (age < 18 || age > 100) {
                        return "Invalid age (should be between 18 and 100)";
                    }
                } catch (Exception e) {
                    return "Age should be numeric";
                }
                break;
            case "AccountStatus":
                if (!value.matches("Active|Inactive|Closed")) {
                    return "Invalid account status";
                }
                break;
            case "CustomerName":
                if (value == null || value.isEmpty()) {
                    return "Customer name is missing";
                }
                break;
            default:
                return "No rule applied";
        }
        return "Valid";
    }

    private double calculateRiskScore(String column, String value) {
        switch (column) {
            case "AccountNumber":
                return (value == null || value.length() < 10 || value.length() > 12) ? 8.0 : 2.0;
            case "TransactionDate":
                return (!value.matches("\\d{4}-\\d{2}-\\d{2}")) ? 7.0 : 2.0;
            case "Amount":
                double amount = Double.parseDouble(value);
                if (amount <= 0 || amount > 1_000_000) return 9.0;
                return 2.0;
            case "Currency":
                return (!value.matches("USD|EUR|GBP")) ? 6.0 : 1.0;
            case "Age":
                int age = Integer.parseInt(value);
                return (age < 18 || age > 100) ? 7.0 : 1.0;
            default:
                return 0.0;
        }
    }
}
