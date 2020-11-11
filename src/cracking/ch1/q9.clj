(ns cracking.ch1.q9)

(defn string-rotation?
  "Is s2 a rotation of s1?"
  [s1 s2]
  (and (= (count s1) (count s2))
       (clojure.string/includes? (str s2 s2) s1)))