(defproject clocure "0.1.0-SNAPSHOT"
  :description "Clojure + Precure = Clocure"
  :url "http://github.com/kaosf/clocure"
  :license {:name "MIT"
            :url "http://opensource.org/licenses/MIT"}
  :dependencies [[org.clojure/clojure "1.6.0"]]
  :signing {:gpg-key "ka.kaosf@gmail.com"}
  :deploy-repositories
    [["releases" {:url "https://github.com/kaosf/clocure"
                  :signing {:gpg-key "93535FB2"}}]
     ["snapshots" "https://github.com/kaosf/clocure/tags"]])
