package net.lecnam.ecue2.revisions;


import java.time.LocalDate;

public abstract class CompteBancaire {

    // Attributs privés
    private String numeroCompte;
    private double solde;
    private Client titulaire;
    private LocalDate dateOuverture;

    public CompteBancaire(String numeroCompte, Client titulaire) {
        this.numeroCompte = numeroCompte;
        this.titulaire = titulaire;
        this.dateOuverture = LocalDate.now();
        this.solde = 0.0;
    }

    public CompteBancaire(String numeroCompte, double solde, Client titulaire, LocalDate dateOuverture) {
        this.numeroCompte = numeroCompte;
        this.solde = solde;
        this.titulaire = titulaire;
        this.dateOuverture = dateOuverture;
    }

    public String getNumeroCompte() {
        return numeroCompte;
    }

    public void setNumeroCompte(String numeroCompte) {
        this.numeroCompte = numeroCompte;
    }

    public double getSolde() {
        return solde;
    }


    public Client getTitulaire() {
        return titulaire;
    }

    public void setTitulaire(Client titulaire) {
        this.titulaire = titulaire;
    }

    public LocalDate getDateOuverture() {
        return dateOuverture;
    }

    public void setDateOuverture(LocalDate dateOuverture) {
        this.dateOuverture = dateOuverture;
    }
    public void deposer(double montant) {
        if (montant <= 0) {
            throw new IllegalArgumentException(
                    "Le montant du depot doit etre strictement positif"
            );
        }
        solde += montant;
    }

    protected void debiter(double montant){
        solde -= montant;
    }

    public abstract void retirer(double montant)
            throws SoldeInsuffisantException ;

    public abstract double calculerInterets();

    public void appliquerInterets() {
        solde += calculerInterets();
    }

    @Override
    public String toString() {
        return "CompteBancaire{" +
                "numeroCompte='" + numeroCompte + '\'' +
                ", solde=" + solde +
                ", titulaire=" + titulaire +
                ", dateOuverture=" + dateOuverture +
                '}';
    }
}
