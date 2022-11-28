package appli;

import treatments.ProfilUser;
import utils.Menu;

public class Application {
    public static void main(String[] args) {
        Menu menu = new Menu();

        int choixP = menu.menuPrincipal();
        switch (choixP){
            case 1: int choixGestUsers = menu.menuGestUsers();
                    if(choixGestUsers == 1){
                        int choixGestProfil = menu.menuGestProfil();
                        ProfilUser profil = new ProfilUser();
                        switch (choixGestProfil){
                            case 1:
                                profil.addProfil();
                                break;
                            case 2:
                                profil.listProfils();

                                break;
                            case 3:
                                break;
                            case 4:
                                break;
                            case 5:
                                break;
                            case 6:
                                break;
                            default:
                                System.out.println("Choix non disponible!");
                        }
                    }else if(choixGestUsers == 2){

                    }else {
                        System.out.println("Choix non disponible");
                    }
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            default:
                System.out.println("Choix non disponible! Veuillez ressayer...");
                break;
        }
    }
}
