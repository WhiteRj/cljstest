# CljsTest

This project uses
[Re-Natal](https://github.com/drapanjanas/re-natal) bootstrapper,
[Reagent](https://reagent-project.github.io/) lib as React interface wrapper,
[re-frame](https://github.com/Day8/re-frame) for app state and logic.

## Usage

### Prepare environment:
1. install [Leiningen](http://leiningen.org)
1. `npm i -g react-native-cli`
1. `npm i -g re-natal`
1. `git clone https://github.com/mizinin/cljstest.git`
1. `cd cljstest && npm i`

### Running app on Android in dev mode.

##### On avd emulator:
1. start emulator
1. `re-natal use-android-device avd`
1. `re-natal use-figwheel`
1. `lein figwheel android`
1. `npm start` (in separate tty)
1. `cd android && ./gradlew installDebug` (in separate tty)
1. start app manually

##### On real device:
1. `adb reverse tcp:8081 tcp:8081`
1. `adb reverse tcp:3449 tcp:3449`
1. `re-natal use-android-device real`
1. `re-natal use-figwheel`
1. `lein figwheel android`
1. `npm start` (in separate tty)
1. `cd android && ./gradlew installDebug` (in separate tty)
1. start app manually
