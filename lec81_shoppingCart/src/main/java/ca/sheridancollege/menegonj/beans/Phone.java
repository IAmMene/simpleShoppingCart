package ca.sheridancollege.menegonj.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Phone {
    private Long id;
    private String model;
    private double price;
}
