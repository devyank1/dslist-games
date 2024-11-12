package com.devyank.dslist.controllers;

import com.devyank.dslist.dto.GameDTO;
import com.devyank.dslist.dto.GameListDTO;
import com.devyank.dslist.dto.GameMinDTO;
import com.devyank.dslist.services.GameListService;
import com.devyank.dslist.services.GameService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/lists")
public class GameListController {

    private final GameListService gameListService;

    public GameListController(GameListService gameListService) {
        this.gameListService = gameListService;
    }

    @GetMapping
    public List<GameListDTO> findAll() {
        List<GameListDTO> result = gameListService.findAll();
        return result;
    }

}
