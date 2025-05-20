package com.swaggyvitu.dslist.services;

import com.swaggyvitu.dslist.dto.GameMinDTO;
import com.swaggyvitu.dslist.entities.Game;
import com.swaggyvitu.dslist.repository.GameRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    private GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<GameMinDTO> findAll(){
        List<Game> resultado = gameRepository.findAll();
        return resultado.stream().map(x -> new GameMinDTO(x)).toList();
    }


}
