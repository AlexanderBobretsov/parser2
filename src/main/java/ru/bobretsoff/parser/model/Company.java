package ru.bobretsoff.parser.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/** указание класса сущностей. */
@Entity
@Data
public class Company implements Serializable {

    /**  автогенерация id. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**  ticker. */
    private String ticker;
    /**  company. */
    private String company;
    /**  sector. */
    private String sector;
    /**  industry. */
    private String industry;
    /**  price. */
    private String price;

}
