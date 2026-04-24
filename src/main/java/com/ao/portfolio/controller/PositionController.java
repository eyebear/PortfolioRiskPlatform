package com.ao.portfolio.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.ao.portfolio.dto.PositionRequest;
import com.ao.portfolio.dto.PositionResponse;
import com.ao.portfolio.entity.Position;
import com.ao.portfolio.service.PositionService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/positions")
public class PositionController {

    private final PositionService positionService;

    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }

    @GetMapping
    public List<PositionResponse> getAll() {
        return positionService.getAllPositions();
    }

    @PostMapping
    public PositionResponse create(@Valid @RequestBody PositionRequest request) {
        return positionService.savePosition(request);
    }

    @PostMapping("/batch")
    public List<PositionResponse> createBatch(@RequestBody List<@Valid PositionRequest> requests) {
        return positionService.saveAll(requests);
    }

    @GetMapping("/{id}")
    public PositionResponse getById(@PathVariable Long id) {
        return positionService.getPositionById(id);
    }

    @GetMapping("/{id}/pnl/{price}")
    public double getPnLById(@PathVariable Long id, @PathVariable double price) {
        Position position = positionService.getEntityById(id);
        return positionService.calculatePnL(position, price);
    }
}