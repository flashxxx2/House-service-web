package it.park.houseserviceweb.service;

import it.park.houseserviceweb.comparator.HousesPriceAscComparator;
import it.park.houseserviceweb.comparator.HousesPriceDescComparator;
import it.park.houseserviceweb.domain.House;
import it.park.houseserviceweb.repository.HouseRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class HouseService {
    private final HouseRepository repository;

    public HouseService(HouseRepository repository) {
        this.repository = repository;
    }

    public void add(House house) {
        repository.add(house);
    }

    public List<House> getAll() {
        return repository.getAll();
    }

    public List<House> getSorted(Comparator<House> comparator) {
        List<House> result = repository.getAll();
        result.sort(comparator);
        return result;
    }

    public List<House> getFromPriceAsc(int min, int max) {
        List<House> result = repository.getHouseFromPrice(min, max);
        result.sort(new HousesPriceAscComparator());
        return result;
    }

    public List<House> getFromPriceDesc(int min, int max) {
        List<House> result = repository.getHouseFromPrice(min, max);
        result.sort(new HousesPriceDescComparator());
        return result;
    }

    public List<House> getHouseFromDistrict(List<String> districts) {
        return repository.getHouseFromDistrict(districts);
    }

    public void add(int id, int price, String district, int area, int rooms) {
        repository.add(new House(id,price,district,area,rooms));
    }
}
