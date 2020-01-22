package com.gametopvideos.exception;

public class IOException {

    public static class WrongParameters extends AbstractException{

        private static final long serialVersionUID = 1000010L;
        public WrongParameters(String message) {
            super(message);
        }
    }
}
