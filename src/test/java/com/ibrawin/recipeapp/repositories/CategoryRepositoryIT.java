package com.ibrawin.recipeapp.repositories;

import com.ibrawin.recipeapp.domain.Category;
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
class CategoryRepositoryIT {

    @Autowired
    CategoryRepository categoryRepository;


    @Test
    void findByNameAmerican() {
        Optional<Category> american = categoryRepository.findByName("American");
        assertEquals("American", american.orElseThrow(() -> new RuntimeException("Expected UOM not found")).getName());
    }

    @Test
    void findByNameMexican() {
        Optional<Category> mexican = categoryRepository.findByName("Mexican");
        assertEquals("Mexican", mexican.orElseThrow(() -> new RuntimeException("Expected UOM not found")).getName());
    }

    @Test
    void findByDescriptionException() {
        Optional<Category> nigerian = categoryRepository.findByName("Nigerian");
        assertThrows(RuntimeException.class, () -> nigerian.orElseThrow(() -> new RuntimeException("Expected UOM not found")));
    }

    @Test
    void findAllUom() {
        Iterable<Category> categories = categoryRepository.findAll();

        assertEquals(4, StreamSupport.stream(categories.spliterator(), false).count());
    }
}