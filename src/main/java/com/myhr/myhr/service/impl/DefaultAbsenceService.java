package com.myhr.myhr.service.impl;

import com.myhr.myhr.model.Absence;
import com.myhr.myhr.repository.DefaultAbsenceRepository;
import com.myhr.myhr.service.AbsenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by pavel_000 on 23/05/2017.
 */
@Service
public class DefaultAbsenceService implements AbsenceService {

    private final DefaultAbsenceRepository absenceRepository;

    @Autowired
    public DefaultAbsenceService(DefaultAbsenceRepository absenceRepository) {
        this.absenceRepository = absenceRepository;
    }

    @Override
    public Flux<Absence> getAllForUserId(final String userId) {
        return absenceRepository.findByUserId(userId);
    }
}
