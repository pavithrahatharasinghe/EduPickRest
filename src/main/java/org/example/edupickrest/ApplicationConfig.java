package org.example.edupickrest;
import org.example.edupickrest.CORSFilter;
import org.glassfish.jersey.server.ResourceConfig;

import jakarta.ws.rs.ApplicationPath;

@ApplicationPath("api")
public class ApplicationConfig extends ResourceConfig {
    public ApplicationConfig() {
        packages("org.example.edupickrest");
        register(CORSFilter.class);
    }
}
