package com.swaggyvitu.dslist.controllers;

import com.swaggyvitu.dslist.dto.GameDTO;
import com.swaggyvitu.dslist.dto.GameListDTO;
import com.swaggyvitu.dslist.dto.GameMinDTO;
import com.swaggyvitu.dslist.entities.Game;
import com.swaggyvitu.dslist.services.GameListService;
import com.swaggyvitu.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    public GameListController(GameListService gameListService) {
        this.gameListService = gameListService;
    }

    @GetMapping
    public List<GameListDTO> findAll(){
        List<GameListDTO> resultado = gameListService.findAll();
        return resultado;
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable Long listId){
        List<GameMinDTO> resultado = gameService.findByList(listId);
        return resultado;
    }


}
