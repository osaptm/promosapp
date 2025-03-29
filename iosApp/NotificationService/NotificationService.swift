import UserNotifications
import UIKit

class NotificationService: UNNotificationServiceExtension {

    var contentHandler: ((UNNotificationContent) -> Void)?
    var bestAttemptContent: UNMutableNotificationContent?

    override func didReceive(_ request: UNNotificationRequest, withContentHandler contentHandler: @escaping (UNNotificationContent) -> Void) {
        self.contentHandler = contentHandler
        bestAttemptContent = (request.content.mutableCopy() as? UNMutableNotificationContent)
        
        if let bestAttemptContent = bestAttemptContent {
            // 1. Obtener el diccionario `fcm_options` desde `userInfo`
            if let fcmOptions = bestAttemptContent.userInfo["fcm_options"] as? [String: Any],
               let imageURLString = fcmOptions["image"] as? String,
               let imageURL = URL(string: imageURLString) {
                
                downloadAndAttachImage(url: imageURL, to: bestAttemptContent)
            } else {
                // Si no hay imagen, entregar la notificación tal cual
                contentHandler(bestAttemptContent)
            }
        }
    }
    
    private func downloadAndAttachImage(url: URL, to content: UNMutableNotificationContent) {
        let task = URLSession.shared.downloadTask(with: url) { (location, response, error) in
            if let location = location {
                let tmpDirectory = NSTemporaryDirectory()
                let tmpFile = "file://".appending(tmpDirectory).appending(url.lastPathComponent)
                let tmpUrl = URL(string: tmpFile)!
                
                try? FileManager.default.moveItem(at: location, to: tmpUrl)
                
                if let attachment = try? UNNotificationAttachment(identifier: "image", url: tmpUrl, options: nil) {
                    content.attachments = [attachment]
                }
            }
            self.contentHandler?(content)
        }
        task.resume()
    }
    
    override func serviceExtensionTimeWillExpire() {
        if let contentHandler = contentHandler, let bestAttemptContent = bestAttemptContent {
            contentHandler(bestAttemptContent)
        }
    }
}
