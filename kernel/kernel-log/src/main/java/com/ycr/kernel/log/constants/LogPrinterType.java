package com.ycr.kernel.log.constants;

import android.support.annotation.IntDef;

import static com.ycr.kernel.log.constants.LogPrinterType.CONSOLE;
import static com.ycr.kernel.log.constants.LogPrinterType.FILE;

/**
 * 日志输出的
 * Created by yuchengren on 2018/7/12.
 */
@IntDef({CONSOLE,FILE})
public @interface LogPrinterType {
	/**
	 * 控制台输出
	 */
	int CONSOLE = 0;
	/**
	 * 文件输出
	 */
	int FILE = 1;
}