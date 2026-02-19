package com.kaanata.controller.impl;

import com.kaanata.controller.IGameController;
import com.kaanata.entites.GameInformation;
import com.kaanata.services.IGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api/game")
public class GameInforControllerIMPL implements IGameController {

    //gameService nesnelerin otoamtik olarak servis katmanından aktarılması
    @Autowired
    private IGameService gameService;

    //Save (kayt ekleme) methodun yazılması
    @PostMapping(path = "/save") //URL Adresini belirleme
    @Override //Özel kuralların yazılması
    public GameInformation saveGameInformation(@RequestBody GameInformation gameInformation)
    {
        return gameService.saveGameInformation(gameInformation);

    }

    //List (listeleme) methodun yazılması (tüm oyunların listelenmesi)
    @GetMapping(path = "/list")
    @Override
    public List<GameInformation> getAllGameInformation() {
        return gameService.getAllGameInformation();

    }
    //Oyun adına göre arama method yazılması
    @GetMapping(path = "/search/{gameName}")
    @Override
    public List<GameInformation> getGameInformationBygameName(@PathVariable(name = "gameName") String gameName) {

        return gameService.getGameInformationBygameName(gameName);
        //return null;
    }

    //ID ye göre delete işlemi
    @DeleteMapping(path = "/delete/{id}")
    @Override
    public void deleteGameInformation(@PathVariable(name = "id") Integer id) {
        //Delete işlem yapısı gereği geriye deper dönmez bu sebepten "void" kullanılır ve herhangi bir return kodu yazılmaz
        gameService.deleteGameInformation(id);

    }

    //Update İşleminin Tanımlanması
    @PutMapping(path = "/update/{id}")
    @Override
    public GameInformation updateGameInformation(@PathVariable(name = "id") Integer id,@RequestBody GameInformation updategameInformation)
    {
        return gameService.updateGameInformation(id, updategameInformation);

    }



}
