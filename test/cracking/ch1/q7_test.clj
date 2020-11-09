(ns cracking.ch1.q7-test
  (:require [clojure.test :refer :all]
            [cracking.ch1.q7 :refer :all]))

(deftest rotate-matrix
  (is (= [[0 1 2]
          [3 4 5]
          [6 7 8]]
         (rotate-90 [[6 3 0]
                     [7 4 1]
                     [8 5 2]]))))