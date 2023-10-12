package com.avijit.scalerproductproject.Controller;

import com.avijit.scalerproductproject.DTO.ProductDto.ExceptionHandleDto;
import com.avijit.scalerproductproject.Exception.NoDataFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdvices {
    @ExceptionHandler(NoDataFound.class)
    public ResponseEntity<String> noDataFindException(Exception exception){
//        ExceptionHandleDto exceptionHandleDto = new ExceptionHandleDto();
//        exceptionHandleDto.setMsg(exception.getMessage());
//        return  new ResponseEntity<>(exceptionHandleDto, HttpStatus.NOT_FOUND);
        return  new ResponseEntity<>("Phat gya",HttpStatus.NOT_FOUND);
    }
}
