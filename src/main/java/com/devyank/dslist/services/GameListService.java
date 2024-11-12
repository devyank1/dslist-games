package com.devyank.dslist.services;

import com.devyank.dslist.dto.GameDTO;
import com.devyank.dslist.dto.GameListDTO;
import com.devyank.dslist.dto.GameMinDTO;
import com.devyank.dslist.entities.Game;
import com.devyank.dslist.entities.GameList;
import com.devyank.dslist.repositories.GameListRepository;
import com.devyank.dslist.repositories.GameRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameListService {

    private final GameListRepository gameListRepository;

    public GameListService(GameListRepository gameListRepository) {
        this.gameListRepository = gameListRepository;
    }

    @Transactional
    public List<GameListDTO> findAll() {
        List<GameList> result = gameListRepository.findAll();
        List<GameListDTO> dto = result.stream().map(game -> new GameListDTO(game)).toList();
        return dto;
    }

}
