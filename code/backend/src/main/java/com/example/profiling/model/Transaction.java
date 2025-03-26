import lombok.Data;

@Data
public class Transaction {
    private String transactionId;
    private double amount;
    private String currency;
    private String country;
    private String status;
    private String accountType;
    private String transactionType;
    private String date;
    private int customerAge;
}