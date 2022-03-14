package nl.novi.techiteasy1121.services;

import nl.novi.techiteasy1121.dtos.TelevisionDto;

import java.util.List;

public interface TelevisionService {
    List<TelevisionDto> getAllTelevisions();
    TelevisionDto getTelevisionById(Long id);
    TelevisionDto addTelevision(TelevisionDto dto);
    void deleteTelevision(Long id);
    TelevisionDto updateTelevision(Long id, TelevisionDto dto);
    void assignRemoteControllerToTelevision(Long id, Long remoteControllerId);
    void assignCIModuleToTelevision(Long id, Long ciModuleId);
}
