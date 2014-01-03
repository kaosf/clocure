(ns clocure.core-test
  (:require [clojure.test :refer :all]
            [clocure.core :refer :all]))

(deftest human-test
  (let
    [human (->Human
             'nagisa
             "美墨なぎさ"
             "なぎさ" "美墨"
             "なぎさ" "みすみ"
             "nagisa" "misumi"
             '(black))]
    (testing "Human"
      (is (=
        '(:id
          :name
          :first-name      :family-name
          :first-name-kana :family-name-kana
          :first-name-en   :family-name-en
          :after-transforming)
        (keys human))))))
