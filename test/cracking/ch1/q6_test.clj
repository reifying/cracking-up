(ns cracking.ch1.q6-test
  (:require [clojure.test :refer :all]
            [cracking.ch1.q6 :refer :all]))

(deftest string-compression
  (is (= "a2b1c5a3" (compressed "aabcccccaaa")))
  (is (= "aBc" (compressed "aBc")))
  (is (= "a" (compressed "a")))
  (is (= "" (compressed ""))))
