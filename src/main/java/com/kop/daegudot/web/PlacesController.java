package com.kop.daegudot.web;


import com.kop.daegudot.service.places.PlacesService;
import com.kop.daegudot.web.dto.PlacesDto;
import com.kop.daegudot.web.dto.PlacesLocationDto;
import com.kop.daegudot.web.dto.PlacesResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
public class PlacesController {
    private final PlacesService mPlacesService;

    /* method: GET
    SQL: INSERT */
    @GetMapping("/places")
    public void saveAll(){
        ArrayList<PlacesDto> mPlacesDtoArrayList = new ArrayList<>();
        mPlacesDtoArrayList = new PlacesConnection().opendatasHttp();   //Allocate result of XML parsing to new array list
        mPlacesService.saveAll(mPlacesDtoArrayList);
    }

    @GetMapping("/places/list")
    public ArrayList<PlacesResponseDto> findAll(){
        return mPlacesService.findAll();
    }

    //좌표 추가
    @PutMapping("/places/location")
    public long saveLocation(@RequestBody ArrayList<PlacesLocationDto> placesLocationDtoArrayList){
        return mPlacesService.updateLocation(placesLocationDtoArrayList);
    }

}
