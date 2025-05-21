package com.swaggyvitu.dslist.services;

import com.swaggyvitu.dslist.dto.GameListDTO;
import com.swaggyvitu.dslist.entities.GameList;
import com.swaggyvitu.dslist.repository.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    private GameListRepository gameListRepository;

    public GameListService(GameListRepository gameListRepository) {
        this.gameListRepository = gameListRepository;
    }

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> resultado = gameListRepository.findAll();
        return resultado.stream().map(x -> new GameListDTO(x)).toList();
    }




}
