package io.github.hongweihao.starter.localdatetime.serializer.autoconfig;

import io.github.hongweihao.starter.localdatetime.serializer.LocalDateTimeToOffsetDateTimeSerializer;
import io.github.hongweihao.starter.localdatetime.serializer.OffsetDateTimeToLocalDateTimeDeserializer;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

/**
 * <p>
 * Jackson配置类
 * </p>
 *
 * @author Karl
 * @since 2023/11/10 23:54
 */
@Configuration
public class JacksonLocalDateTimeConfig {
    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jacksonObjectMapperCustomization() {
        return jacksonObjectMapperBuilder ->
                // 自定义LocalDateTime的序列化方式
                jacksonObjectMapperBuilder
                        .serializerByType(LocalDateTime.class, new LocalDateTimeToOffsetDateTimeSerializer())
                        .deserializerByType(LocalDateTime.class, new OffsetDateTimeToLocalDateTimeDeserializer());
    }
}