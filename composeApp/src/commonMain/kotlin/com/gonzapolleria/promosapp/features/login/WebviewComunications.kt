package com.gonzapolleria.promosapp.features.login


import com.multiplatform.webview.jsbridge.IJsMessageHandler
import com.multiplatform.webview.jsbridge.JsMessage
import com.multiplatform.webview.jsbridge.dataToJsonString
import com.multiplatform.webview.web.WebViewNavigator
import com.multiplatform.webview.jsbridge.processParams

class WebJsMessageHandler : IJsMessageHandler {

    override fun handle(
        message: JsMessage,
        navigator: WebViewNavigator?,
        callback: (String) -> Unit
    ) {
        val param = processParams<MessageWebModel>(message)
        var data: MessageWebModel? = null
        data = if(param.message == "Girar"){
            MessageWebModel("GirarOK")
        }else{
            MessageWebModel("Error")
        }

        callback(dataToJsonString(data))
    }

    override fun methodName(): String {
        return "MessageWeb"
    }

}