package com.kaanata.services.IMPL;

import com.kaanata.entites.GameInformation;
import com.kaanata.repository.IGameInforRepository;
import com.kaanata.services.IGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class GameInforServicesIMPL implements IGameService {

    @Autowired
    private IGameInforRepository gameInforRepository;

    //Yeni kayıt ekleme Servis Katmanı Method Tanımlanması
    @Override
    public GameInformation saveGameInformation(GameInformation gameInformation) {

        return gameInforRepository.save(gameInformation);

    }

    //Bütün kayıtları Listeleme Servis Katmanı Method Tanımlanması
    @Override
    public List<GameInformation> getAllGameInformation() {
        List<GameInformation>gameInformationList  = gameInforRepository.findAll();

        return gameInformationList;
    }

    //Game Name e göre oyunları arama servis katmanı Method tanımlanması
    @Override
    public List<GameInformation> getGameInformationBygameName(String gameName) {
        return gameInforRepository.findByGameNameContainingIgnoreCase(gameName);

    }

    //ID e göre oyunları silme servis katmanı Method Tanımlamaları
    @Override
    public void deleteGameInformation(Integer id) {
        boolean exists = gameInforRepository.existsById(id);
        if (exists) {
            gameInforRepository.deleteById(id);

        }
        else{
            System.out.println("Game information Not Found");
        }

    }


    //ID ye göre oyunları update etme servis katmanı Methodlarının tanımlamaları
    @Override
    public GameInformation updateGameInformation(Integer id, GameInformation updategameInformation) {
        boolean exists = gameInforRepository.existsById(id);
        if (exists) {
            GameInformation dbgameInformation = gameInforRepository.findById(id).get(); //Mevcut veriyi veritabanından çekiyoruz
            dbgameInformation.setGameName(updategameInformation.getGameName()); //Kullanıcıdan gelen (updategameInformation) yeni bilgileri db nesnesine set ediyoruz
            dbgameInformation.setLaunchYear(updategameInformation.getLaunchYear());
            return gameInforRepository.save(dbgameInformation); //Güncellenmiş olan nesneyi tekrar kaydediliyor (HiberNate bunu "update" olarak tanımlar
        }
        else
        {
            System.out.println("Game information Not Found");
            return null;
        }
    }
}
