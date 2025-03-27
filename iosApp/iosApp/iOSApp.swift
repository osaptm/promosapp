import SwiftUI
import ComposeApp
import FirebaseCore

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
