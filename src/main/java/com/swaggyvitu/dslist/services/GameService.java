package com.swaggyvitu.dslist.services;

import com.swaggyvitu.dslist.dto.GameDTO;
import com.swaggyvitu.dslist.dto.GameMinDTO;
import com.swaggyvitu.dslist.entities.Game;
import com.swaggyvitu.dslist.repository.GameRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    private GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll(){
        List<Game> resultado = gameRepository.findAll();
        return resultado.stream().map(x -> new GameMinDTO(x)).toList();
    }

    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {
        Game result = gameRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Game not found"));
        return new GameDTO(result);
    }


}
