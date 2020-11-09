(ns cracking.ch1.q2)

(defn permutation?
  "Is one sequence a permutation of the other?"
  [xs1 xs2]
  (= (sort xs1) (sort xs2)))