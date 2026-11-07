
package serveur;

import java.io.*;
import java.net.*;

public class ClientProcess extends Thread {

    Socket socket;
    int numeroClient;

    // Constructeur
    public ClientProcess(Socket socket, int numeroClient) {

        this.socket = socket;
        this.numeroClient = numeroClient;

    }

    public void run() {

        try {

            // Etape 1 : Creation du flux de sortie
            PrintWriter out = new PrintWriter(
                    socket.getOutputStream(), true
            );

            // Etape 2 : Envoyer le numero au client
            out.println("Vous êtes le client n°" + numeroClient);

            System.out.println("Numero envoyé au client n°" + numeroClient);

            // Etape 3 : Fermeture de la connexion
            socket.close();

        } catch (IOException e) {

            System.out.println("Erreur client n°" +
                    numeroClient + " : " + e.getMessage());

        }
    }
}
