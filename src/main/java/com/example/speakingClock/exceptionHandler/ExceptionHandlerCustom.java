package com.example.speakingClock.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
@ControllerAdvice
public class ExceptionHandlerCustom {

    @ExceptionHandler({
            NumberFormatException.class,
            ArrayIndexOutOfBoundsException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorResponse
    handleException(Exception ex)
    {
        return new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(), ex.getMessage());
    }
}
