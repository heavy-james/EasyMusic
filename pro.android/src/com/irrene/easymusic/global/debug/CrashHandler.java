package com.irrene.easymusic.global.debug;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.Thread.UncaughtExceptionHandler;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import com.irrene.easymusic.global.GlobalActionManager;
import com.irrene.easymusic.global.feedback.FeedBackUtil;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;

public class CrashHandler implements UncaughtExceptionHandler{

    public static final String TAG = "CrashHandler";  
    
    // 系统默认的UncaughtException处理类  
    private Thread.UncaughtExceptionHandler mDefaultHandler;  
    // CrashHandler实例  
    private static CrashHandler instance;  
    // 程序的Context对象  
    private Context mContext;  
    // 用来存储设备信息和异常信息  
    private Map<String, String> infos = new HashMap<String, String>();  
  
    // 用于格式化日期,作为日志文件名的一部分  
   // private DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");  
    private String nameString;  
  
    /** 保证只有一个CrashHandler实例 */  
    private CrashHandler() {  
    }  
  
    /** 获取CrashHandler实例 ,单例模式 */  
    public static synchronized CrashHandler getInstance(Context context) {  
    	LogUtil.d(TAG, "CrashHandler getInstance");
    	if(instance == null){
    		instance = new CrashHandler();
    		instance.init(context);
    	}
        return instance;  
    }  
    
    
    /** 
     * 初始化 
     *  
     * @param context 
     */  
    public void init(Context context) {  
    	LogUtil.d(TAG, "CrashHandler init");
        mContext = context;  
        collectDeviceInfo();
        // 获取系统默认的UncaughtException处理器  
        mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();  
    }  
    
    
	@Override
	public void uncaughtException(Thread thread, Throwable ex) {
		LogUtil.d(TAG, "uncaughtException-->" + LogUtil.saveLogMode());
		GlobalActionManager.getInstance().sendGlobalAction(GlobalActionManager.ACTION_TERMINATE_APP, null);
		String crashLogInfo = getCrashInfo(ex);
		LogUtil.e(TAG, "crash info --->" + crashLogInfo);
		FeedBackUtil.feedbackByMail();
		
	}
	
	
	/** 
     * 收集设备参数信息 
     *  
     * @param ctx 
     */  
    public void collectDeviceInfo() {  
    	LogUtil.d(TAG, "collectDeviceInfo");
    	//*
        try {  
            PackageManager pm = mContext.getApplicationContext().getPackageManager();  
            PackageInfo pi = pm.getPackageInfo(mContext.getPackageName(),  
                    PackageManager.GET_ACTIVITIES);  
            if (pi != null) {  
                String versionName = pi.versionName == null ? "null"  
                        : pi.versionName;  
                String versionCode = pi.versionCode + "";  
                infos.put("versionName", versionName);  
                infos.put("versionCode", versionCode);  
            }  
        } catch (NameNotFoundException e) {  
            LogUtil.e(TAG, "an error occured when collect package info" + e.getMessage());  
        }
        //*/
        LogUtil.d(TAG, "collectDeviceInfo version info over");
        Field[] fields = Build.class.getDeclaredFields();  
        for (Field field : fields) {  
            try {  
                field.setAccessible(true);  
                infos.put(field.getName(), field.get(null).toString());  
                LogUtil.d(TAG, field.getName() + " : " + field.get(null));  
            } catch (Exception e) {  
            	LogUtil.e(TAG, "an error occured when collect crash info" + e.getMessage());  
            }  
        } 
        LogUtil.d(TAG, "collectDeviceInfo buid info over");
    }  
    
	
	/** 
     * 保存错误信息到文件中 
     *  
     * @param ex 
     * @return 返回文件名称,便于将文件传送到服务器 
     */  
    private String getCrashInfo(Throwable ex) {  
    	LogUtil.d(TAG, "getcrashinfo");
        StringBuffer sb = new StringBuffer();  
        for (Map.Entry<String, String> entry : infos.entrySet()) {  
            String key = entry.getKey();  
            String value = entry.getValue();  
            sb.append(key + "=" + value + "\n");  
        }  
  
        Writer writer = new StringWriter();  
        PrintWriter printWriter = new PrintWriter(writer);  
        ex.printStackTrace(printWriter);  
        Throwable cause = ex.getCause();  
        while (cause != null) {  
            cause.printStackTrace(printWriter);  
            cause = cause.getCause();  
        }  
        printWriter.close();  
        String result = writer.toString();  
        sb.append(result);  
        return sb.toString();  
    } 
    
    public static void notifyNativeCrash(){
    	LogUtil.e(TAG, "notifyNativeCrash called");
    	System.exit(0);
    }

}
