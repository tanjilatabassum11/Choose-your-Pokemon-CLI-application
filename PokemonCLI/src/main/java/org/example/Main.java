package org.example;

import org.example.models.Pokemon;
import org.example.models.PokemonDetail;
import org.example.services.PokemonService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    //they belong to this class
   private static PokemonService service = new PokemonService();
   private static Scanner input = new Scanner(System.in);

   //main method
   public static void main(String[] args) {
       List<Pokemon> pokemon = new ArrayList<>();

       do {
           System.out.println("Let's catch some Pokemon!");
           System.out.println("1. get first group of 20");
           System.out.println("2. get second group of 20");
           System.out.println("3. get third group of 20");
           System.out.println("4. quit");
           System.out.print("Enter choice: ");

           int choice = Integer.parseInt(input.nextLine());
           if (choice == 4) {
               break;
           }
           switch (choice) {
               case 1: //(if choice == 1)
                 pokemon = service.getMorePokemon(0);
  //             System.out.println(pokemon);
                   break;
               case 2:
                   pokemon = service.getMorePokemon(20);
   //              System.out.println(pokemon);
                   break;
               case 3:
                   pokemon = service.getMorePokemon(40);
     //            System.out.println(pokemon);
                   break;
           }

           getPokemonDetail(pokemon);
       }while (true);
   }

    public static void getPokemonDetail(List<Pokemon> pokemons) {
        System.out.println("choose pokemon: ");
        for (Pokemon p: pokemons){
            System.out.println(p.getId() + " " + p.getName());
        }
        System.out.println("Enter choice: ");
        int id = Integer.parseInt(input.nextLine());
        PokemonDetail detail = service.getPokemonDetailById(id);
        System.out.println(detail);
    }
}