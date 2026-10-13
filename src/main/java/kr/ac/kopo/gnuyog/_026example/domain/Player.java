package kr.ac.kopo.gnuyog._026example.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Player
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;
}
