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

(deftest transform-test
  (testing "normal"
    (is (= black (transform nagisa))))
  (testing "splash-star"
    (is (let [p (transform saki)] (or (= p bloom) (= p bright))))))

(deftest transform-with-test
  (testing "black and white"
    (is (= [black white]
           (transform nagisa :with honoka)
           (transform nagisa :with [honoka])
           (transform honoka :with nagisa)
           (transform honoka :with [nagisa]))))
  (testing "melody and rhythm"
    (is (= [melody rhythm]
           (transform hibiki :with kanade)
           (transform kanade :with hibiki))))
  (testing "melody, rhythm and beat"
    (is (= [melody rhythm beat]
           (transform hibiki :with kanade ellen))))
  (testing "melody, rhythm, beat and muse"
    (is (= [melody rhythm beat muse]
           (transform hibiki :with kanade ellen ako))))
  (testing "flora, mermaid and twinkle"
    (are [humans] (= [flora mermaid twinkle]
                     (apply transform humans))
         [haruka :with minami kirara]
         [minami :with haruka kirara]
         [kirara :with haruka minami])
    (are [humans] (not= [flora mermaid twinkle]
                        (apply transform humans))
         [haruka]
         [haruka :with minami]
         [haruka :with kirara]
         [minami]
         [minami :with haruka]
         [minami :with kirara]
         [kirara]
         [kirara :with haruka]
         [kirara :with minami])))
