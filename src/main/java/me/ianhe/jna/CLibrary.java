package me.ianhe.jna;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Platform;

/**
 * @author iHelin
 * @since 2018/9/27 17:07
 */
public interface CLibrary extends Library {

    CLibrary INSTANCE = Native.loadLibrary((Platform.isWindows() ? "msvcrt" : "c"), CLibrary.class);

    void printf(String format, Object... args);
}