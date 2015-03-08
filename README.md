# Clocure

Clojure + Precure = Clocure

Distibuted on [Clojars](https://clojars.org/clocure).

[![Clojars Project](http://clojars.org/clocure/latest-version.svg)](http://clojars.org/clocure)

## Usage

Add `[clocure "1.0.2"]` to your `project.clj`.

```clj
(defproject yourproject "0.1.0-SNAPSHOT"
  ; ...
  :dependencies [
                 ; ...
                 [clocure "1.0.2"]
                 ; ...
                 ]
  ; ...
  )
```

You can use many symbols about Precure!

```clj
(ns yourproject
  (:require [clocure.core :refer :all]))

(transform nagisa) ;=> black
; デュアル・オーロラ・ウェイブ！！
; 光の使者、キュアブラック！
; ふたりはプリキュア！
; 闇の力のしもべ達よ！
; とっととお家に帰りなさい！

(transform nagisa :with honoka) ;=> [black white]
; なぎさ・ほのか「デュアル・オーロラ・ウェイブ！！」
; ブラック「光の使者、キュアブラック！」
; ホワイト「光の使者、キュアホワイト！」
; ブラック・ホワイト「ふたりはプリキュア！」
; ホワイト「闇の力のしもべ達よ！」
; ブラック「とっととお家に帰りなさい！」
```

## License

[MIT](http://opensource.org/licenses/MIT)

Copyright (C) 2013-2015 ka
