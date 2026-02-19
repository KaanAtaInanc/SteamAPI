package com.kaanata.controller;


import com.kaanata.entites.GameInformation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//CONTROLLER INTERFACE KATMANI

public interface IGameController {


    //Yeni Oyun Kaydı Ekleme Method
    public GameInformation saveGameInformation(GameInformation gameInformation);

    //Tüm Oyunları Listeleme Method
    public List<GameInformation> getAllGameInformation();

    //Oyun İsmine Göre Arama Method
    public List<GameInformation> getGameInformationBygameName(@PathVariable(name = "gameName") String gameName);

    //ID'ye Göre Oyun Silme İşlemi
    public void deleteGameInformation(Integer id);

    //ID YE GÖRE OYUN GÜNCELLEME İŞLEMİ
    public GameInformation updateGameInformation(Integer id, GameInformation updategameInformation);



}
