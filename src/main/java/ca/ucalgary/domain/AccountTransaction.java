package ca.ucalgary.domain;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

/**
 * Representation of an audit trail of all the operations done on an account domain object
 */
public class AccountTransaction {
    private UUID id; // Identify individual transactions
    private UUID accountId; // Identify account
    private String type; // Type of a transaction, e.g. 'Deposit', 'Withdraw', or 'Create'
    private double amount; // Amount of money to be part of this transaction, if any
    private String status; // To represent if the transaction was successful, or failed
    private LocalDateTime txDate; // Transaction date/time

    private AccountTransaction(){
        // We should never create an empty transaction
    }

    public AccountTransaction(UUID accountId, String type, double amount){
        this.id = UUID.randomUUID();
        this.accountId = accountId;
        this.type = type;
        this.amount = amount;
        this.status = "PENDING"; // Whenever you create a transaction the transaction is not completed yet
        this.txDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "AccountTransaction{" +
                "id=" + id +
                ", accountId=" + accountId +
                ", type='" + type + '\'' +
                ", amount=" + amount +
                ", status='" + status + '\'' +
                ", txDate=" + txDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AccountTransaction)) return false;
        AccountTransaction that = (AccountTransaction) o;
        return Double.compare(that.amount, amount) == 0 &&
                id.equals(that.id) &&
                accountId.equals(that.accountId) &&
                type.equals(that.type) &&
                status.equals(that.status) &&
                txDate.equals(that.txDate);
    }

    // Used to speed up Java collections management
    // e.g. List<Account>
    @Override
    public int hashCode() {
        return Objects.hash(id, accountId, type, amount, status, txDate);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public UUID getAccountId() {
        return accountId;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getTxDate() {
        return txDate;
    }
}