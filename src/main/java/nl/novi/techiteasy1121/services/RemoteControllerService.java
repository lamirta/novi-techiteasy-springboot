package nl.novi.techiteasy1121.services;

import nl.novi.techiteasy1121.dtos.RemoteControllerDto;
import nl.novi.techiteasy1121.models.RemoteController;

import java.util.List;

public interface RemoteControllerService {
    public List<RemoteControllerDto> getAllRemoteControllers();

    public RemoteControllerDto getRemoteController(long id);

    public RemoteControllerDto addRemoteController(RemoteControllerDto remoteController);

    public void deleteRemoteController(Long id);

    public void updateRemoteController(Long id, RemoteControllerDto remoteController);

}
