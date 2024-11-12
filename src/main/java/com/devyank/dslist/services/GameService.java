package com.devyank.dslist.services;

import com.devyank.dslist.dto.GameDTO;
import com.devyank.dslist.dto.GameMinDTO;
import com.devyank.dslist.entities.Game;
import com.devyank.dslist.projections.GameMinProjection;
import com.devyank.dslist.repositories.GameRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Transactional
    public List<GameMinDTO> findAll() {
        List<Game> result = gameRepository.findAll();
        List<GameMinDTO> dto = result.stream().map(game -> new GameMinDTO(game)).toList();
        return dto;
    }

    @Transactional
    public GameDTO findById(Long id) {
        Game result = gameRepository.findById(id).get();
        GameDTO dto = new GameDTO(result);
        return dto;
    }

    @Transactional
    public List<GameMinDTO> findByList(Long listId) {
        List<GameMinProjection> result = gameRepository.searchByList(listId);
        return result.stream().map(game -> new GameMinDTO(game)).toList();
    }
}
