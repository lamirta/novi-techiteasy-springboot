package nl.novi.techiteasy1121.services;

import nl.novi.techiteasy1121.dtos.TelevisionDto;
import nl.novi.techiteasy1121.exceptions.RecordNotFoundException;
import nl.novi.techiteasy1121.models.Television;
import nl.novi.techiteasy1121.repositories.TelevisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TelevisionServiceImpl implements TelevisionService{


    @Autowired
    private TelevisionRepository televisionRepository;

    @Override
    public List<TelevisionDto> getAllTelevisions() {
        List<Television> tvList = televisionRepository.findAll();
        List<TelevisionDto> tvDtoList = new ArrayList<>();

        for(Television tv : tvList) {
            TelevisionDto dto = new TelevisionDto();
            dto.setId(tv.getId());
            dto.setType(tv.getType());
            dto.setBrand(tv.getBrand());
            dto.setName(tv.getName());
            dto.setPrice(tv.getPrice());
            dto.setAvailableSize(tv.getAvailableSize());
            dto.setRefreshRate(tv.getRefreshRate());
            dto.setScreenType(tv.getScreenType());
            dto.setScreenQuality(tv.getScreenQuality());
            dto.setSmartTv(tv.getSmartTv());
            dto.setWifi(tv.getWifi());
            dto.setVoiceControl(tv.getVoiceControl());
            dto.setHdr(tv.getHdr());
            dto.setBluetooth(tv.getBluetooth());
            dto.setAmbiLight(tv.getAmbiLight());
            dto.setOriginalStock(tv.getOriginalStock());
            dto.setSold(tv.getSold());
            tvDtoList.add(dto);
        }
        return tvDtoList;
    }

    @Override
    public TelevisionDto getTelevisionById(Long id) {
        TelevisionDto dto = new TelevisionDto();
        if (televisionRepository.findById(id).isPresent()){
            Television tv = televisionRepository.findById(id).get();
            dto.setId(tv.getId());
            dto.setType(tv.getType());
            dto.setBrand(tv.getBrand());
            dto.setName(tv.getName());
            dto.setPrice(tv.getPrice());
            dto.setAvailableSize(tv.getAvailableSize());
            dto.setRefreshRate(tv.getRefreshRate());
            dto.setScreenType(tv.getScreenType());
            dto.setScreenQuality(tv.getScreenQuality());
            dto.setSmartTv(tv.getSmartTv());
            dto.setWifi(tv.getWifi());
            dto.setVoiceControl(tv.getVoiceControl());
            dto.setHdr(tv.getHdr());
            dto.setBluetooth(tv.getBluetooth());
            dto.setAmbiLight(tv.getAmbiLight());
            dto.setOriginalStock(tv.getOriginalStock());
            dto.setSold(tv.getSold());
            return dto;
        } else {
            throw new  RecordNotFoundException("geen televisie gevonden");
        }
    }

    @Override
    public Television addTelevision(TelevisionDto dto) {

        Television tv = new Television();
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

        return tv;
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

}
