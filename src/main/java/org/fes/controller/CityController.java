package org.fes.controller;

import org.fes.bean.dto.CityDto;
import org.fes.service.implementation.CityServiceImpl;
import org.fes.service.interfaces.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/city")
public class CityController {

    private final ICityService cityService;

    @Autowired
    public CityController(final ICityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping
    public ResponseEntity<Optional<List<CityDto>>> getCities() {
        return new ResponseEntity<>(cityService.getCities(), HttpStatus.OK);
    }

}
