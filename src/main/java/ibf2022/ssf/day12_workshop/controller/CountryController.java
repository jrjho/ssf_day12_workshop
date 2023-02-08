package ibf2022.ssf.day12_workshop.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ibf2022.ssf.day12_workshop.model.Country;
import ibf2022.ssf.day12_workshop.service.CountryService;

@Controller
@RequestMapping(path = { "/countries" })
public class CountryController {

    CountryService ctySvc;

    public CountryController() {
        ctySvc = new CountryService();
    }

    //http://localhost:3000/countries
    @GetMapping()
    // @GetMapping(produces = {"application/xml"})
    public @ResponseBody List<Country> getAllCountries() {
        return ctySvc.getAllCountries();
    }

    //http://localhost:3000/countries
    @PostMapping()
    public @ResponseBody Boolean createCountry(@RequestBody Country country) {
       return ctySvc.createCountry(country);
    }

    //http://localhost:3000/countries/list
    // @GetMapping("/list")
    @RequestMapping(path = "/list", method = RequestMethod.GET)

    public String displayCountryList(Model model){
        List<Country> ctyList = ctySvc.getAllCountries();
        model.addAttribute("countriesList", ctyList);

        return "countryList";

    }
}
