package com.crisol.ahorrandome.dto.api.response;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Respuesta genérica para toda la API.
 * Estructura: { meta: {...}, data: T | null, errors: [...], warnings: [...] }
 *
 * @param <T> tipo del payload (objeto, lista, DTO paginado, etc.)
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> {
    private Meta meta; // Información de la respuesta (timestamp, status, etc.)
    private T data; // Payload con la respuesta principal
    private List<ErrorDetail> errors; // Lista de errores (si aplica)
    private List<String> warnings; // Lista de advertencias opcionales

    /**
     * Metadatos que acompañan cada respuesta.
     */
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Meta {
        private String transactionId; // Identificador único de la transacción
        private LocalDateTime timestamp; // Marca de tiempo de la respuesta
        private String status; // SUCCESS / ERROR
        private int httpCode; // Código HTTP
        private Pagination pagination; // Información de paginación (si aplica)
    }

    /**
     * Estructura de paginación, solo se llena en respuestas de listados.
     */
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor    
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Pagination {
        private int page; // Página actual
        private int size; // Tamaño de página
        private long totalElements; // Total de elementos
        private int totalPages; // Total de páginas
    }

    /**
     * Detalle de error para respuestas fallidas.
     */
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class ErrorDetail {
        private String code; // Código interno de error
        private String message; // Mensaje amigable
        private String field; // Campo afectado (opcional)
        private String exception; // Clase de la excepción (ej: UserNotFoundException)
        private Integer line; // Línea exacta donde ocurrió
        private String cause; // Causa raíz (si existe)
        private String path; // Path del endpoint donde ocurrió
    }

    // ---------------- Métodos estáticos para construir respuestas ----------------

    /**
     * Construye una respuesta de éxito sin paginación.
     */
    public static <T> ApiResponse<T> success(T data) {
        return ApiResponse.<T>builder()
                .meta(Meta.builder()
                        .transactionId(UUID.randomUUID().toString())
                        .timestamp(LocalDateTime.now())
                        .status(StatusApiResponse.SUCCESS.name())
                        .httpCode(HttpStatus.OK.value())
                        .build())
                .data(data)
                .build();
    }

    public static <T> ApiResponse<T> created(T data) {
        return ApiResponse.<T>builder()
                .meta(Meta.builder()
                        .transactionId(UUID.randomUUID().toString())
                        .timestamp(LocalDateTime.now())
                        .status(StatusApiResponse.CREATED.name())
                        .httpCode(HttpStatus.CREATED.value())
                        .build())
                .data(data)
                .build();
    }
    /**
     * Construye una respuesta de éxito con paginación.
     */
    public static <T> ApiResponse<T> success(T data, Pagination pagination) {
        return ApiResponse.<T>builder()
                .meta(Meta.builder()
                        .transactionId(UUID.randomUUID().toString())
                        .timestamp(LocalDateTime.now())
                        .status(StatusApiResponse.SUCCESS.name())
                        .httpCode(HttpStatus.OK.value())
                        .pagination(pagination)
                        .build())
                .data(data)
                .build();
    }

    /**
     * Construye una respuesta de error con múltiples errores.
     */
    public static <T> ApiResponse<T> error(
            ErrorDetail errorDetail,           
            HttpStatus httpStatus,
            StatusApiResponse status
            
            ) {

        return ApiResponse.<T>builder()
                .meta(Meta.builder()
                        .transactionId(UUID.randomUUID().toString())
                        .timestamp(LocalDateTime.now())
                        .status(status.name())
                        .httpCode(httpStatus.value())
                        .build())
                .errors(List.of(errorDetail))
                .build();
    }
}