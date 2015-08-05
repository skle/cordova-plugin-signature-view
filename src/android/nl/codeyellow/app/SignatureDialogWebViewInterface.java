/**
 * JavaScript bridge interface to the WebView that gets shown above
 * the signature pad.  This can be used to enable or disable the OK
 * button.
 */
package nl.codeyellow.app;

import android.webkit.JavascriptInterface;

public class SignatureDialogWebViewInterface {
	protected SignatureDialogFragment fragment;
	
	public SignatureDialogWebViewInterface(SignatureDialogFragment fragment) {
		this.fragment = fragment;
	}

	@JavascriptInterface
	public void disableOkButton() {
		this.fragment.toggleOkButton(false);
	}

	@JavascriptInterface
	public void enableOkButton() {
		this.fragment.toggleOkButton(true);
	}
}
