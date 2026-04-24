package com.ao.portfolio.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ao.portfolio.entity.Position;
import com.ao.portfolio.repository.PositionRepository;

public class PositionServiceTest {

    private PositionService positionService;

    @BeforeEach
    void setUp() {
        PositionRepository mockRepository = mock(PositionRepository.class);
        positionService = new PositionService(mockRepository);
    }

    @Test
    void calculatePnL_shouldReturnCorrectProfit() {
        Position position = new Position();
        position.setSymbol("AAPL");
        position.setQuantity(10);
        position.setAvgPrice(150);

        double result = positionService.calculatePnL(position, 160);

        assertEquals(100.0, result);
    }

    @Test
    void calculatePnL_shouldReturnCorrectLoss() {
        Position position = new Position();
        position.setSymbol("AAPL");
        position.setQuantity(10);
        position.setAvgPrice(150);

        double result = positionService.calculatePnL(position, 140);

        assertEquals(-100.0, result);
    }
}