package nc.bootcompleted;

import org.appcelerator.kroll.KrollProxy;

import ti.modules.titanium.android.TiBroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;

public class BootCompletedReceiver extends TiBroadcastReceiver
{
	private static final String BOOT_COMPLETED_JS_KEY = "boot_completed_js";
	private static final String BOOT_COMPLETED_JS_FILE = "boot_completed.js";
	
	public BootCompletedReceiver()
	{
		this("");
	}
	
	public BootCompletedReceiver(KrollProxy proxy)
	{
		super(proxy);
	}
	
	public BootCompletedReceiver(String url)
	{
		super(url);
	}

	@Override
	public void onReceive(Context context, Intent intent)
	{
		ActivityInfo info = null;
		try {
			String componentName = getClass().getName();
			info = context.getPackageManager().getReceiverInfo(new ComponentName(context, componentName), PackageManager.GET_META_DATA);			
		}
		catch (NameNotFoundException e) {}
		if (info == null) {
			return;
		}
		Bundle b = info.metaData;
		String rebootScript = BOOT_COMPLETED_JS_FILE;
		if (b != null && b.containsKey(BOOT_COMPLETED_JS_KEY)) {
			rebootScript = b.getString(BOOT_COMPLETED_JS_KEY);
		}
		setUrl(rebootScript);
		super.onReceive(context, intent);
	}
}