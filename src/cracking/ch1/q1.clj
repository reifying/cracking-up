(ns cracking.ch1.q1)

(defn unique?
  "Are all elements in the sequence unique? Restrain implementation from using
   other data structures."
  [xs]
  (= (count xs) (count (dedupe (sort xs)))))
