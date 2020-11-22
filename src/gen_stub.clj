(ns gen-stub)

(defn -main [ch q]
  (let [src-ns (str "cracking.ch" ch ".q" q)]
    (spit (str "src/cracking/ch" ch "/q" q ".clj")
          (str "(ns " src-ns ")\n\n"))
    (spit (str "test/cracking/ch" ch "/q" q "_test.clj")
          (str "(ns cracking.ch" ch ".q" q "-test
  (:require [clojure.test :refer :all]
            [" src-ns " :refer :all]))\n\n"))))

