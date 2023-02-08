package ibf2022.ssf.day12_workshop.repository;

import java.util.ArrayList;
import java.util.List;

import ibf2022.ssf.day12_workshop.model.Country;

public class CountryRepo {

    List<Country> countryList;

    public List<Country> getAllCountries() {

        countryList = new ArrayList<Country>();
        Country country = new Country("SG", "Singapore", 6000000);
        countryList.add(country);
        country = new Country("MY", "Malaysia", 33000000);
        countryList.add(country);
        country = new Country("CN", "China", 1460000000);
        countryList.add(country);

        return countryList;
    }

    public Boolean createCountry(Country country) {

        if (countryList == null)
            countryList = new ArrayList<Country>();

        countryList.add(country);
        return true;
    }

}
