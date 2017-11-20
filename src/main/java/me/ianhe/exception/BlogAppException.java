package me.ianhe.exception;

public class BlogAppException extends Exception {
	private static final long serialVersionUID = 1L;

	private String command;// 可以给自定义异常增加成员变量，用以保存额外的异常信息

	public BlogAppException(String command) {
		this.command = command;
	}

	public String toString() {
		return "Exception happened when executing command " + command;
	}
}
