import SwiftUI
import ComposeApp

@main
struct iOSApp: App {
    init() { InitKoinKt.initKoinIos() }
    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}