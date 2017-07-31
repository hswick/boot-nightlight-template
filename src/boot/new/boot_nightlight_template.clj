(ns boot.new.boot-nightlight-template
  (:require [boot.new.templates :refer [renderer name-to-path ->files]]))

(def render (renderer "boot-nightlight-template"))

(defn boot-nightlight-template
  "Input project name to create nightlight boot template"
  [name]
  (let [data {:name name
              :sanitized (name-to-path name)}]
    (println (str "Generating fresh boot-nightlight-template project: " name "."))
    (->files data
             ["src/{{sanitized}}/core.clj" (render "core.clj" data)]
             ["build.boot" (render "build.boot" data)]
             [".gitignore" (render ".gitignore" data)]
             ["README.MD" (render "README.MD" data)]
             ["LICENSE" (render "LICENSE" data)])))