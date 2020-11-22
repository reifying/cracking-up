(ns cracking.ch2.q1-test
  (:require [clojure.test :refer :all]
            [cracking.ch2.q1 :refer :all]))

(deftest dups-removed
  (is (= '(1 2 3 4 5) (dedupe-list '(1 2 3 2 4 5 1)))))