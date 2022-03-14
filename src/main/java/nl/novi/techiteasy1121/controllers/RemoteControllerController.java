package nl.novi.techiteasy1121.controllers;

import nl.novi.techiteasy1121.dtos.RemoteControllerDto;
import nl.novi.techiteasy1121.services.RemoteControllerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RemoteControllerController {
    private final RemoteControllerServiceImpl remoteControllerService;

    @Autowired
    public RemoteControllerController(RemoteControllerServiceImpl remoteControllerService) {
        this.remoteControllerService = remoteControllerService;
    }


    @GetMapping("/remotecontrollers")
    public List<RemoteControllerDto> getAllRemotecontrollers() {

        List<RemoteControllerDto> dtos = remoteControllerService.getAllRemoteControllers();

        return dtos;
    }

    @GetMapping("/remotecontrollers/{id}")
    public RemoteControllerDto getRemotecontroller(@PathVariable("id") Long id) {

        RemoteControllerDto dto = remoteControllerService.getRemoteController(id);

        return dto;
    }

    @PostMapping("/remotecontrollers")
    public RemoteControllerDto addRemoteController(@RequestBody RemoteControllerDto dto) {
        RemoteControllerDto dto1 = remoteControllerService.addRemoteController(dto);
        return dto1;
    }

    @DeleteMapping("/remotecontrollers/{id}")
    public void deleteRemoteController(@PathVariable("id") Long id) {
        remoteControllerService.deleteRemoteController(id);
    }

    @PutMapping("/remotecontrollers/{id}")
    public RemoteControllerDto updateTelevision(@PathVariable("id") Long id, @RequestBody RemoteControllerDto dto) {
       remoteControllerService.updateRemoteController(id, dto);
        return dto;
    }

}