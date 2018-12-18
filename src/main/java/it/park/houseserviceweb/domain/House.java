package it.park.houseserviceweb.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class House {
    private int id;
    private int price;
    private String district;
    private int area;
    private int rooms;

}
