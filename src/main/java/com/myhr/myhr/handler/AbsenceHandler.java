package com.myhr.myhr.handler;

import com.myhr.myhr.model.Absence;
import com.myhr.myhr.service.AbsenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

/**
 * Created by pavel_000 on 23/05/2017.
 */
@Component
public class AbsenceHandler {

    private AbsenceService absenceService;

    @Autowired
    public AbsenceHandler(AbsenceService absenceService) {
        this.absenceService = absenceService;
    }

    public Mono<ServerResponse> getAllForUser(final ServerRequest request) {
        return ok().contentType(MediaType.APPLICATION_JSON).body(absenceService.getAllForUserId(request.pathVariable("userId")), Absence.class);
    }
}
