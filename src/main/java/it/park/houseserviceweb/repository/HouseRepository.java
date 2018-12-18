package it.park.houseserviceweb.repository;

import it.park.houseserviceweb.domain.House;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class HouseRepository {
    private List<House> houses = new ArrayList<>();


    public void add(House house) {
        houses.add(house);
    }

    public List<House> getHouseFromPrice(int min, int max) {
        List<House> result = new ArrayList<>();
        for (House house : houses) {
            if (min < house.getPrice() && max > house.getPrice()) {
                result.add(house);
            }
        }
        return result;
    }

    public List<House> getHouseFromDistrict(List<String> districts) {
        List<House> result = new ArrayList<>();
        for (House house : houses) {
            if (districts.contains(house.getDistrict())) {
                result.add(house);
            }

        }
        return result;


    }

    public List<House> getAll() {
        return houses;
    }
}

