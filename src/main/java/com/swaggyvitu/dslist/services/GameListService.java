package com.swaggyvitu.dslist.services;

import com.swaggyvitu.dslist.dto.GameListDTO;
import com.swaggyvitu.dslist.dto.GameMinDTO;
import com.swaggyvitu.dslist.entities.GameList;
import com.swaggyvitu.dslist.projection.GameMinProjection;
import com.swaggyvitu.dslist.repository.GameListRepository;
import com.swaggyvitu.dslist.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    private GameListRepository gameListRepository;

    private GameRepository gameRepository;

    public GameListService(GameRepository gameRepository, GameListRepository gameListRepository) {
        this.gameRepository = gameRepository;
        this.gameListRepository = gameListRepository;
    }

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> resultado = gameListRepository.findAll();
        return resultado.stream().map(x -> new GameListDTO(x)).toList();
    }

    public void move(Long listId, int sourceIndex, int destinationIndex){
        List<GameMinProjection> list = gameRepository.searchByList(listId);

        GameMinProjection obj = list.remove(sourceIndex);

        list.add(destinationIndex, obj);

        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;

        int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

        for (int i = min; i <= max; i++){
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }

    }




}
