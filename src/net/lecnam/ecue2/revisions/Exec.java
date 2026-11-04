package net.lecnam.ecue2.revisions;

public class Exec {
    static void main() {
        //exercice1();
        //exercice2();
        exercice4();

    }

    private static void exercice1() {

        // Création des clients
        Client client1 = new Client("DIOP", "Alioune", "C001");
        Client client2 = new Client("DUPONT", "Jean", "C001");
        Client client3 = new Client("MARTIN", "Paul", "C002");

        // Affichage des clients avec toString()

        System.out.println(client1);
        System.out.println(client2);
        System.out.println(client3);

        // Test des getters

        System.out.println("Nom : " + client1.getNom());
        System.out.println("Prénom : " + client1.getPrenom());
        System.out.println("Numéro client : " + client1.getNumeroClient());

        // Test de equals()

        System.out.println("client1 et client2 sont égaux : "
                + client1.equals(client2));

        System.out.println("client1 et client3 sont égaux : "
                + client1.equals(client3));
    }
    private static void exercice2(){
        try{
            throw new SoldeInsuffisantException(
                    "le solde est insuffiasant",150.15
            );

        }catch (SoldeInsuffisantException e){
            System.out.println("Erreur : "+e.getMessage());
            System.out.println("Montant Manquant " + e.getMontantManquant() + " euros");
        }

    }


    private static void exercice4() {

        Client client = new Client("DIOP", "Alioune", "C001");

        // Création d'un compte courant avec découvert de 500 €
        CompteCourant compte = new CompteCourant("CC001", client, 500.0);

        // Dépôt de 300 €
        compte.deposer(300);

        System.out.println("Solde initial : " + compte.getSolde());

        try {
            // Retrait de 600 €
            compte.retirer(600);
            System.out.println("Retrait effectué.");

            System.out.println("Nouveau solde : " + compte.getSolde());

            // Retrait supplémentaire de 300 €
            compte.retirer(300);

        } catch (SoldeInsuffisantException e) {

            System.out.println("Erreur : " + e.getMessage());
            System.out.println("Montant manquant : "
                    + e.getMontantManquant() + " €");
        }

        System.out.println(compte);
    }



}
