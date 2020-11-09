(ns cracking.ch1.q3-test
  (:require [clojure.test :refer :all]
            [cracking.ch1.q3 :refer :all]))

(defn- required-size
  "Size of char array required if all spaces are replaced with '%20'"
  [s]
  (+ (count s) (* 2 (count (filter #(= \space %) s)))))

(defn- padded
  [s len]
  (apply str s (repeat (- len (count s)) " ")))

(defn- inputs [s]
  [(char-array (padded s (required-size s))) (count s)])

(defn- match? [s ch-array]
  (= s (apply str ch-array)))

(deftest replacing-spaces
  (is (match? "blah%20blah%20blah"
         (apply urlify (inputs "blah blah blah"))))
  (is (match? "blahblah"
         (apply urlify (inputs "blahblah")))))