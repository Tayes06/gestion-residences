package utils;

import java.util.Scanner;

public class Menu {
    public Menu() {
    }

    Scanner sc = new Scanner(System.in);

    public int menuPrincipal(){
        System.out.println("**********************************************************");
        System.out.println("**--------------- GESTION DES RESIDENCES ---------------**");
        System.out.println("**********************************************************\n");
        System.out.println("Que voulez-vous faire?");
        System.out.println("----------------------------------------------------------");
        System.out.println("1- Gérer les Utilisateurs");
        System.out.println("2- Gérer les Résidences");
        System.out.println("3- Gérer les Clients");
        System.out.println("4- Accéder aux Prestations de services");
        System.out.print("Votre choix: ");
        return sc.nextInt();
    }

    public int menuGestUsers(){
        System.out.println("**------------- INTERFACE UTILISATEUR -----------------**\n");
        System.out.println("1- Gerer les profils utilisateurs");
        System.out.println("2- Gerer les utilisateurs");
        System.out.print("Votre choix: ");
        return  sc.nextInt();
    }

    public int menuGestProfil(){
        System.out.println("**---------- GERER LES PROFILS UTILISATEURS -----------**\n");
        System.out.println("1- Créer un profil utilisateur");
        System.out.println("2- Lister les profils existants");
        System.out.println("3- Rechercher un profil en utilisant des mots clés");
        System.out.print("Votre choix: ");
        return  sc.nextInt();
    }
    public int menuGestProfilVoirPlus(){
        System.out.println("------ Que voulez-vous faire du profil sélectionné? ------");
        System.out.println("1- Modifier les données de ce profil");
        System.out.println("2- Supprimer les données de ce profil utilisateur");
        System.out.println("3- Consulter les données liées à ce profil utilisateur");
        System.out.print("Votre choix: ");
        return  sc.nextInt();
    }
    public int menuGestUser(){
        System.out.println("**---------- GESTION DES UTILISATEURS -----------**\n");
        System.out.println("1- Nouveau utilisateur");
        System.out.println("2- Lister les utilisateurs");
        System.out.println("3- Rechercher un utilisateur");
        System.out.print("Votre choix: ");
        return  sc.nextInt();
    }

    public int menuGestResidences(){
        System.out.println("**--- BIENVENUE DANS LA GESTION DES RESIDENCES ---**\n");
        System.out.println("1- Résidences");
        System.out.println("2- Unité de résidences");
        System.out.print("Votre choix: ");
        return  sc.nextInt();
    }

    public int menuGestResidence(){
        System.out.println("**----------- GESTION DES RESIDENCES ------------**\n");
        System.out.println("1- Créer une nouvelle résidence");
        System.out.println("2- Voir la liste des résidences");
        System.out.println("3- Rechercher une résidence");
        System.out.print("Votre choix: ");
        return  sc.nextInt();
    }

    public int menuGestUniteResidence(){
        System.out.println("**------- GESTION DES UNITES DE RESIDENCES -------**\n");
        System.out.println("1- Créer une nouvelle unoté de résidence");
        System.out.println("2- Voir les unités de résidence existants");
        System.out.println("3- Rechercher une unité de résidence particulière");
        System.out.print("Votre choix: ");
        return  sc.nextInt();
    }

    public int menuGestClient(){
        System.out.println("**------------- GESTION DES CLIENTS --------------**\n");
        System.out.println("1- Ajouter un nouveau client");
        System.out.println("2- Liste des clients");
        System.out.println("3- Rechercher un client");
        System.out.print("Votre choix: ");
        return  sc.nextInt();
    }

    public int menuGestPrestation(){
        System.out.println("**------------ GESTION DES PRESTATIONS ------------**\n");
        System.out.println("1- Nouvelle prestation de service");
        System.out.println("2- Liste des prestations de service");
        System.out.println("3- Rechercher une prestation");
        System.out.print("Votre choix: ");
        return  sc.nextInt();
    }
}
