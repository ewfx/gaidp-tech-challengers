import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ProfilingService {

    public List<Map<String, Object>> processTransactions(List<Transaction> transactions) {
        return transactions.stream().map(txn -> {
            Map<String, Object> result = new HashMap<>();
            result.put("transactionId", txn.getTransactionId());
            result.put("riskScore", RiskScorer.calculateRisk(txn));
            result.put("violation", RuleGenerator.detectViolation(txn));
            return result;
        }).collect(Collectors.toList());
    }
}