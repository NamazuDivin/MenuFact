package code.menufact;

/**
 * Classe contenant les informations des clients du système MenuFact
 *
 * @author Domingo
 * @version 1.0
 */
public class Client {
    private int idClient;
    private String nom;
    private String numeroCarteCredit;

    /**
     * Crée un client avec ses informations
     *
     * @param idClient
     * @param nom
     * @param numeroCarteCredit
     */
    public Client(int idClient, String nom, String numeroCarteCredit) {
        this.idClient = idClient;
        this.nom = nom;
        this.numeroCarteCredit = numeroCarteCredit;
    }

    /**
     * Retourne l'indentifiant du client
     *
     * @return l'identifiant du client
     */
    public int getIdClient() {
        return idClient;
    }

    /**
     * Modifie l'identifiant du client
     *
     * @param idClient
     */
    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    /**
     * Retourne le nom du client
     *
     * @return le nom du client
     */
    public String getNom() {
        return nom;
    }

    /**
     * Modifie le nom d'un client
     *
     * @param nom le nouveau nom du client
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Retourne le numéro de la carte de crédit du client
     *
     * @return le numéro de la carte de crédit du client
     */
    public String getNumeroCarteCredit() {
        return numeroCarteCredit;
    }

    /**
     * Modifie le numéro de la carte de crédit du client
     *
     * @param numeroCarteCredit le nouveau numéro de la carte de crédit du client
     */
    public void setNumeroCarteCredit(String numeroCarteCredit) {
        this.numeroCarteCredit = numeroCarteCredit;
    }

    /**
     * Retourne les informations du client en texte
     *
     * @return les informations du client en texte
     */
    @Override
    public String toString() {
        return "menufact.Client{" +
                "idClient=" + idClient +
                ", nom='" + nom + '\'' +
                ", numeroCarteCredit='" + numeroCarteCredit + '\'' +
                '}';
    }
}
/*
@startuml
class menufact.Client{}
* */