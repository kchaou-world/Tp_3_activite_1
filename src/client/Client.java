
package client;

import java.io.*;
import java.net.*;

public class Client {

    public static void main(String[] args) {

        try {

            // Etape 1 : Adresse IP du serveur
            InetAddress adresseServeur =
                    InetAddress.getByName("localhost");

            // Etape 2 : Creation de l'adresse socket
            InetSocketAddress adresseSocket =
                    new InetSocketAddress(adresseServeur, 1234);

            // Etape 3 : Connexion au serveur
            Socket socket = new Socket();

            socket.connect(adresseSocket);

            System.out.println("Connecté au serveur");

            // Etape 4 : Reception du numero
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );

            String message = in.readLine();

            System.out.println("Message du serveur : " + message);

            // Etape 5 : Fermeture
            socket.close();

        } catch (IOException e) {

            System.out.println("Erreur client : " + e.getMessage());

        }
    }
}
