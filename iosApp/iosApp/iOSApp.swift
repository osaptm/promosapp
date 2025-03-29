import SwiftUI
import FirebaseMessaging
import FirebaseAnalytics
import FirebaseCore
import ComposeApp
import UserNotifications

class AppDelegate: NSObject, UIApplicationDelegate {
    func application(_ application: UIApplication, continue userActivity: NSUserActivity, restorationHandler: @escaping ([UIUserActivityRestoring]?) -> Void) -> Bool {
            if userActivity.activityType == NSUserActivityTypeBrowsingWeb,
               let url = userActivity.webpageURL {
                if (PassageHelper().handle(url: url.absoluteString)) {
                    print("Handled by Passage")
                }

                return true
            }
            print("No valid URL in user activity.")
            return false
        }

     func application(_ application: UIApplication,
            didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey : Any]? = nil) -> Bool {
           FirebaseApp.configure()
           AppInitializerPush.shared.onApplicationStart() // -> Lo iniciamos pero sin peticion de NotificationPermission
           return true
      }

     func application(_ application: UIApplication, didRegisterForRemoteNotificationsWithDeviceToken deviceToken: Data) {
         Messaging.messaging().apnsToken = deviceToken
         print("Token Firebase: \(deviceToken)") // Envía este token a tu servidor
     }
    
       
    func application(_ application: UIApplication, didReceiveRemoteNotification userInfo: [AnyHashable : Any]) async -> UIBackgroundFetchResult {
         NotifierManager.shared.onApplicationDidReceiveRemoteNotification(userInfo: userInfo)
         return UIBackgroundFetchResult.newData
     }
    
    func applicationDidBecomeActive(_ application: UIApplication) {
        application.applicationIconBadgeNumber = 0
        UIApplication.shared.applicationIconBadgeNumber = 0
    }
}

@main
struct iOSApp: App {
    
    // register app delegate for Firebase setup
      @UIApplicationDelegateAdaptor(AppDelegate.self) var delegate

    init() { InitKoinKt.doInitKoinIos() }
    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}
