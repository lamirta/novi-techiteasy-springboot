package nl.novi.techiteasy1121.services;

import nl.novi.techiteasy1121.dtos.TelevisionDto;
import nl.novi.techiteasy1121.dtos.WallBracketDto;
import nl.novi.techiteasy1121.models.Television;
import nl.novi.techiteasy1121.models.TelevisionWallBracketKey;
import nl.novi.techiteasy1121.models.WallBracket;

import java.util.Collection;

public interface TelevisionWallBracketService {
    Collection<TelevisionDto> getTelevisionWallBracketsByWallBracketId(Long wallBracketId);

    Collection<WallBracketDto> getTelevisionWallBracketByTelevisionId(Long televisionId);

    TelevisionWallBracketKey addTelevisionWallBracket(Long televisionId, Long wallBracketId);
}
