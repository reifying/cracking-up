(ns cracking.ch1.q5)

(defn one-edit-away?
  "Are two strings the same or off by a single char via either an insert,
   delete, or replace?"
  [s1 s2]
  (let [len1 (count s1)
        len2 (count s2)]
    (loop [diffs 0 i1 0 i2 0]
      (cond
        (< 1 diffs) false
        (and (<= len1 i1) (<= len2 i2)) true
        :else
        (cond
          (<= len1 i1) (recur (inc diffs) i1 (inc i2))
          (<= len2 i2) (recur (inc diffs) (inc i1) i2)
          (= (.charAt s1 i1) (.charAt s2 i2)) (recur diffs (inc i1) (inc i2))
          (= len1 len2) (recur (inc diffs) (inc i1) (inc i2))
          (< len1 len2) (recur (inc diffs) i1 (inc i2))
          (< len2 len1) (recur (inc diffs) (inc i1) i2))))))