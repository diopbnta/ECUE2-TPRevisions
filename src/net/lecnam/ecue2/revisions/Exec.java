package net.lecnam.ecue2.revisions;

public class Exec {
    static void main() {
        exercice1();

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
}
