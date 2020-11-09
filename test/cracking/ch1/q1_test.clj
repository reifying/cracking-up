(ns cracking.ch1.q1-test
  (:require [clojure.test :refer :all]
            [cracking.ch1.q1 :refer [unique?]]))

(deftest sequence-uniqueness
  (is (not (unique? "abcdaf")))
  (is (unique? "abcdefg"))
  (is (not (unique? [:a :b :c :d :a :f])))
  (is (unique? [:a :b :c :d :e :f :g])))
