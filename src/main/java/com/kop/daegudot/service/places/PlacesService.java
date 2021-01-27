package com.kop.daegudot.service.places;


import com.kop.daegudot.domain.places.Places;
import com.kop.daegudot.domain.places.PlacesRepository;
import com.kop.daegudot.web.dto.PlacesDto;
import com.kop.daegudot.web.dto.PlacesResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;

@RequiredArgsConstructor
@Service
public class PlacesService {
    private final PlacesRepository mPlacesRepository;
    
    @Transactional
    public void saveAll(ArrayList<PlacesDto> dtoArrayList) {
        ArrayList<Places> placesArrayList = new ArrayList<>();

        for (PlacesDto placesDto : dtoArrayList) { placesArrayList.add(placesDto.toEntity()); }   //Allocate dto to entity
        mPlacesRepository.saveAll(placesArrayList);
    }

    public ArrayList<PlacesResponseDto> findAll(){
        ArrayList<Places> placesArrayList;
        ArrayList<PlacesResponseDto> placesResponseDtoArrayList = new ArrayList<>();

        placesArrayList = mPlacesRepository.findAll();
        for(int i=0; i<placesArrayList.size();i++){
            PlacesResponseDto placesResponseDto = new PlacesResponseDto(placesArrayList.get(i));
            placesResponseDtoArrayList.add(placesResponseDto);
        }
        return placesResponseDtoArrayList;
    }
}
