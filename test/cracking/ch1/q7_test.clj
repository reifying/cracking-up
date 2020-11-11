(ns cracking.ch1.q7-test
  (:require [clojure.test :refer :all]
            [cracking.ch1.q7 :refer :all]))

(defn- to-vec-2d [coll]
  (into [] (map vec coll)))

(defn- test-rotate [expected input-matrix]
  (is (= expected
         (-> input-matrix
             to-array-2d
             rotate-90
             to-vec-2d))))

(deftest rotate-matrix
  (test-rotate
   [[2 0]
    [3 1]]
   [[0 1]
    [2 3]])
  (test-rotate
   [[6 3 0]
    [7 4 1]
    [8 5 2]]
   [[0 1 2]
    [3 4 5]
    [6 7 8]])
  (test-rotate
   [[12 8 4 0]
    [13 9 5 1]
    [14 10 6 2]
    [15 11 7 3]]
   [[0 1 2 3]
    [4 5 6 7]
    [8 9 10 11]
    [12 13 14 15]]))

