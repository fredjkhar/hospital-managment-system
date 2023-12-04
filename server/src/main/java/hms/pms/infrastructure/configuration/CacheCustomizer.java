package hms.pms.infrastructure.configuration;

import org.springframework.boot.autoconfigure.cache.CacheManagerCustomizer;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class CacheCustomizer implements CacheManagerCustomizer<ConcurrentMapCacheManager> {

    @Override
    public void customize(ConcurrentMapCacheManager cacheManager) {
        if (cacheManager != null) {
            cacheManager.setCacheNames(Arrays.asList("admissions", "admissionRequests", "beds", "discharges",
                    "patients", "prescriptions", "rooms", "staff", "wards"));
        }
    }
}
