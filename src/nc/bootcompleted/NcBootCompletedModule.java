package nc.bootcompleted;

import org.appcelerator.kroll.KrollModule;
import org.appcelerator.kroll.annotations.Kroll;

import org.appcelerator.titanium.TiApplication;
import org.appcelerator.kroll.common.Log;

@Kroll.module(name="NcBootCompleted", id="nc.bootcompleted")
public class NcBootCompletedModule extends KrollModule
{
	private static final String TAG = "NcBootCompletedModule";

	public NcBootCompletedModule()
	{
		super();
	}

	@Kroll.onAppCreate
	public static void onAppCreate(TiApplication app)
	{
		Log.d(TAG, "inside onAppCreate");
	}
}