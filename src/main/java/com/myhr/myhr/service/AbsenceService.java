package com.myhr.myhr.service;

import com.myhr.myhr.model.Absence;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by pavel_000 on 23/05/2017.
 */
public interface AbsenceService {
    Flux<Absence> getAllForUserId(final String userId);
}
