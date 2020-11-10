(ns cracking.ch1.q7-test
  (:require [clojure.test :refer :all]
            [cracking.ch1.q7 :refer :all]))

(defn- to-vec-2d [coll]
  (into [] (map vec coll)))

(deftest rotate-matrix
  (is (= [[6 3 0]
          [7 4 1]
          [8 5 2]]
         (to-vec-2d
          (rotate-90
           (to-array-2d [[0 1 2]
                         [3 4 5]
                         [6 7 8]]))))))