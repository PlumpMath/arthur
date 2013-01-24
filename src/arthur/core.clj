
(ns arthur.core
  (:refer-clojure :exclude [==])
  (:use clojure.core.logic))

(defrel dev x)
(defrel pm x)

(fact dev 'rod)
(fact dev 'gavd)
(fact dev 'craig)
(fact dev 'tidy)
(fact dev 'stevea)
(fact dev 'andy)
(fact dev 'alpha)
(fact dev 'kdawg)
(fact dev 'david)
(fact dev 'bendy)
(fact dev 'steff)

(fact pm 'pete)
(fact pm 'ines)
(fact pm 'ian)

(defn teamo [xs]
  (conde
    ((fresh [x y ys z zs]
      (conso x ys xs)
      (conso y zs ys)
      (conso z () zs)
      (!= x y)
      (!= x z)
      (!= y z)))))

(defn leado [xs]
  (conde
    ((fresh [x y]
      (conso x y xs)
      (man x)
      (meno y)))))

(run 3 [q]
  (fresh [x y z]
    (== q [x y z])
    (pm x)
    (dev y)
    (dev z)
    (teamo [x y z])))

