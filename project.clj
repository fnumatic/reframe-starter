(defproject cljs-reframe-template "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [org.clojure/clojurescript "1.10.597"]
                 [reagent "0.10.0"]
                 [re-frame "0.12.0"]
                 [garden "1.3.9"]
                 [metosin/reitit "0.4.2"]
                 [metosin/reitit-schema "0.4.2"]
                 [metosin/reitit-frontend "0.4.2"]

                 [ns-tracker "0.4.0"]
                 [re-pressed "0.3.1" :exclusions [re-frame reagent]]]

  :plugins [[lein-cljsbuild "1.1.7"]]

  :min-lein-version "2.5.3"

  :source-paths ["src/clj" "src/cljs" "test/cljs"]

  :clean-targets ^{:protect false} ["resources/public/js/compiled" "target"
                                    "resources/public/css"]

  :profiles
  {:dev
   {:dependencies [[binaryage/devtools "1.0.0"]
                   [day8.re-frame/re-frame-10x "0.6.0"]
                   [com.bhauman/figwheel-main "0.2.3"]
                   [com.bhauman/rebel-readline-cljs "0.1.4"]
                   [cider/piggieback "0.4.2"]]
    :source-paths ["env/dev"]
    :resource-paths ["target"]
    :repl-options {:nrepl-middleware [cider.piggieback/wrap-cljs-repl]}}}



  :cljsbuild
  {:builds
   [

    {:id           "min"
     :source-paths ["src/cljs"]
     :compiler     {:main            cljs-reframe-template.core
                    :output-to       "resources/public/js/compiled/app.js"
                    :optimizations   :advanced
                    :closure-defines {goog.DEBUG false}
                    :pretty-print    false}}]}

  :aliases {"fig"       ["trampoline" "run" "-m" "figwheel.main"]
            "fig:build" ["trampoline" "run" "-m" "figwheel.main" "-b" "dev" "-r"]
            "fig:min"   ["run" "-m" "figwheel.main" "-O" "advanced" "-bo" "dev"]
            "ancient-all" ["update-in" ":plugins" "conj" "[lein-ancient \"0.6.15\"]"
                                                  "--" "ancient" "upgrade" ":interactive" ":all" ":check-clojure" ":no-tests"]
            "ancient" ["update-in" ":plugins" "conj" "[lein-ancient \"0.6.15\"]" "--" "ancient"]})



