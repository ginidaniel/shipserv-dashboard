package dashboard.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Entity which contains stats related to bookings for specific company
 *
 * @author Daniel Gini
 */
public class BookingsDashboard {

    private long lost;
    private long won;
    private long unactioned;
    private long quoted;
    private long declined;

    private long totalQuotes;
    private long totalNoQuotes;
    private long totalBookings;

    private BigDecimal quoteRate;
    private BigDecimal noQuoteRate;
    private BigDecimal winRate;
    private BigDecimal quotePending;
    private BigDecimal lostRate;

    private BigDecimal amountWon;

    public BookingsDashboard(long unactioned, long declined, long quoted, long lost, long won, BigDecimal amountWon) {
        this.lost = lost;
        this.declined = declined ;
        this.won = won;
        this.unactioned = unactioned;
        this.quoted = quoted;

        this.totalQuotes = lost + won + quoted;
        this.totalNoQuotes = unactioned + declined;
        this.totalBookings = totalQuotes + totalNoQuotes;

        this.quoteRate = new BigDecimal(totalQuotes*100).setScale(2).divide(new BigDecimal(totalBookings),RoundingMode.HALF_UP);
        this.noQuoteRate = new BigDecimal(totalNoQuotes*100).setScale(2).divide(new BigDecimal(totalBookings),RoundingMode.HALF_UP);

        this.winRate = BigDecimal.ZERO;
        this.lostRate = BigDecimal.ZERO;
        this.quotePending = BigDecimal.ZERO;
        if (totalQuotes>0) {
            this.winRate = new BigDecimal(this.won*100).setScale(2).divide(new BigDecimal(totalQuotes),RoundingMode.HALF_UP);
            this.lostRate = new BigDecimal(this.lost*100).setScale(2).divide(new BigDecimal(totalQuotes),RoundingMode.HALF_UP);
            this.quotePending = new BigDecimal(this.quoted*100).setScale(2).divide(new BigDecimal(totalQuotes),RoundingMode.HALF_UP);
        }

        this.amountWon = amountWon.setScale(2);
    }

    public long getLost() {
        return lost;
    }

    public long getWon() {
        return won;
    }

    public long getUnactioned() {
        return unactioned;
    }

    public long getQuoted() {
        return quoted;
    }

    public long getDeclined() {
        return declined;
    }

    public long getTotalQuotes() {
        return totalQuotes;
    }

    public long getTotalNoQuotes() {
        return totalNoQuotes;
    }

    public long getTotalBookings() {
        return totalBookings;
    }

    public BigDecimal getQuoteRate() {
        return quoteRate;
    }

    public BigDecimal getNoQuoteRate() {
        return noQuoteRate;
    }

    public BigDecimal getWinRate() {
        return winRate;
    }

    public BigDecimal getQuotePending() {
        return quotePending;
    }

    public BigDecimal getLostRate() {
        return lostRate;
    }

    public BigDecimal getAmountWon() {
        return amountWon;
    }
}
