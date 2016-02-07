(defproject clocure "1.0.3"
  :description "Clojure + Precure = Clocure"
  :url "http://github.com/kaosf/clocure"
  :license {:name "MIT"
            :url "http://opensource.org/licenses/MIT"}
  :dependencies [[org.clojure/clojure "1.8.0"]]
  :signing {:gpg-key "ka.kaosf@gmail.com"}
  :deploy-repositories
    [["releases" {:url "https://github.com/kaosf/clocure"
                  :signing {:gpg-key "5A789E33"}}]
     ["snapshots" "https://github.com/kaosf/clocure/tags"]])
