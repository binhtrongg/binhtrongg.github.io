package com.example.chonqjetairwebapp.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class AsyncConfig implements AsyncConfigurer {

    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5); // Số lượng luồng tối thiểu trong pool
        executor.setMaxPoolSize(10); // Số lượng luồng tối đa trong pool
        executor.setQueueCapacity(25); // Số lượng tác vụ trong hàng đợi chờ xử lý
        executor.setThreadNamePrefix("AsyncThread-"); // Tiền tố tên luồng
        executor.initialize();
        return executor;
    }
}
