package com.swaggyvitu.dslist.controllers;

import com.swaggyvitu.dslist.dto.GameDTO;
import com.swaggyvitu.dslist.dto.GameListDTO;
import com.swaggyvitu.dslist.dto.GameMinDTO;
import com.swaggyvitu.dslist.services.GameListService;
import com.swaggyvitu.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    private GameListService gameListService;

    public GameListController(GameListService gameListService) {
        this.gameListService = gameListService;
    }

    @GetMapping
    public List<GameListDTO> findAll(){
        List<GameListDTO> resultado = gameListService.findAll();
        return resultado;
    }



}
