package nl.novi.techiteasy1121.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TelevisionController {

    @GetMapping("/televisions")
    public ResponseEntity<Object> getAllTelevisions() {

        return ResponseEntity.ok();

    }

    @GetMapping("/televisions/{id}")
    public ResponseEntity<Object> getTelevision(@PathVariable("id") Long id) {

        return ResponseEntity.ok();

    }

    @PostMapping("/televisions")
    public ResponseEntity<Object> addTelevision(@RequestBody String television) {

        return ResponseEntity.created();

    }

    @DeleteMapping("/televisions/{id}")
    public ResponseEntity<Object> deleteTelevision(@PathVariable("id") Long id) {

        return ResponseEntity.noContent();

    }

    @PutMapping("televisions/{id}")
    public ResponseEntity<Object> updateTelevision(@PathVariable("id") Long id, @RequestBody String television) {

        return ResponseEntity.noContent();

    }
}