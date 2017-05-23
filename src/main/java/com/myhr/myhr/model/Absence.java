package com.myhr.myhr.model;

import org.springframework.data.annotation.Id;

/**
 * Created by pavel_000 on 23/05/2017.
 */
public class Absence {
    @Id
    private String id;
    private String userId;
    private String organizationId;

    Absence(final Builder builder) {
        this.id = builder.id;
        this.userId = builder.userId;
        this.organizationId = builder.organizationId;
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

    public static class Builder {
        private String id;
        private String userId;
        private String organizationId;

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

        public Absence build() {
            return new Absence(this);
        }
    }
}
