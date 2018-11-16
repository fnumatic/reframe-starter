(ns cljs-reframe-template.styles
  (:require

      [garden.core :as g]))






(def styles
  [])




(defn inject-inline-style [document id style]
  (let [styles-el     (.getElementById document id)
        new-styles-el (.createElement document "style")]
    (.setAttribute new-styles-el "id" id)
    (.setAttribute new-styles-el "type" "text/css")
    (-> new-styles-el
        (.-innerHTML)
        (set! style))
    (if styles-el
      (-> styles-el
          (.-parentNode)
          (.replaceChild new-styles-el styles-el))
      (let []
        (.appendChild (.-head document) new-styles-el)
        new-styles-el))))

(defn inject-inline-link [document id link]
  (let [link-el     (.getElementById document id)
        new-link-el (.createElement document "link")]
    (.setAttribute new-link-el "id" id)
    (.setAttribute new-link-el "rel" "stylesheet")
    (.setAttribute new-link-el "href" link)

    (if link-el
      (-> link-el
          (.-parentNode)
          (.replaceChild new-link-el link-el))
      (let []
        (.appendChild (.-head document) new-link-el)
        new-link-el))))


(defn inject-trace-styles [document]
  (inject-inline-style document "--reframe-template--" (apply g/css styles))
  (inject-inline-link document "--bootstrap--"  "https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"))

