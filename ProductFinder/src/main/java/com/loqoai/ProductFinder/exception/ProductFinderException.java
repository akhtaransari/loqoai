package com.loqoai.ProductFinder.exception;

/**
 * The ProductFinderException class represents a custom exception specific to the ProductFinder application.
 * It extends RuntimeException to allow unchecked exceptions to be thrown and handled as needed.
 */
public class ProductFinderException extends RuntimeException {

    /**
     * Constructor to create a new instance of ProductFinderException with a specified message.
     *
     * @param message The detail message for the exception.
     *                This message provides information about the nature of the exception.
     */
    public ProductFinderException(String message) {
        super(message);
    }
}
