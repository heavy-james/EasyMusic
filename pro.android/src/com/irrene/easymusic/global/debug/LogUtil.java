package com.irrene.easymusic.global.debug;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ConcurrentLinkedQueue;

import com.google.gson.Gson;

import android.content.Context;
import android.os.Process;
import android.util.Log;

public class LogUtil {
	private static final String TAG = "EasyMusicLog";
	private static boolean mDebugMode = false;
	private static boolean mSaveLog = false;
	private static int mLogLevel = 1;
	private static String mSavePath = "/sdcard/android_dev_wiki_log";
	private static boolean mAppTerminated = false;
	public static final int LEVEL_VERBOSE = 0;
	public static final int LEVEL_DEBUG = 1;
	public static final int LEVEL_INFO = 2;
	public static final int LEVEL_WARN = 3;
	public static final int LEVEL_ERROR = 4;

	public static void init(Context context, int logLevel, boolean debug,
			boolean saveLog, String savePath) {
		mLogLevel = logLevel;
		mSavePath = savePath;
		mDebugMode = debug;
		mSaveLog = saveLog;
		Writer.deleteLogFile();
		Log.d(TAG, "LogUtil init level-->" + logLevel + "debug-->" + debug
				+ "; saveLog-->" + saveLog + "; savepath-->" + savePath);
	}

	public static void v(String tag, String content) {
		if (canPrint(LEVEL_VERBOSE)) {
			Log.v(TAG, "[" + tag + "]:" + content);
		}
		if (mSaveLog) {
			Writer.recordActionInfoLog(new ActionInfo("VERBOSE", TAG, "[" + tag
					+ "]:" + content));
		}
	}

	public static void d(String tag, String content) {
		if (canPrint(LEVEL_DEBUG)) {
			Log.v(TAG, "[" + tag + "]:" + content);
		}
		if (mSaveLog) {
			Writer.recordActionInfoLog(new ActionInfo("DEBUG", TAG, "[" + tag
					+ "]:" + content));
		}
	}

	public static void i(String tag, String content) {
		if (canPrint(LEVEL_INFO)) {
			Log.v(TAG, "[" + tag + "]:" + content);
		}
		if (mSaveLog) {
			Writer.recordActionInfoLog(new ActionInfo("INFO", TAG, "[" + tag
					+ "]:" + content));
		}
	}

	public static void w(String tag, String content) {
		if (canPrint(LEVEL_WARN)) {
			Log.v(TAG, "[" + tag + "]:" + content);
		}
		if (mSaveLog) {
			Writer.recordActionInfoLog(new ActionInfo("WARN", TAG, "[" + tag
					+ "]:" + content));
		}
	}

	public static void e(String tag, String content) {
		if (canPrint(LEVEL_ERROR)) {
			Log.v(TAG, "[" + tag + "]:" + content);
		}
		if (mSaveLog) {
			Writer.recordActionInfoLog(new ActionInfo("ERROR", TAG, "[" + tag
					+ "]:" + content));
		}
	}

	private static boolean canPrint(int logLevel) {
		return mDebugMode || logLevel >= mLogLevel;
	}

	public static void releaseSource() {
		mAppTerminated = true;
	}

	static class ActionInfo {
		private static SimpleDateFormat mDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
		public String mLevel = "";
		public String mTag = "";
		public String mContent = "";

		public ActionInfo(String level, String tag, String content) {
			mLevel = level;
			mTag = tag;
			mContent = content;
		}

		public String toString() {
			StringBuffer sb = new StringBuffer();
			sb.append(mDateFormat.format(new Date()) + " ");
			sb.append(Process.myTid() + " ");
			sb.append(Process.myPid() + " ");
			sb.append(mLevel + "/" + mTag + ": " + mContent);
			return sb.toString();
		}
	}

	static class Writer {

		public static ConcurrentLinkedQueue<ActionInfo> tempQueue = new ConcurrentLinkedQueue<ActionInfo>();

		/**
		 * 记录行为信息
		 * 
		 * @param ai
		 */
		public static synchronized void recordActionInfoLog(ActionInfo ai) {
			if(!mAppTerminated){
				tempQueue.add(ai);
			}
			if (!WriteThread.isWriteThreadLive) {
				new WriteThread().start();
			}
		}

		/**
		 * 打开日志文件并写入日志
		 * 
		 * @return
		 * **/
		public static void recordStringLog(String text) {// 新建或打开日志文件
			File file = new File(mSavePath);
			if (!file.exists()) {
				try {
					Log.d(TAG, "recordStringLog create log file-->" + mSavePath);
					file.createNewFile();
				} catch (IOException e) {
					Log.e(TAG, "行为日志：在" + mSavePath + "创建文件失败！" + e);
				}
			}
			if (!file.exists()) {
				Log.d(TAG, "recordStringLog log file does not exist");
				return;
			}
			FileWriter filerWriter = null;
			BufferedWriter bufWriter = null;
			try {
				filerWriter = new FileWriter(file, true);// 后面这个参数代表是不是要接上文件中原来的数据，不进行覆盖
				bufWriter = new BufferedWriter(filerWriter);
				bufWriter.write(text);
				bufWriter.newLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (bufWriter != null) {
					try {
						bufWriter.close();
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
				if (filerWriter != null) {
					try {
						filerWriter.close();
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
			}
		}

		/**
		 * 判断日志文件是否存在
		 * 
		 * @return
		 */
		public static boolean isExitLogFile() {
			File file = new File(mSavePath);
			if (file.exists() && file.length() > 3) {
				return true;
			} else {
				return false;
			}
		}

		/**
		 * 删除日志文件
		 */
		public static void deleteLogFile() {
			File file = new File(mSavePath);
			if (file.exists()) {
				file.delete();
			}
		}
	}

	static class WriteThread extends Thread {
		public static boolean isWriteThreadLive = false;// 写日志线程是否已经在运行了

		public WriteThread() {
			isWriteThreadLive = true;
		}

		@Override
		public void run() {
			isWriteThreadLive = true;
			while (!Writer.tempQueue.isEmpty()) {// 对列不空时
				try {
					// 写日志到SD卡
					Writer.recordStringLog(Writer.tempQueue.poll().toString());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			isWriteThreadLive = false;// 队列中的日志都写完了，关闭线程（也可以常开 要测试下）
		}
	}

	public static boolean saveLogMode() {
		return mSaveLog;
	}

	public static String getLogFileName() {
		return mSavePath;
	}
	
	public static boolean isLogSaveCompleted(){
		return !WriteThread.isWriteThreadLive;
	}
}
