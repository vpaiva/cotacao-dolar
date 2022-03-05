package br.com.vpaiva.resource.response.exceptions;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.jboss.resteasy.reactive.server.ServerExceptionMapper;

public class ValidationExceptionMapper {

  @ServerExceptionMapper
  public Response toResponse(ConstraintViolationException ex) {
    String message = ex.getConstraintViolations().stream().findFirst()
        .map(ConstraintViolation::getMessage).orElse("");

    return Response.status(Status.BAD_REQUEST).entity(message).build();
  }
}
