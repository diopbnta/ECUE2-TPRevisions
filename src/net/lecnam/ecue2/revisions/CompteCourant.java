package net.lecnam.ecue2.revisions;


import java.time.LocalDate;

public class CompteCourant extends CompteBancaire {

    // Attribut supplémentaire
    private double decouvertAutorise;

    // Constructeur avec découvert autorisé
    public CompteCourant(String numeroCompte, Client titulaire,
                         double decouvertAutorise) {
        super(numeroCompte, titulaire);
        this.decouvertAutorise = decouvertAutorise;
    }

    // Constructeur avec découvert par défaut de 500 €
    public CompteCourant(String numeroCompte, Client titulaire) {
        this(numeroCompte, titulaire, 500.0);
    }

    // Constructeur complet pour recréer un compte existant
    public CompteCourant(String numeroCompte, Client titulaire,
                         LocalDate dateOuverture, double solde,
                         double decouvertAutorise) {
        super(numeroCompte, titulaire, dateOuverture, solde);
        this.decouvertAutorise = decouvertAutorise;
    }

    // Getter
    public double getDecouvertAutorise() {
        return decouvertAutorise;
    }

    // Retrait avec prise en compte du découvert autorisé
    @Override
    public void retirer(double montant) throws SoldeInsuffisantException {

        if (montant <= 0) {
            throw new IllegalArgumentException(
                    "Le montant du retrait doit être positif."
            );
        }

        if (getSolde() - montant >= -decouvertAutorise) {

            debiter(montant);

        } else {

            double montantManquant =
                    montant - (getSolde() + decouvertAutorise);

            throw new SoldeInsuffisantException(
                    "Solde insuffisant pour effectuer ce retrait.",
                    montantManquant
            );
        }
    }

    // Un compte courant ne rapporte pas d'intérêts
    @Override
    public double calculerInterets() {
        return 0.0;
    }

    // Affichage des informations du compte courant
    @Override
    public String toString() {
        return "CompteCourant{" +
                "numeroCompte='" + getNumeroCompte() + '\'' +
                ", solde=" + getSolde() +
                ", titulaire=" + getTitulaire() +
                ", dateOuverture=" + getDateOuverture() +
                ", decouvertAutorise=" + decouvertAutorise +
                '}';
    }
}


