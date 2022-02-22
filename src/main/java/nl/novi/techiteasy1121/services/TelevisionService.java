package nl.novi.techiteasy1121.services;

import nl.novi.techiteasy1121.dtos.TelevisionDto;
import nl.novi.techiteasy1121.models.Television;

import java.util.List;

public interface TelevisionService {
    List<TelevisionDto> getAllTelevisions();
    TelevisionDto getTelevisionById(Long id);
    Television addTelevision(TelevisionDto dto);
    void deleteTelevision(Long id);
    TelevisionDto updateTelevision(Long id, TelevisionDto dto);
}
