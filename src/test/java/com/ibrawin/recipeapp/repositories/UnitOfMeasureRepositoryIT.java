package com.ibrawin.recipeapp.repositories;

import com.ibrawin.recipeapp.domain.UnitOfMeasure;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;
import java.util.stream.StreamSupport;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class UnitOfMeasureRepositoryIT {

    @Autowired
    private UnitOfMeasureRepository unitOfMeasureRepository;

    @Test
    void findByDescriptionTeaspoon() {
        Optional<UnitOfMeasure> teaspoon = unitOfMeasureRepository.findByDescription("Teaspoon");
        assertEquals("Teaspoon", teaspoon.orElseThrow(() -> new RuntimeException("Expected UOM not found")).getDescription());
    }

    @Test
    void findByDescriptionCup() {
        Optional<UnitOfMeasure> cup = unitOfMeasureRepository.findByDescription("Cup");
        assertEquals("Cup", cup.orElseThrow(() -> new RuntimeException("Expected UOM not found")).getDescription());
    }

    @Test
    void findByDescriptionException() {
        Optional<UnitOfMeasure> abc = unitOfMeasureRepository.findByDescription("Abc");
        assertThrows(RuntimeException.class, () -> abc.orElseThrow(() -> new RuntimeException("Expected UOM not found")));
    }

    @Test
    void findAllUom() {
        Iterable<UnitOfMeasure> uom = unitOfMeasureRepository.findAll();

        assertEquals(8, StreamSupport.stream(uom.spliterator(), false).count());
    }
}