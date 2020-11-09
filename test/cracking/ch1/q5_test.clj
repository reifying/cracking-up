(ns cracking.ch1.q5-test
  (:require [clojure.test :refer :all]
            [cracking.ch1.q5 :refer :all]))

(deftest one-away
  (is (one-edit-away? "pale" "ple"))
  (is (one-edit-away? "pales" "pale"))
  (is (one-edit-away? "pale" "bale"))
  (is (one-edit-away? "pale" "pale"))
  (is (not (one-edit-away? "pale" "bake"))))
