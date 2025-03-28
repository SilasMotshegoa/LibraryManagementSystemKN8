package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;

/**
 * Author: Yvvonne Mthiyane
 * Student Number: 222530723
 */


@Entity
public class BookReservation {

    @Id
    private long reservationId;
    private long bookId;
    private long userId;
    private String status;

    private BookReservation(Builder builder) {

        this.reservationId = builder.reservationId;
        this.bookId = builder.bookId;
        this.userId = builder.userId;
        this.status = builder.status;

    }

    protected BookReservation() {

    }

    public long getReservationId() {
        return reservationId;
    }

    public long getBookId() {
        return bookId;
    }

    public long getUserId() {
        return userId;
    }

    public String getStatus() {
        return status;
    }


    @Override
    public String toString() {
        return "BookReservation{" +
                "reservationId=" + reservationId +
                ", bookId=" + bookId +
                ", userId=" + userId +
                ", status='" + status + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        BookReservation that = (BookReservation) o;
        return reservationId == that.reservationId && bookId == that.bookId && userId == that.userId && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reservationId, bookId, userId, status);
    }


    public static class Builder {

        private long reservationId;
        private long bookId;
        private long userId;
        private String status;

        public Builder setReservationId(long reservationId) {
            this.reservationId = reservationId;
            return this;
        }

        public Builder setBookId(long bookId) {
            this.bookId = bookId;
            return this;
        }

        public Builder setUserId(long userId) {
            this.userId = userId;
            return this;
        }

        public Builder setStatus(String status) {
            this.status = status;
            return this;
        }
        public Builder copy(BookReservation bookReservation) {
            this.reservationId = bookReservation.reservationId;
            this.bookId = bookReservation.bookId;
            this.userId = bookReservation.userId;
            this.status = bookReservation.status;
            return this;
        }


        public BookReservation build() {
            return new BookReservation(this);
        }
    }
}
