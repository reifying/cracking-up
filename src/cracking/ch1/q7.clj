(ns cracking.ch1.q7)

(require '[clojure.pprint :refer [pprint]])

(defn- new-coords [n x y]
  [y (dec (- n x))])

(defn printm [m]
  (doall (map pprint m))
  (println))


(defn all-coords [n]
  (for [x (range n) y (range n)] [x y]))

(defn- replace [matrix n visited x y v]
  (let [[x2 y2]  (new-coords n x y)
        next-val (aget matrix x2 y2)]
    (aset matrix x2 y2 v)
    (printm matrix)
    (if (visited [x2 y2])
      visited
      (recur matrix n (conj visited [x2 y2]) x2 y2 next-val))))


(defn rotate-90
  "Rotate N x N matrix 90 degrees in place"
  [matrix]
  (let [n (count (first matrix))]
    (loop [xs (all-coords n)
           visited #{}]
      (cond (not (seq xs)) matrix
            (visited (first xs)) (recur (rest xs) visited)
            :default (let [[x y] (first xs)
                           v (aget matrix x y)]
                       (recur (rest xs) (replace matrix n visited x y v)))))))
