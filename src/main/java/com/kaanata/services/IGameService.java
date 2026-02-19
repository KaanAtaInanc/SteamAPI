package com.kaanata.services;

import java.util.List;

import com.kaanata.entites.GameInformation;

public interface IGameService {

    public GameInformation saveGameInformation(GameInformation gameInformation);


    public List<GameInformation> getAllGameInformation();

    public List<GameInformation> getGameInformationBygameName (String gameName);

    //Hypernet geriye değer döndürmediğinden void yazılır (Delete İşlemlerinde Yapısı Gereği Geriye Değer Döndürmemektedir)
    public void deleteGameInformation(Integer id);

    public GameInformation updateGameInformation(Integer id, GameInformation updategameInformation);





}
