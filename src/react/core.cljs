(ns react.core)

(def react-native
  (js/require "react-native"))

(def app-registry
  (aget react-native "AppRegistry"))

(def ui-manager
  (aget react-native "UIManager"))

(def back-handler
  (aget react-native "BackHandler"))

(def dimensions
  (aget react-native "Dimensions"))

(def dimensions-get
  (aget dimensions "get"))

(def platform
  (aget react-native "Platform"))

(def interaction-manager
  (aget react-native "InteractionManager"))

(def alert
  (aget react-native "Alert"))

(def image
  (aget react-native "Image"))

(def activity-indicator
  (aget react-native "ActivityIndicator"))

(def text
  (aget react-native "Text"))

(def text-input
  (aget react-native "TextInput"))

(def touchable-without-feedback
  (aget react-native "TouchableWithoutFeedback"))

(def touchable-opacity
  (aget react-native "TouchableOpacity"))

(def touchable-highlight
  (aget react-native "TouchableHighlight"))

(def touchable-native-feedback
  (aget react-native "TouchableNativeFeedback"))

(def view
  (aget react-native "View"))

(def scroll-view
  (aget react-native "ScrollView"))

(def list-view
  (aget react-native "ListView"))

(def list-view-ds
  (aget list-view "DataSource"))

(def refresh-control
  (aget react-native "RefreshControl"))

(def status-bar
  (aget react-native "StatusBar"))
