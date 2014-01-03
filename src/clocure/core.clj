(ns clocure.core)

(defrecord Human
  [id
   name
   first-name      family-name
   first-name-kana family-name-kana
   first-name-en   family-name-en
   after-transforming])

(defmacro def-human
  [first-name-en   family-name-en
   first-name      family-name
   first-name-kana family-name-kana
   & after-transforming]
  `(intern *ns*
    '~first-name-en ; use as an ID
    (->Human
      '~first-name-en ; use as an ID
      (str '~family-name '~first-name)
      (str '~first-name)      (str '~family-name)
      (str '~first-name-kana) (str '~family-name-kana)
      (clojure.string/capitalize '~first-name-en)
      (clojure.string/capitalize '~family-name-en)
      '~after-transforming)))

(defrecord Precure
  [id
   name    short-name
   name-en short-name-en
   before])

(defmacro def-precure
  [short-name-en short-name before]
  `(intern *ns*
    '~short-name-en ; use as an ID
    (->Precure
      '~short-name-en ; use as an ID
      (str "キュア" '~short-name) (str '~short-name)
      (str "Cure " (clojure.string/capitalize '~short-name-en))
      (clojure.string/capitalize '~short-name-en)
      '~before)))
