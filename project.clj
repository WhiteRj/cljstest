(defproject tapaz "1.0.0"
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [org.clojure/clojurescript "1.10.238"]
                 [com.cognitect/transit-cljs "0.8.243"]
                 [reagent "0.7.0" :exclusions [cljsjs/react
                                               cljsjs/react-dom
                                               cljsjs/react-dom-server
                                               cljsjs/create-react-class]]
                 [re-frame "0.10.5"]
                 [cljs-react-navigation "0.1.2"]]
  :plugins [[lein-cljsbuild "1.1.7"]]
  :clean-targets ["target/" "index.ios.js" "index.android.js"]
  :aliases {"prod-build" ^{:doc "Recompile code with simple profile."}
                         ["do" "clean"
                          ["with-profile" "prod" "cljsbuild" "once"]]
            "test-cljs"  ^{:doc "Run cljs tests."}
                         ["with-profile" "test" "doo" "node" "test" "once"]}
  :jvm-opts ["-XX:+IgnoreUnrecognizedVMOptions" "--add-modules=java.xml.bind"]
  :profiles {:dev  {:plugins [[lein-figwheel "0.5.14"]]
                    :dependencies [[figwheel-sidecar "0.5.14"]
                                   [com.cemerick/piggieback "0.2.2"]]
                    :repl-options {:nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]}
                    :cljsbuild    {:builds
                                   {:ios
                                    {:source-paths ["src" "env/dev"]
                                     :figwheel     true
                                     :compiler     {:main          "env.ios.main"
                                                    :output-to     "target/ios/not-used.js"
                                                    :output-dir    "target/ios"
                                                    :optimizations :none}}
                                    :android
                                    {:source-paths ["src" "env/dev"]
                                     :figwheel     true
                                     :compiler     {:main          "env.android.main"
                                                    :output-to     "target/android/not-used.js"
                                                    :output-dir    "target/android"
                                                    :optimizations :none}}}}}
             :test {:plugins      [[lein-doo "0.1.7"]]
                    :dependencies [[day8.re-frame/test "0.1.5"]]
                    :cljsbuild    {:builds
                                   {:test
                                    {:source-paths ["src" "test"]
                                     :compiler     {:main          "test-cljs.runner"
                                                    :output-to     "target/test/test.js"
                                                    :output-dir    "target/test"
                                                    :optimizations :none
                                                    :target        :nodejs}}}}}
             :prod {:cljsbuild {:builds
                                {:ios
                                 {:source-paths ["src" "env/prod"]
                                  :compiler     {:main               "env.ios.main"
                                                 :output-to          "index.ios.js"
                                                 :output-dir         "target/ios"
                                                 :static-fns         true
                                                 :fn-invoke-direct   true
                                                 :optimize-constants true
                                                 :optimizations      :simple
                                                 :closure-defines    {"goog.DEBUG" false}
                                                 :language-in        :ecmascript5}}
                                 :android
                                 {:source-paths ["src" "env/prod"]
                                  :compiler     {:main               "env.android.main"
                                                 :output-to          "index.android.js"
                                                 :output-dir         "target/android"
                                                 :static-fns         true
                                                 :fn-invoke-direct   true
                                                 :optimize-constants true
                                                 :optimizations      :simple
                                                 :closure-defines    {"goog.DEBUG" false}
                                                 :language-in        :ecmascript5}}}}}})
