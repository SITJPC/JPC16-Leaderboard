package th.ac.kmutt.sit.jpc16.leaderboard.component

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import android.webkit.WebView
import android.webkit.WebViewClient
import th.ac.kmutt.sit.jpc16.leaderboard.BuildConfig
import th.ac.kmutt.sit.jpc16.leaderboard.component.client.WebView

@Composable
fun Background() {
	WebView(
		modifier = Modifier.fillMaxSize(),
		url = "file:///android_asset/background.html",
		webViewClient = webViewClient
	)
}

@Composable
@Preview(showBackground = true, widthDp = 960, heightDp = 540)
fun BackgroundPreview() {
	Background()
}

private val webViewClient = object : WebViewClient() {
	override fun onPageFinished(view: WebView?, url: String?) {
		if (BuildConfig.DEBUG) {
			view?.loadUrl("javascript:initBubble(false)")
		} else {
			view?.loadUrl("javascript:initBubble(true)")
		}
	}
}