package com.kaanata.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "Game_Information",schema = "steam")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameInformation {
    @Id

    @Column(name="ID",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "game_Name",nullable = false,length = 60) //length verinin maksimum karakerini belirtir
    private String gameName;

    @Column(name = "launch_Year",nullable = false)
    private Integer launchYear;

}
