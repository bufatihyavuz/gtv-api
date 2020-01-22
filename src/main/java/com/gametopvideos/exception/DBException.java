package com.gametopvideos.exception;

public class DBException {

    //SQL execution error
    public static class BadExecution extends AbstractException
    {
        private static final long serialVersionUID = 1000000L;
        public BadExecution(String msg) {
            super(msg);
        }
    }

    //No data exist where we expect at least one row
    public static class NoData extends AbstractException
    {
        private static final long serialVersionUID = 1000001L;
        public NoData(String msg) {
            super(msg);
        }
    }

    //Multiple rows exist where we expect only single row
    public static class MuchData extends AbstractException
    {
        private static final long serialVersionUID = 1000002L;
        public MuchData(String msg) {
            super(msg);
        }
    }

    //Invalid parameters error
    public static class InvalidParam extends AbstractException
    {
        private static final long serialVersionUID = 1000003L;
        public InvalidParam(String msg) {
            super(msg);
        }
    }
}
