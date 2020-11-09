(ns cracking.ch1.q4)

(defn pal-perm?
  "Is the string possibly a palindrome based on letter counts alone?"
  [s]
  (->> s
       frequencies
       (map val)
       (filter odd?)
       count
       (>= 1)))
