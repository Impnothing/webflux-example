package org.fes.service.interfaces;

import org.fes.bean.dto.CityDto;

import java.util.List;
import java.util.Optional;

public interface ICityService {
    Optional<List<CityDto>> getCities();
}
