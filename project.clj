(defproject cljs-reframe-template "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [org.clojure/clojurescript "1.10.439"]
                 [reagent "0.8.1"]
                 [re-frame "0.10.6"]
                 [garden "1.3.6"]
                 [metosin/reitit "0.2.9"]
                 [metosin/reitit-schema "0.2.9"]
                 [metosin/reitit-frontend "0.2.9"]

                 [ns-tracker "0.3.1"]
                 [re-pressed "0.2.2" :exclusions [re-frame reagent]]]

  :plugins [[lein-cljsbuild "1.1.7"]]

  :min-lein-version "2.5.3"

  :source-paths ["src/clj" "src/cljs" "test/cljs"]

  :clean-targets ^{:protect false} ["resources/public/js/compiled" "target"
                                    "resources/public/css"]

  :profiles
  {:dev
   {:dependencies [[binaryage/devtools "0.9.10"]
                   [day8.re-frame/re-frame-10x "0.3.6"]
                   [com.bhauman/figwheel-main "0.1.9"]
                   [com.bhauman/rebel-readline-cljs "0.1.4"]
                   [cider/piggieback "0.3.10"]]
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



