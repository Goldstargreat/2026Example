package kr.ac.kopo.gnuyog._026example.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Product2
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer price;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "detail_id")
    private Detail detail;
}

