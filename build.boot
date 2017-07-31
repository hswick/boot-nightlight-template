(def project 'boot-nightlight-template/boot-template)
(def version "0.1.2")

(set-env! :resource-paths #{"resources" "src"}
          ;; uncomment this if you write tests for your template:
          ;; :source-paths   #{"test"}
          :dependencies   '[[org.clojure/clojure "1.8.0"]
                            [boot/new "0.5.2"]
                            [adzerk/boot-test "1.2.0" :scope "test"]]
          :repositories (conj (get-env :repositories)
                              ["clojars" {:url "https://clojars.org/repo"
                                          :username (System/getenv "CLOJARS_USER")
                                          :password (System/getenv "CLOJARS_PASS")}]))

(task-options!
 jar {:main 'boot.new.boot-nightlight-template.core}
 pom {:project     project
      :version     version
      :description "Template for clojure projects with nightlight."
      :url         "https://github.com/hswick/boot-nightlight-template"
      :scm         {:url "https://github.com/hswick/boot-nightlight-template"}
      :license     {"Eclipse Public License"
                    "http://www.eclipse.org/legal/epl-v10.html"}}
 push {:repo "clojars"})

(deftask build
  "Build and install the project locally."
  []
  (comp (pom) (jar) (install)))

(deftask deploy []
  (comp
    (pom)
    (jar)
    (push)))

(require '[adzerk.boot-test :refer [test]]
         '[boot.new :refer [new]])