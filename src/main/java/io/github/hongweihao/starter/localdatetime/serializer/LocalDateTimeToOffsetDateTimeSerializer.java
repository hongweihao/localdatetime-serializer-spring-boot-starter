package io.github.hongweihao.starter.localdatetime.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

/**
 * <p>
 * 自定义LocalDateTime 序列化方式
 * LocalDateTime 换成 OffsetDateTime，目的是增加时区信息
 * </p>
 *
 * @author Karl
 * @since 2023/11/9 23:34
 */
public class LocalDateTimeToOffsetDateTimeSerializer extends JsonSerializer<LocalDateTime> {
    @Override
    public void serialize(LocalDateTime value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        ZoneOffset offset = OffsetDateTime.now().getOffset();
        OffsetDateTime offsetDateTime = OffsetDateTime.of(value, offset);
        gen.writeString(offsetDateTime.toString());
    }
}