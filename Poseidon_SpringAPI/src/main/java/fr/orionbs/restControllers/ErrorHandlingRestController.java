package fr.orionbs.restControllers;

import fr.orionbs.models.ErrorAnswer;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
public class ErrorHandlingRestController {

    @ExceptionHandler(value = NoHandlerFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorAnswer errorNotFound(NoHandlerFoundException exception) {
        return new ErrorAnswer("404_NotFound", exception.getMessage());
    }

    /**@ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(value = HttpStatus.METHOD_NOT_ALLOWED)
    @ResponseBody
    public ErrorAnswer errorMethodNotAllowed(HttpRequestMethodNotSupportedException exception) {
        return new ErrorAnswer("405_MethodNotAllowed", exception.getMessage());
    }**/

    /**@ExceptionHandler(value = Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorAnswer errorInternalServer(Exception exception) {
        return new ErrorAnswer("500_InternalServerError", exception.getMessage());
    }**/
}
