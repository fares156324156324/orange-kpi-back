package com.example.backend_jenkins_app.Security;
    
    import org.springframework.boot.web.servlet.FilterRegistrationBean;
    import org.springframework.context.annotation.Bean;
    import org.springframework.context.annotation.Configuration;
    @Configuration
    public class JwtFilterConfig {
        @Bean
        public FilterRegistrationBean jwtFilter() {
            FilterRegistrationBean filter= new FilterRegistrationBean();
            filter.setFilter(new JwtFilter());
            // provide endpoints which needs to be restricted.
            // All Endpoints would be restricted if unspecified
           filter.addUrlPatterns("/api/v1/blog/restricted");
        return filter;
        }
    }