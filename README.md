# cljs-reframe-template

A starter [re-frame](https://github.com/Day8/re-frame) application.

frontend routing with [reitit](https://github.com/metosin/reitit)

dev tooling with [Figwheel Main](https://github.com/bhauman/figwheel-main)

styles per inline injection with [CSS Garden](https://github.com/noprompt/garden)

## Development Mode

### Start Cider from Emacs:

Put this in your Emacs config file:

```
(setq cider-cljs-lein-repl
	"(do (require 'figwheel-sidecar.repl-api)
         (figwheel-sidecar.repl-api/start-figwheel!)
         (figwheel-sidecar.repl-api/cljs-repl))")
```

Navigate to a clojurescript file and start a figwheel REPL with `cider-jack-in-clojurescript` or (`C-c M-J`)

### Compile application

```
lein fig:build
```

### Run application:



Figwheel will automatically push cljs changes to the browser.

Wait a bit, then browse to [http://localhost:3500](http://localhost:3500).

