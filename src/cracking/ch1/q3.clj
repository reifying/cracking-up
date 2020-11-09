(ns cracking.ch1.q3)

(def ^:private reversed-char-entity (reverse (char-array "%20")))

(defn- sub-space [ch]
  (if (= \space ch)
    reversed-char-entity
    ch))

(defn- reverse-copy! [ch-array i xs]
  (when (seq xs)
    (aset-char ch-array i ^char (first xs))
    (recur ch-array (dec i) (rest xs))))

(defn urlify
  "Inline replace all spaces in char array with URL encoded equiv."
  [^chars ch-array len]
  (when (< len (count ch-array))
    (->> ch-array
         reverse
         (drop-while #(= \space %))
         (map sub-space)
         flatten
         (reverse-copy! ch-array (dec (alength ch-array)))))
  ch-array)