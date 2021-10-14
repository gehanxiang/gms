package com.gms.providerUser.Utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class WebUtils {

    private static ObjectMapper objectMapper = new ObjectMapper();

    @SneakyThrows
    public static void writeJson(HttpServletResponse response, Object object) {
        writeData(response, objectMapper.writeValueAsString(object), MediaType.APPLICATION_JSON_VALUE);
    }

    public static void writeData(HttpServletResponse response, String data, String type) {
        try {
            response.setContentType(type);
            response.setCharacterEncoding("utf-8");
            response.getWriter().print(data);
            response.getWriter().flush();
            response.getWriter().close();
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }
}
