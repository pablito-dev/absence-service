package com.myhr.myhr.service.impl;

import com.myhr.myhr.model.Absence;
import com.myhr.myhr.repository.DefaultAbsenceRepository;
import com.myhr.myhr.service.AbsenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

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
    public Flux<Absence> getAllForUserId(final ServerRequest request) {
        final String userId = request.pathVariable("userId");
        final String organizationId = request.pathVariable("organizationId");

        return absenceRepository.findByUserIdAndOrganizationId(userId, organizationId)
                .filter(matchStatus(request))
                .filter(matchStartDate(request, "absenceStartDate"))
                .filter(matchEndDate(request, "absenceEndDate"))
                .filter(matchStartDate(request, "requestStartDate"))
                .filter(matchEndDate(request, "requestEndDate"));
    }

    @Override
    public Flux<Absence> getAllForOrganization(final ServerRequest request) {
        final String organizationId = request.pathVariable("organizationId");

        return absenceRepository.findByOrganizationId(organizationId)
                .filter(matchStatus(request))
                .filter(matchStartDate(request, "absenceStartDate"))
                .filter(matchEndDate(request, "absenceEndDate"))
                .filter(matchStartDate(request, "requestStartDate"))
                .filter(matchEndDate(request, "requestEndDate"));
    }

    private Predicate<Absence> matchStatus(final ServerRequest request) {
        final List<String> requestStatuses = request.queryParams("status");

        return i -> requestStatuses.isEmpty() ||
                requestStatuses.stream().anyMatch(t -> t.equals(i.getStatus().toString()));
    }

    private Predicate<Absence> matchStartDate(final ServerRequest request, final String paramName) {
        final Optional<String> startDate = request.queryParam(paramName);

        return i -> !startDate.isPresent() ||
                i.getAbsenceStart().getTime() >= Long.valueOf(startDate.get());
    }

    private Predicate<Absence> matchEndDate(final ServerRequest request, final String paramName) {
        final Optional<String> endDate = request.queryParam(paramName);

        return i -> !endDate.isPresent() ||
                i.getAbsenceEnd().getTime() <= Long.valueOf(endDate.get());
    }
}
