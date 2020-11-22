(ns cracking.ch2.q1)

(defn dedupe-list [xs]
  (loop [visited #{} xs xs nodups '()]
    (if (seq xs)
      (if (visited (first xs))
        (recur visited (rest xs) nodups)
        (recur (conj visited (first xs)) (rest xs) (cons (first xs) nodups)))
      (reverse nodups))))