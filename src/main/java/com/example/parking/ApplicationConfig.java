package com.example.parking;

import org.geolatte.geom.json.GeolatteGeomModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    GeolatteGeomModule geolatteModule(){
        return new GeolatteGeomModule();
    }
    
}
