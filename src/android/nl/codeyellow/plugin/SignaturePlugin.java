/**
 * A plugin for Apache Cordova (Phonegap) which will ask the user to
 * write his or her a signature, which gets captured into an image.
 *
 * Copyright (c) 2013-2016, Code Yellow B.V.
 *
 * Heavily based on Holly Schinsky's tutorial:
 * http://devgirl.org/2013/09/17/how-to-write-a-phonegap-3-0-plugin-for-android/
 */
package nl.codeyellow.plugin;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import nl.codeyellow.app.SignatureDialogFragment;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

public class SignaturePlugin extends CordovaPlugin {
	@Override
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext)
		throws JSONException
	{
		if (action.equals("new")) {
            // The JS bridge is responsible for setting all options,
            // and providing defaults.
			JSONObject options = args.getJSONObject(0);
            String okText = options.getString("okText");
            String htmlPage = options.getString("htmlPage");
            String title = options.getString("title");
			float strokeWidth = (float)options.getDouble("strokeWidth");

			Activity act = this.cordova.getActivity();
			FragmentManager fragmentManager = act.getFragmentManager();
			SignatureDialogFragment frag = new SignatureDialogFragment(title, htmlPage, okText, strokeWidth, callbackContext);
			frag.show(fragmentManager, "dialog");
			return true;
		} else {
			callbackContext.error("Unknown action: "+action);
			return false;
		}
	}
}
