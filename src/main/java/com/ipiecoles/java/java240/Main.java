package com.ipiecoles.java.java240;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Scanner;

@Component
public class Main implements CommandLineRunner {

    @Resource(name = "bitcoinServiceCacheProperty")
    private BitcoinService bitcoinService;

    @Autowired
    private ProduitManager produitManager;

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Bienvenue !");
        while(true){
            System.out.println("Vous souhaitez : ");
            System.out.println("1 - Connaître le cours du bitcoin");
            System.out.println("2 - Ajouter un produit au catalogue");
            System.out.println("3 - Voir tous les produits du catalogue");
            System.out.println("4 - Voir les détails d'un produit");
            System.out.println("5 - Initialiser le catalogue");
            System.out.println("0 - Quitter");

            Scanner scanner = new Scanner(System.in);
            int saisie = scanner.nextInt();
            switch (saisie){
                case 1:
                    System.out.println("1 BTC = " + bitcoinService.getBitcoinRate() + " €");
                    break;
                case 2:
                    produitManager.ajouterProduit();
                    break;
                case 3:
                    produitManager.afficherTousLesProduits();
                    break;
                case 4:
                    System.out.println("Quel numéro de produit ?");
                    produitManager.afficherDetailProduit(scanner.nextInt());
                    break;
                case 5:
                    produitManager.initialiserCatalogue();
                    break;
                case 0:
                    System.out.println("Au revoir !");
                    return;
            }
        }
    }
}
