package br.com.ismadrade.infrastructure.config.exception.handler;

import br.com.ismadrade.infrastructure.config.exception.ErrorMessage;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class GlobalExceptionHandler implements ExceptionMapper<Exception> {

    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public Response toResponse(Exception e) {

        if(e instanceof IllegalArgumentException)
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity(new ErrorMessage(e.getMessage(), Response.Status.BAD_REQUEST.getStatusCode()))
                    .build();

        return Response
                .status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(new ErrorMessage("Erro interno! Por favor contate o suporte.", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode()))
                .build();
    }


}
