package nl.novi.techiteasy1121.services;

import nl.novi.techiteasy1121.dtos.WallBracketDto;
import nl.novi.techiteasy1121.models.WallBracket;

import java.util.List;
import java.util.Optional;

public interface WallBracketService {
     List<WallBracketDto> getAllWallBrackets();

     WallBracketDto getWallBracket(long id);

     WallBracketDto addWallbracket(WallBracketDto wallBracketDto);

     void deleteWallBracket(Long id);

     void updateWallBracket(Long id, WallBracketDto wallBracketDto) ;
}
