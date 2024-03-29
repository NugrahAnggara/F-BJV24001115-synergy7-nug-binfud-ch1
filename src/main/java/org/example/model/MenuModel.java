package org.example.model;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Setter
@Getter
@AllArgsConstructor
@Accessors(chain = true)
public class MenuModel {
    private String name;
    private int price;

}
