(def project 'boot-nightlight-template/boot-template)
(def version "0.1.2")

(set-env! :resource-paths #{"resources" "src"}
          ;; uncomment this if you write tests for your template:
          ;; :source-paths   #{"test"}
          :dependencies   '[[org.clojure/clojure "1.8.0"]
                            [boot/new "0.5.2"]
                            [adzerk/boot-test "1.2.0" :scope "test"]
                            [adzerk/bootlaces "0.1.13" :scope "test"]])

(require '[adzerk.bootlaces :refer :all])

(bootlaces! version)

(task-options!
 pom {:project     project
      :version     version
      :description "Template for clojure projects with nightlight."
      :url         "https://github.com/hswick/boot-nightlight-template"
      :scm         {:url "https://github.com/hswick/boot-nightlight-template"}
      :license     {"Eclipse Public License"
                    "http://www.eclipse.org/legal/epl-v10.html"}})

(deftask build
  "Build and install the project locally."
  []
  (comp (pom) (jar) (install)))

(require '[adzerk.boot-test :refer [test]]
         '[boot.new :refer [new]])