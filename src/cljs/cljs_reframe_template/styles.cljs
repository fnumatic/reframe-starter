(ns cljs-reframe-template.styles
  (:require

      [garden.core :as g]))






(def styles
  [])



(defn inject-node! [old-node new-node document]
  (if old-node
    (-> old-node
        (.-parentNode)
        (.replaceChild new-node old-node))
    (let []
      (.appendChild (.-head document) new-node)
      new-node)))

(defn inject-inline-style [document id style]
  (let [old-style (.getElementById document id)
        new-style (.createElement document "style")
        attr      #(.setAttribute new-style %1 %2)]
    (attr "id" id)
    (attr "type" "text/css")
    (-> new-style
        (.-innerHTML)
        (set! style))
    (inject-node! old-style new-style document)))

(defn inject-inline-link [document id link]
  (let [old-link (.getElementById document id)
        new-link (.createElement document "link")
        attr     #(.setAttribute new-link %1 %2)]
    (attr  "id" id)
    (attr  "rel" "stylesheet")
    (attr  "href" link)

    (inject-node! old-link new-link document)))


(defn inject-trace-styles [document]
  (inject-inline-style document "--reframe-template--" (apply g/css styles))
  (inject-inline-link document "--bootstrap--"  "https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"))

