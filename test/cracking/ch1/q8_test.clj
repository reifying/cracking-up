(ns cracking.ch1.q8-test
  (:require [clojure.test :refer :all]
            [cracking.ch1.q8 :refer :all]))

(defn- to-vec-2d [coll]
  (into [] (map vec coll)))

(defn- test-zero-matrix [expected input-matrix]
  (is (= expected
         (-> input-matrix
             to-array-2d
             zero-matrix
             to-vec-2d))))

(deftest rotate-matrix
  (test-zero-matrix
   [[0 0]
    [0 3]]
   [[0 1]
    [2 3]])
  (test-zero-matrix
   [[5 0 2]
    [0 0 0]
    [6 0 8]]
   [[5 1 2]
    [3 0 5]
    [6 7 8]])
  (test-zero-matrix
   [[0 0 0 0]
    [0 0 0 0]
    [8 0 10 11]
    [12 0 14 15]]
   [[1 0 2 3]
    [4 0 6 7]
    [8 9 10 11]
    [12 13 14 15]]))

