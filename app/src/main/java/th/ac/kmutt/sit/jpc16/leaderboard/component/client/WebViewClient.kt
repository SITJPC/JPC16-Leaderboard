package th.ac.kmutt.sit.jpc16.leaderboard.component.client

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient

@Composable
fun WebView(
	modifier: Modifier = Modifier,
	url: String,
	webViewClient: WebViewClient = WebViewClient()
) {
	AndroidView(
		modifier = modifier,
		factory = { context ->
			WebView(context).apply {
				settings.javaScriptEnabled = true
				settings.loadWithOverviewMode = true
				settings.useWideViewPort = true
				settings.setSupportZoom(false)
				this.webViewClient = webViewClient
			}
		},
		update = { webView ->
			webView.loadUrl(url)
			webView.setLayerType(View.LAYER_TYPE_HARDWARE, null);
		}
	)
}