public class RiskScorer {

    public static double calculateRisk(Transaction txn) {
        double risk = 0.1;
        if (txn.getAmount() > 10000) risk += 0.7;
        if (txn.getAmount() < 0) risk += 1.0;
        if (txn.getCustomerAge() > 65) risk += 0.3;
        return Math.min(risk, 1.0);
    }
}