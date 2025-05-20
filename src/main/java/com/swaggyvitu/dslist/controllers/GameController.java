package com.swaggyvitu.dslist.controllers;

import com.swaggyvitu.dslist.dto.GameMinDTO;
import com.swaggyvitu.dslist.services.GameService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    private GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }


    @GetMapping
    public List<GameMinDTO> findAll(){
        List<GameMinDTO> resultado = gameService.findAll();
        return resultado;
    }

}
