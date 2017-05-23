package com.myhr.myhr.repository;

import com.myhr.myhr.model.Absence;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by pavel_000 on 23/05/2017.
 */
@Repository
public interface DefaultAbsenceRepository extends ReactiveMongoRepository<Absence, String> {
    Flux<Absence> findByUserId(final String userId);
}
