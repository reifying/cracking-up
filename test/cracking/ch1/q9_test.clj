(ns cracking.ch1.q9-test
  (:require [clojure.test :refer :all]
            [cracking.ch1.q9 :refer :all]))

(deftest string-rotations
  (is (string-rotation? "waterbottle" "erbottlewat"))
  (is (not (string-rotation? "abcde" "abbcde"))))