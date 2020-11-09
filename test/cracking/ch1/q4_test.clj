(ns cracking.ch1.q4-test
  (:require [clojure.test :refer :all]
            [cracking.ch1.q4 :refer :all]))

(defn- shuffle-str
  [s]
  (apply str (shuffle (seq s))))

(deftest palindrome-permutation
  (let [p1 "abcdefgfedcba"
        p2 "abcdeffedcba"
        p3 "ababa"
        q1 "abcdefgfedcbah"
        q2 "notapal"]
  (is (pal-perm? (shuffle-str p1)))
  (is (pal-perm? (shuffle-str p2)))
  (is (pal-perm? (shuffle-str p3)))
  (is (not (pal-perm? (shuffle-str q1))))
  (is (not (pal-perm? (shuffle-str q2))))))
