package nl.novi.techiteasy1121.controllers;


import nl.novi.techiteasy1121.dtos.IdInputDto;
import nl.novi.techiteasy1121.dtos.TelevisionDto;
import nl.novi.techiteasy1121.dtos.WallBracketDto;
import nl.novi.techiteasy1121.models.WallBracket;
import nl.novi.techiteasy1121.services.TelevisionService;
import nl.novi.techiteasy1121.services.TelevisionWallBracketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

@RestController
public class TelevisionController {

    @Autowired
    TelevisionService televisionService;

    @Autowired
    TelevisionWallBracketService televisionWallBracketService;

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
    public TelevisionDto addTelevision(@Valid @RequestBody TelevisionDto televisionDto) {

        TelevisionDto dto = televisionService.addTelevision(televisionDto);

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


    @PutMapping("/televisions/{id}/remotecontroller")
    public void assignRemoteControllerToTelevision(@PathVariable("id") Long id, @RequestBody IdInputDto input) {
        televisionService.assignRemoteControllerToTelevision(id, input.id);
    }

    @PutMapping("/televisions/{id}/{ciModuleId}")
    public void assignCIModuleToTelevision(@PathVariable("id") Long id, @PathVariable("ciModuleId") Long ciModuleId) {
        televisionService.assignCIModuleToTelevision(id, ciModuleId);
    }

    @GetMapping("/televisions/wallBrackets/{televisionId}")
    public Collection<WallBracketDto> getWallBracketsByTelevisionId(@PathVariable("televisionId") Long televisionId){
        return televisionWallBracketService.getTelevisionWallBracketByTelevisionId(televisionId);
    }
}
