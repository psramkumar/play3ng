package com.triadic.configs;

import play.Logger;
import play.api.mvc.Action;
import play.api.mvc.AnyContent;

public class HtmlAsset {
	/** load an HTML page from public/app ending with .html */
	public static Action<AnyContent> to(String path, String html) {
		Logger.debug("Getting HTML at directory {}, file {}.html", path, html);
		return controllers.Assets.at(path, html + ".html", true);
	}
}
