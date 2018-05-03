package com.ese.demo;


import com.ese.demo.Marvels.Marvel;
import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class FormController {

    private String URL_UPPER = "http://gateway.marvel.com/v1/public/characters?name=";
    private String URL_LOWER = "&orderBy=name&ts=1&apikey=b6168abc18f41d92a4032fd954126073&hash=2d26ade77e6a23a22efa12c748635dca";
    private UserSearch finalInput;
    private Marvel marvelChar;

//   @RequestMapping(value = "/index.html", method = RequestMethod.GET)
//    public ModelAndView getIndex(){
//
//        ModelAndView model = new ModelAndView("Index");
//
//        return model;
//    }

    /**
     * @RequestMapping(value = "/submitSearch.html", method = RequestMethod.POST)
     * public ModelAndView submitSearch(@RequestParam("characterName") String name){
     * <p>
     * ModelAndView model = new ModelAndView("Search");
     * model.addObject("msg", "Searched for: " + name);
     * <p>
     * return model;
     * <p>
     * }
     **/

    @RequestMapping("/home")
    public ModelAndView addSearch() {
        return new ModelAndView("index.html", "search", new UserSearch());
    }


    @RequestMapping(value = "/addSearch", method = RequestMethod.POST)
    public RedirectView addNewSearch(UserSearch userSearch) {

        finalInput = userSearch;

        String selectView = verifySearch(userSearch.getSearchTerm());

        return new RedirectView(selectView);
    }


    @RequestMapping("/search")
    public ModelAndView search(ModelMap modelMap) {

        String charName = marvelChar.getData().getResults().get(0).getName();
        String charDiscription = marvelChar.getData().getResults().get(0).getDescription();
        String charImage = marvelChar.getData().getResults().get(0).getThumbnail().getPath() + "/detail.jpg";

        MarvelCharacter marvin = new MarvelCharacter(charName, charDiscription, charImage);

        modelMap.addAttribute("userEnteredSearch", marvin);
        return new ModelAndView("search.html", modelMap);
    }


    @RequestMapping("/fail")
    public String fail(Model model){
        return "fail.html";
    }




    private String verifySearch(String userSearch) {

        if (userSearch.equals("") || userSearch.equals(" ")){return "/fail";}

        else {

            marvelChar = findChar(userSearch);

            if (marvelChar.getData().getResults().size() == 0){return "/fail";}
            else {return "/search";}

        }
    }



    private Marvel findChar(String userSearch) {

        if (userSearch.contains(" ")){ userSearch = userSearch.replace(" ", "%20");}

        String url = URL_UPPER + userSearch + URL_LOWER;

        Marvel marvelResult = accessMarvel(url);

        return marvelResult;
    }



    private Marvel accessMarvel(String url) {

        try{
            HttpResponse<JsonNode> response = Unirest.get(url).asJson();

            Gson gson = new Gson();

            Marvel searchResults = gson.fromJson(response.getBody().toString(), Marvel.class);

            return searchResults;


        }catch (Exception j){return new Marvel();}
    }

}