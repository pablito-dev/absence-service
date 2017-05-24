package com.myhr.myhr.model;

import org.springframework.data.annotation.Id;

import java.util.Date;

/**
 * Created by pavel_000 on 23/05/2017.
 */
public class Absence {
    @Id
    private String id;
    private String userId;
    private String organizationId;
    private STATUS status;
    private Date absenceStart;
    private Date absenceEnd;
    private Date requestedAt;

    Absence(final Builder builder) {
        this.id = builder.id;
        this.userId = builder.userId;
        this.organizationId = builder.organizationId;
        this.status = builder.status;
        this.absenceStart = builder.absenceStart;
        this.absenceEnd = builder.absenceEnd;
        this.requestedAt = builder.requestedAt;
    }

    public Absence() {
    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public STATUS getStatus() {
        return status;
    }

    public Date getAbsenceStart() {
        return absenceStart;
    }

    public Date getAbsenceEnd() {
        return absenceEnd;
    }

    public Date getRequestedAt() {
        return requestedAt;
    }

    public static class Builder {
        private String id;
        private String userId;
        private String organizationId;
        private STATUS status;
        private Date absenceStart;
        private Date absenceEnd;
        private Date requestedAt;

        public Builder setId(final String id) {
            this.id = id;
            return this;
        }

        public Builder setUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder setOrganizationId(String organizationId) {
            this.organizationId = organizationId;
            return this;
        }

        public Builder setStatus(STATUS status) {
            this.status = status;
            return this;
        }

        public Builder setAbsenceStart(Date absenceStart) {
            this.absenceStart = absenceStart;
            return this;
        }

        public Builder setAbsenceEnd(Date absenceEnd) {
            this.absenceEnd = absenceEnd;
            return this;
        }

        public Builder setRequestedAt(Date requestedAt) {
            this.requestedAt = requestedAt;
            return this;
        }

        public Absence build() {
            return new Absence(this);
        }
    }

    public enum STATUS {
        NEW, ACCEPTED, REJECTED
    }
}
