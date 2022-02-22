package nl.novi.techiteasy1121.controllers;


import nl.novi.techiteasy1121.dtos.TelevisionDto;
import nl.novi.techiteasy1121.models.Television;
import nl.novi.techiteasy1121.services.TelevisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class TelevisionController {

    @Autowired
    TelevisionService televisionService;

    @GetMapping("/televisions")
    public List<TelevisionDto> getAllTelevisions() {

        List<TelevisionDto> dtos = televisionService.getAllTelevisions();

        return dtos;

    }

    @GetMapping("/televisions/{id}")
    public ResponseEntity<TelevisionDto> getTelevision(@PathVariable("id") Long id) {

        TelevisionDto dto = televisionService.getTelevisionById(id);

        return ResponseEntity.ok(dto);

    }

    @PostMapping("/televisions")
    public Television addTelevision(@Valid @RequestBody TelevisionDto televisionDto) {

        var dto = televisionService.addTelevision(televisionDto);

        return dto;

    }

    @DeleteMapping("/televisions/{id}")
    public void deleteTelevision(@PathVariable("id") Long id) {

        televisionService.deleteTelevision(id);

    }

    @PutMapping("televisions/{id}")
    public TelevisionDto updateTelevision(@PathVariable("id") Long id, @RequestBody TelevisionDto television) {

        TelevisionDto dto = televisionService.updateTelevision(id, television);

        return dto;

    }
}