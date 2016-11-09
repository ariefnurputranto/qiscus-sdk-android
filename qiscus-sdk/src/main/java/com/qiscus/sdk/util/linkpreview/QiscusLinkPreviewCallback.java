package com.qiscus.sdk.util.linkpreview;

/**
 * Callback that is invoked with before and after the loading_qiscus_link_preview of a link preview
 * 
 */
public interface QiscusLinkPreviewCallback {

	void onPre();

	/**
	 * 
	 * @param sourceContent
	 *            Class with all contents from preview.
	 * @param isNull
	 *            Indicates if the content is null.
	 */
	void onPos(QiscusSourceContent sourceContent, boolean isNull);
}
