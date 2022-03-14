package nl.novi.techiteasy1121.services;

import nl.novi.techiteasy1121.dtos.CIModuleDto;
import nl.novi.techiteasy1121.exceptions.RecordNotFoundException;
import nl.novi.techiteasy1121.models.CIModule;

import java.util.List;
import java.util.Optional;

public interface CIModuleService {

    public List<CIModuleDto> getAllCIModules();

    public CIModuleDto getCIModule(long id);

    public CIModuleDto addCIModule(CIModuleDto ciModuleDto);

    public void deleteCIModule(Long id);

    public void updateCIModule(Long id, CIModuleDto ciModuleDto);

}
