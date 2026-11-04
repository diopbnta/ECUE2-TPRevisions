package net.lecnam.ecue2.revisions;

public class SoldeInsuffisantException extends Exception{
    private double MontantManquant;
    public SoldeInsuffisantException(String message) {
        super(message);
        this.MontantManquant =0.0;
    }

    public SoldeInsuffisantException(String message, double MontantManquant) {
        super(message);
        this.MontantManquant = MontantManquant;
    }

    public double getMontantManquant() {
        return MontantManquant;
    }
}
