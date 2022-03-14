package nl.novi.techiteasy1121.services;

import nl.novi.techiteasy1121.dtos.TelevisionDto;
import nl.novi.techiteasy1121.exceptions.RecordNotFoundException;
import nl.novi.techiteasy1121.models.Television;
import nl.novi.techiteasy1121.repositories.CIModuleRepository;
import nl.novi.techiteasy1121.repositories.RemoteControllerRepository;
import nl.novi.techiteasy1121.repositories.TelevisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TelevisionServiceImpl implements TelevisionService{

    @Autowired
    private TelevisionRepository televisionRepository;

    @Autowired
    private RemoteControllerRepository remoteControllerRepository;

    @Autowired
    private CIModuleRepository ciModuleRepository;

    @Override
    public List<TelevisionDto> getAllTelevisions() {
        List<Television> tvList = televisionRepository.findAll();
        List<TelevisionDto> tvDtoList = new ArrayList<>();

        for(Television tv : tvList) {
           TelevisionDto dto = transferToDto(tv);
            tvDtoList.add(dto);
        }
        return tvDtoList;
    }

    @Override
    public TelevisionDto getTelevisionById(Long id) {

        if (televisionRepository.findById(id).isPresent()){
            Television tv = televisionRepository.findById(id).get();
            TelevisionDto dto = transferToDto(tv);
            return dto;
        } else {
            throw new  RecordNotFoundException("geen televisie gevonden");
        }
    }

    @Override
    public TelevisionDto addTelevision(TelevisionDto dto) {

        Television tv = transferToTelevision(dto);
        televisionRepository.save(tv);

        return dto;
    }

    @Override
    public void deleteTelevision(Long id) {

        televisionRepository.deleteById(id);

    }

    @Override
    public TelevisionDto updateTelevision(Long id, TelevisionDto dto) {

        if (televisionRepository.findById(id).isPresent()){

            Television tv = televisionRepository.findById(id).get();

            tv.setId(tv.getId());

            tv.setType(dto.getType());

            tv.setBrand(dto.getBrand());

            tv.setName(dto.getName());

            tv.setPrice(dto.getPrice());

            tv.setAvailableSize(dto.getAvailableSize());

            tv.setRefreshRate(dto.getRefreshRate());

            tv.setScreenType(dto.getScreenType());

            tv.setScreenQuality(dto.getScreenQuality());

            tv.setSmartTv(dto.getSmartTv());

            tv.setWifi(dto.getWifi());

            tv.setVoiceControl(dto.getVoiceControl());

            tv.setHdr(dto.getHdr());

            tv.setBluetooth(dto.getBluetooth());

            tv.setAmbiLight(dto.getAmbiLight());

            tv.setOriginalStock(dto.getOriginalStock());

            tv.setSold(dto.getSold());

            televisionRepository.save(tv);

            return dto;

        } else {

            throw new  RecordNotFoundException("geen televisie gevonden");

        }

    }

    public Television transferToTelevision(TelevisionDto dto){
        var television = new Television();

        television.setId(dto.getId());
        television.setType(dto.getType());
        television.setBrand(dto.getBrand());
        television.setName(dto.getName());
        television.setPrice(dto.getPrice());
        television.setAvailableSize(dto.getAvailableSize());
        television.setRefreshRate(dto.getRefreshRate());
        television.setScreenType(dto.getScreenType());
        television.setScreenQuality(dto.getScreenQuality());
        television.setSmartTv(dto.getSmartTv());
        television.setWifi(dto.getWifi());
        television.setVoiceControl(dto.getVoiceControl());
        television.setHdr(dto.getHdr());
        television.setBluetooth(dto.getBluetooth());
        television.setAmbiLight(dto.getAmbiLight());
        television.setOriginalStock(dto.getOriginalStock());
        television.setSold(dto.getSold());

        return television;
    }

    public TelevisionDto transferToDto(Television television){
        var dto = new TelevisionDto();

        dto.setId(television.getId());
        dto.setType(television.getType());
        dto.setBrand(television.getBrand());
        dto.setName(television.getName());
        dto.setPrice(television.getPrice());
        dto.setAvailableSize(television.getAvailableSize());
        dto.setRefreshRate(television.getRefreshRate());
        dto.setScreenType(television.getScreenType());
        dto.setScreenQuality(television.getScreenQuality());
        dto.setSmartTv(television.getWifi());
        dto.setWifi(television.getWifi());
        dto.setVoiceControl(television.getVoiceControl());
        dto.setHdr(television.getHdr());
        dto.setBluetooth(television.getBluetooth());
        dto.setAmbiLight(television.getAmbiLight());
        dto.setOriginalStock(television.getOriginalStock());
        dto.setSold(television.getSold());

        return dto;
    }

    public void assignRemoteControllerToTelevision(Long id, Long remoteControllerId) {
        var optionalTelevision = televisionRepository.findById(id);
        var optionalRemoteController = remoteControllerRepository.findById(remoteControllerId);

        if(optionalTelevision.isPresent() && optionalRemoteController.isPresent()) {
            var television = optionalTelevision.get();
            var remoteController = optionalRemoteController.get();

            television.setRemoteController(remoteController);
            televisionRepository.save(television);
        } else {
            throw new RecordNotFoundException();
        }
    }

    public void assignCIModuleToTelevision(Long id, Long ciModuleId) {
        var optionalTelevision = televisionRepository.findById(id);
        var optionalCIModule = ciModuleRepository.findById(ciModuleId);

        if(optionalTelevision.isPresent() && optionalCIModule.isPresent()) {
            var television = optionalTelevision.get();
            var ciModule = optionalCIModule.get();

            television.setCiModule(ciModule);
            televisionRepository.save(television);
        } else {
            throw new RecordNotFoundException();
        }
    }
}
