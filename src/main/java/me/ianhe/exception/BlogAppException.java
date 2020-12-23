package me.ianhe.exception;

class BlogAppException extends Exception {

    private static final long serialVersionUID = -1642464697243698132L;

    /**
     * 可以给自定义异常增加成员变量，用以保存额外的异常信息
     */
    private final String command;

    public BlogAppException(String command) {
        super(command);
        this.command = command;
    }

    @Override
    public String toString() {
        return "Exception happened when executing command " + command;
    }
}
