
package serveur;

import java.io.*;
import java.net.*;

public class ServeurMT extends Thread {

    public void run() {

        try {

            // Etape 1 : Creation du serveur
            ServerSocket socketServeur = new ServerSocket(1234);

            System.out.println("Serveur en attente de connexion...");

            int numeroClient = 0;

            // Etape 2 : Accepter plusieurs clients
            while (true) {

                Socket socket = socketServeur.accept();

                numeroClient++;

                System.out.println("Client n°" + numeroClient +
                        " connecté : " + socket.getRemoteSocketAddress());

                // Etape 3 : Creer un thread pour chaque client
                new ClientProcess(socket, numeroClient).start();

            }

        } catch (IOException e) {

            System.out.println("Erreur serveur : " + e.getMessage());

        }
    }

    public static void main(String[] args) {

        // Demarrer le serveur multi-threads
        new ServeurMT().start();

    }
}
