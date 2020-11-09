(ns cracking.ch1.q2-test
  (:require [clojure.test :refer :all]
            [cracking.ch1.q2 :refer :all]))

(deftest sequence-permutations
  (is (permutation? [:a :b :c :d] [:d :c :b :a]))
  (is (not (permutation? [:a :b :c :d] [:k :c :b :a]))))

