package za.ac.cput.domain;

import java.time.LocalDate;

public class BorrowTransaction {
    private int transactionIdentity;
    private int bookIdentity;
    private int userIdentity;
    private LocalDate borrowDate;
    private LocalDate dueDate;
    private LocalDate returnDate;
    private double amountFine;
    private String status;

    private BorrowTransaction(Builder builder) {
        this.transactionIdentity = builder.transactionIdentity;
        this.bookIdentity = builder.bookIdentity;
        this.userIdentity = builder.userIdentity;
        this.borrowDate = builder.borrowDate;
        this.dueDate = builder.dueDate;
        this.returnDate = builder.returnDate;
        this.amountFine = builder.amountFine;
        this.status = builder.status;
    }

    public int getTransactionIdentity() { return transactionIdentity; }
    public int getBookIdentity() { return bookIdentity; }
    public int getUserIdentity() { return userIdentity; }
    public LocalDate getBorrowDate() { return borrowDate; }
    public LocalDate getDueDate() { return dueDate; }
    public LocalDate getReturnDate() { return returnDate; }
    public double getAmountFine() { return amountFine; }
    public String getStatus() { return status; }

    @Override
    public String toString() {
        return "BorrowTransaction{" +
                "transactionIdentity=" + transactionIdentity +
                ", bookIdentity=" + bookIdentity +
                ", userIdentity=" + userIdentity +
                ", borrowDate=" + borrowDate +
                ", dueDate=" + dueDate +
                ", returnDate=" + returnDate +
                ", amountFine=" + amountFine +
                ", status='" + status + '\'' +
                '}';
    }

    public static class Builder {
        private int transactionIdentity;
        private int bookIdentity;
        private int userIdentity;
        private LocalDate borrowDate;
        private LocalDate dueDate;
        private LocalDate returnDate;
        private double amountFine;
        private String status;

        public Builder setTransactionIdentity(int transactionIdentity) {
            this.transactionIdentity = transactionIdentity;
            return this;
        }

        public Builder setBookIdentity(int bookIdentity) {
            this.bookIdentity = bookIdentity;
            return this;
        }

        public Builder setUserIdentity(int userIdentity) {
            this.userIdentity = userIdentity;
            return this;
        }

        public Builder setBorrowDate(LocalDate borrowDate) {
            this.borrowDate = borrowDate;
            return this;
        }

        public Builder setDueDate(LocalDate dueDate) {
            this.dueDate = dueDate;
            return this;
        }

        public Builder setReturnDate(LocalDate returnDate) {
            this.returnDate = returnDate;
            return this;
        }

        public Builder setAmountFine(double amountFine) {
            this.amountFine = amountFine;
            return this;
        }

        public Builder setStatus(String status) {
            this.status = status;
            return this;
        }

        public Builder copy(BorrowTransaction transaction) {
            this.transactionIdentity = transaction.transactionIdentity;
            this.bookIdentity = transaction.bookIdentity;
            this.userIdentity = transaction.userIdentity;
            this.borrowDate = transaction.borrowDate;
            this.dueDate = transaction.dueDate;
            this.returnDate = transaction.returnDate;
            this.amountFine = transaction.amountFine;
            this.status = transaction.status;
            return this;
        }

        public BorrowTransaction build() {
            return new BorrowTransaction(this);
        }
    }
}
