package com.edu.supermarket.supermarkms.exceptions;

public class ProductsNotFoundException extends RuntimeException{

    public ProductsNotFoundException(String message){
        super(message);
    }
}
