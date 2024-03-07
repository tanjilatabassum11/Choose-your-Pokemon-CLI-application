package org.example.services;

import jdk.dynalink.linker.LinkerServices;
import org.example.models.Pokemon;
import org.example.models.PokemonDetail;
import org.example.models.Results;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.ls.LSInput;

import java.util.List;

//We need resttemplate object to connect to the pokemon API and this will be the client
public class PokemonService {
    private RestTemplate restTemplate = new RestTemplate();
    private final String API_URL = "https://pokeapi.co/api/v2/pokemon";

    //it will return first 20 methods
    public List<Pokemon> getPokemon(){
        Results rs = restTemplate.getForObject(API_URL, Results.class);
        return rs.getResults();
    }

//the method is created to return 20 pokemon or 40 pokemon
    public List<Pokemon> getMorePokemon(int startVal){
        //"https://pokeapi.co/api/v2/pokemon?offset=20&limit=20",
        Results rs = restTemplate.getForObject( API_URL + "?offset=" + startVal + "&limit=20", Results.class);
        List<Pokemon> list = rs.getResults();

        for (Pokemon item : list){ // for each loop
            String url = item.getUrl(); //get the url so we can pull the index
            int pokemonIndex = url.indexOf("pokemon"); // get the index of pokemon
            String pokemonString = url.substring(pokemonIndex);
            int slashIndex = pokemonString.indexOf("/");
            String number = pokemonString.substring(slashIndex + 1,
                    pokemonString.length() - 1); // strips off the / number /
            int id = Integer.parseInt(number); // get the id
            item.setId(id);
        }
        return list;
    }

    public PokemonDetail getPokemonDetailById(int id){
        PokemonDetail pokemonDetail = restTemplate.getForObject(API_URL + "/" + id, PokemonDetail.class);
        return  pokemonDetail;
    }

}
