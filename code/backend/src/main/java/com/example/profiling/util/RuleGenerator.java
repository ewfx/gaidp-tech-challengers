public class RuleGenerator {

    public static String detectViolation(Transaction txn) {
        if (txn.getAmount() < 0) return "Negative amount detected";
        if (txn.getAmount() > 10000) return "Large transaction";
        if (txn.getCustomerAge() > 65) return "Elderly customer transaction";
        return "No violation";
    }
}