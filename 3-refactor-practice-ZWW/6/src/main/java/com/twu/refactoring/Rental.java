package com.twu.refactoring;

public class Rental {

    private Movie movie;

    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public double getThisAmount() {
        double thisAmount = 0;
        double rentDayLimit;
        double newReleaseRate = 3;
        double rate = 1.5;
        switch (getMovie().getPriceCode()) {
            case Movie.REGULAR:
                rate = 1.5;
                rentDayLimit = 2;
                thisAmount += rentDayLimit;
                if (getDaysRented() > rentDayLimit)
                    thisAmount += (getDaysRented() - rentDayLimit) * rate;
                break;
            case Movie.NEW_RELEASE:
                rate =3;
                thisAmount += getDaysRented() * newReleaseRate;
                break;
            case Movie.CHILDRENS:
                rentDayLimit = 3;
                rate = 1.5;
                thisAmount += rate;
                if (getDaysRented() > rentDayLimit)
                    thisAmount += (getDaysRented() - rentDayLimit) * rate;
                break;
        }
        return thisAmount;
    }

    public int getFrequentRenterPointsIncrements() {
        int frequentRenterPoints = 0;
        frequentRenterPoints++;
        if ((getMovie().getPriceCode() == Movie.NEW_RELEASE)
                && getDaysRented() > 1)
            frequentRenterPoints++;
        return frequentRenterPoints;
    }
}
