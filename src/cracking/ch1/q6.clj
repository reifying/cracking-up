(ns cracking.ch1.q6)

(defn- compressed-or-orig [compressed orig]
  (let [s (apply str compressed)]
    (if (<= (count orig) (count s))
      orig
      s)))

(defn- append [compressed letter n]
  (conj compressed letter n))

(defn compressed
  "Return the counts of each letter (e.g., aaabbc => a3b2c1) unless the result's
   length excedes the original string's length"
  [s]
  (if-not (seq s) s
          (loop [prev (first s)
                 cur (second s)
                 n 1
                 xs (drop 2 s)
                 compressed []]
            (cond
              (nil? cur) (compressed-or-orig (append compressed prev n) s)
              (= cur prev) (recur cur (first xs) (inc n) (rest xs) compressed)
              :else (recur cur (first xs) 1 (rest xs) (append compressed prev n))))))