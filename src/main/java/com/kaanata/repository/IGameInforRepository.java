package com.kaanata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.kaanata.entites.GameInformation;

import java.util.List;

@Repository
public interface IGameInforRepository extends JpaRepository<GameInformation,Integer> {


    List<GameInformation> getGameInformationBygameName (String gameName);


    //List<GameInformation> findAllBygameName(String gameName); //Name Arama  !!

    List<GameInformation> findByGameNameContainingIgnoreCase(String gameName); //AI KATMANI NAME ARAMA !!




}
