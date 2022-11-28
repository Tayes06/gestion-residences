package treatments;

import utils.ConnectBD;
import utils.Menu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ProfilUser {
    private String titre;
    private String description;
    int idP;
    Scanner sc = new Scanner(System.in);
    Menu menu = new Menu();
    ConnectBD connexion = new ConnectBD();
    Connection conn = connexion.connexionBD();



    public ProfilUser(){
        this.titre = " ";
        this.description = " ";
    }
    public ProfilUser(String titre, String description) {
        this.titre = titre;
        this.description = description;
    }

    //creer nouveau profil
    public void addProfil(){
        ConnectBD connexion = new ConnectBD();
        try{
            Connection conn = connexion.connexionBD();
            System.out.println("Ajouter un nouveau profil dans la base de données?");
            char decision;
            do{
                System.out.print("\nEntrer le titre du profil: ");
                this.titre = sc.nextLine();
                System.out.println("\nEntrer une description:");
                this.description = sc.nextLine();
                String req = "INSERT INTO `profil`(`nomProfil`, `descProfil`) VALUES ('"+this.titre+"','"+this.description+"')";
                Statement stm = conn.createStatement();
                stm.executeUpdate(req);
                System.out.println("Profil "+this.titre+" ajouté avec succès!\n");
                System.out.print("Enregistrer un autre profil?  (o/n): ");
                decision = sc.nextLine().charAt(0);
            }while (decision!='o'|| decision!= 'O');

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //lister profils
    public void listProfils(){
        try{
            String req = "SELECT * FROM `profil` WHERE 1";
            Statement stm = conn.createStatement();
            ResultSet res = stm.executeQuery(req);

            System.out.println("|*************************************************************************************************|");
            System.out.println("|********************************      LISTE DES PROFILS       ***********************************|\n");
            System.out.print("|*   ID  *|");
            System.out.print("*       NOM PROFIL       *|");
            System.out.println("*                          DESCRIPTION                     *|");
            System.out.println(" -------------------------------------------------------------------------------------------------");
            while (res.next()){
                int id = res.getInt("idProfil");
                String nomProfil = res.getString("nomProfil");
                String descProfil = res.getString("descProfil");

                System.out.print("|    "+id+"    ");
                System.out.print("|       "+nomProfil+"       ");
                System.out.println("    "+descProfil+" ");
                System.out.println(" -------------------------------------------------------------------------------------------------");

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        char rep;
        System.out.print("Effectuer des actions supplémentaires? (O/N): \n");
        rep = sc.nextLine().charAt(0);
        if(rep == 'O' || rep == 'o'){
            System.out.println("Entrez le numéro d'ID du profil:\n");
            idP = sc.nextInt();
            int choix = menu.menuGestProfilVoirPlus();

            if (choix == 1){
                updateProfil();
            }else if(choix == 2){
                deleteProfil();
            }
        }

    }
    public void updateProfil(){
        ConnectBD connexion = new ConnectBD();
        char rep;
        String nomProfil;
        String descProfil;
        try {
            Connection conn = connexion.connexionBD();
            String req = "SELECT * FROM `profil` WHERE `idProfil`="+idP+" ";
            Statement stm = conn.createStatement();
            ResultSet res = stm.executeQuery(req);
            System.out.print("|*   ID  *|");
            System.out.print("*       NOM PROFIL       *|");
            System.out.println("*                          DESCRIPTION                     *|");
            System.out.println(" -------------------------------------------------------------------------------------------------");
            while (res.next()){
                int id = res.getInt("idProfil");
                nomProfil = res.getString("nomProfil");
                descProfil = res.getString("descProfil");

                System.out.print("|    "+id+"    ");
                System.out.print("|       "+nomProfil+"       ");
                System.out.println("    "+descProfil+" ");
                System.out.println(" -------------------------------------------------------------------------------------------------");

            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        do {
            System.out.print("Modifier le nom? (O/N): ");
            rep = new Scanner(System.in).nextLine().charAt(0);
            if (rep == 'o' || rep == 'O'){
                System.out.println("Nouveau nom de profil:");
                nomProfil = new Scanner(System.in).nextLine();

                Connection conn = connexion.connexionBD();
                String req = "UPDATE `profil` SET `nomProfil`='"+nomProfil+"' WHERE `idProfil`="+idP+"";
                try {
                    Statement stm = conn.createStatement();
                    stm.executeUpdate(req);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            }else if (rep == 'n' || rep == 'N') break;
            else System.out.println("Choix non disponible!");
        }while (rep != 'o' || rep != 'O');

        do {
            System.out.print("Modifier la description? (O/N): ");
            rep = new Scanner(System.in).nextLine().charAt(0);
            if (rep == 'o' || rep == 'O'){
                System.out.println("Nouvelle description :");
                descProfil = new Scanner(System.in).nextLine();

                Connection conn = connexion.connexionBD();
                String req = "UPDATE `profil` SET `descProfil`='"+descProfil+"' WHERE `idProfil`="+idP+"";
                try {
                    Statement stm = conn.createStatement();
                    stm.executeUpdate(req);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            }else if (rep == 'n' || rep == 'N') break;
            else System.out.println("Choix non disponible!");
        }while (rep != 'o' || rep != 'O');
        System.out.println("Modification enregistrée avec succès!");

    }

    public void deleteProfil(){
        String req = "DELETE FROM `profil` WHERE  `idProfil`="+idP+" ";
        try {
            Statement stm = conn.createStatement();
            stm.executeUpdate(req);
            System.out.println("Le profil ayant pour numéro d'identifiant "+idP+" supprimé avec succès!");
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void consulterDonnees(){
        String req = "SELECT `utilisateur.idProfil`, `profil.idProfil`, `nomProfil`, `idUser`, `nomUser`, `prenomUser`,  FROM `profil`, `utilisateur` WHERE `utilisateur.idProfil`= `profil.idProfil`";
        try {
            Statement stm = conn.createStatement();
            ResultSet res = stm.executeQuery(req);
            System.out.println("|*************************************************************************************************|");
            System.out.println("|**********************      PLUS D'INFOS SUR LE PROFIL SELECTIONNE       ************************|\n");
            System.out.print("*       NOM PROFIL       *|");
            System.out.print("*    NOM UTILISATEUR     *|");
            System.out.print("*  PRENOM UTILISATEUR    *|");

            System.out.println("*                          DESCRIPTION                     *|");
            System.out.println(" -------------------------------------------------------------------------------------------------");
            while (res.next()){

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getDescription() {
        return description;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
