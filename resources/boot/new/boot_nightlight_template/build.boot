(set-env!
  :resource-paths #{"src"}
  :dependencies '[[org.clojure/clojure "1.9.0-alpha15"]
                  [nightlight "1.9.2" :scope "test"]])

(require
  '[nightlight.boot :refer [nightlight]]
  '{{name}}.core)

(deftask night []
  (comp
    (wait)
    (nightlight :port 4000)))

(deftask run []
  (with-pass-thru _
    ({{name}}.core/-main)))