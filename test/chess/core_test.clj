(ns chess.core-test
  (:require [expectations :refer :all]
            [chess.core :refer :all]))

;; An empty string
(expect 0 (sum-a-string ""))
